
/*
package producer

import java.util.Properties

import model.Perform
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer

class PerformKafkaProducer() {
  private val topic: String = "perform_topic"
  private val props: Properties = new Properties()
  private val producer: KafkaProducer[String, Perform] = new KafkaProducer[String, Perform](props)

  def this() {
    this()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
    props.put("value.serializer","src.main.scala.serializer.PerformSerializer")
    props.put("acks","all")
  }

  def produce(perform: Perform) {
    try {
      val record = new ProducerRecord[String, Perform](this.topic, perform)
      producer.send(record)
    } catch {
      case e:Exception => e.printStackTrace()
    } finally {
      producer.close()
    }

  }
}
*/