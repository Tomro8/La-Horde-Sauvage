import model.State
import producer.StateKafkaProducer

object ProduceTest extends App {
  //Generating our fleet
  val state: State = new State(6, 60, 139, 29, 90)

  //Fleet produce into Kafka topics
  val stateProducer: StateKafkaProducer = new StateKafkaProducer()
  stateProducer.produce(state)
}