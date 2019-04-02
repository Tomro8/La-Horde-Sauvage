
package consumer

import java.util.Properties

import model.State
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import org.apache.kafka.common.serialization.StringDeserializer

import scala.collection.JavaConverters._

class StateKafkaConsumer() {
  val topics = List("perform_topic")
  val props:Properties = new Properties()

  props.put("group.id", "test")
  props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092")
  props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer])
  props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[deserializer.StateDeserializer])
  props.put("enable.auto.commit", "true") //Todo keep ?
  props.put("auto.commit.interval.ms", "1000") //Todo keep ?

  val consumer = new KafkaConsumer[String, State](props)
  consumer.subscribe(topics.asJava)

  def consume(): Unit = {
    try {
      while (true) {
        val records = consumer.poll(10)
        for (record<-records.asScala) {
          println("Offset:" + record.offset() + ", key: " + record.key() + ", value: " + record.value())
        }
      }
    } catch {
      case e:Exception => e.printStackTrace()
    } finally {
      consumer.close()
    }
  }

}