
package producer

import java.util.Properties

import model.State
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer

class StateKafkaProducer() {
  private val topic: String = "state_topic"
  private val props: Properties = new Properties()
  private val producer: KafkaProducer[String, State] = new KafkaProducer[String, State](props)

  def this() {
    this()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
    props.put("value.serializer","src.main.scala.serializer.StateSerializer")
    props.put("acks","all")
  }

  def produce(state: State) {
    try {
      val record = new ProducerRecord[String, State](this.topic, state)
      producer.send(record)
    } catch {
      case e:Exception => e.printStackTrace()
    } finally {
      producer.close()
    }

  } 
}