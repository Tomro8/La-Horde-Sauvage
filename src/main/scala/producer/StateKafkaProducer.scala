
package src.main.scala.producer

import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import src.main.scala.model.State

/*
object StateKafkaProducer {
  val props:Properties = new Properties()
  props.put("bootstrap.servers","192.168.1.100:9092")
  props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer","src.main.scala.serializer.StateSerializer")
  props.put("acks","all")
  val producer = new KafkaProducer[String, State](props)
  try{
    for(i <- 0 to 100) {
      val state = new State()
      val record = new ProducerRecord[String, State]("state_topic",i.toString,state)
      val metadata = producer.send(record)
      printf(s"sent record(key=%s value=%s) " +
        "meta(partition=%d, offset=%d)\n",
        record.key(), record.value(), metadata.get().partition(),
        metadata.get().offset());
    }
  }catch{
    case e:Exception => e.printStackTrace()
  }finally {
    producer.close()
  }
}
*/

class StateKafkaProducer() {
  private var props: Properties

  def this() {
    this()
  }

  def produce(state: State) {

  } 
}