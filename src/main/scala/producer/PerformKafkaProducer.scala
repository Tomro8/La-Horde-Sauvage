
package producer

import java.util.Properties

import model.Perform
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer

class PerformKafkaProducer() {
  val topic: String = "perform_topic"
  val props: Properties = new Properties()
  var producer: KafkaProducer[String, Perform] = _

  val init: Unit = {
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[serializer.PerformSerializer])
    props.put("acks","all")
    producer = new KafkaProducer[String, Perform](props)
  }

  def produce(perform: Perform) {
    try {
      val record = new ProducerRecord[String, Perform](this.topic, perform)
      producer.send(record)
      print("Perform produced: " + perform.toString)
    } catch {
      case e:Exception => e.printStackTrace()
    } finally {
      producer.close()
    }

  }
}