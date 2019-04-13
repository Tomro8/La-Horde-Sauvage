
package producer

import java.util.Properties

import model.State
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer

class StateKafkaProducer() {
  val topic: String = "state_topic"
  val props: Properties = new Properties()
  var producer: KafkaProducer[String, State] = _

  val init: Unit = {
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[serializer.StateSerializer])
    props.put("acks","all") //Todo : what is that ?
    producer = new KafkaProducer[String, State](props)
  }

  def produce(state: State) {
    try {
      val record = new ProducerRecord[String, State](this.topic, state)
      producer.send(record)
      print("State produced: " + state.toString)
    } catch {
      case e:Exception => e.printStackTrace()
    } finally {
      //producer.close()
    }


  } 
}