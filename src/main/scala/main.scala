import model.State
import producer.StateKafkaProducer


object main {
  def main(args: Array[String]) {

    val state: State = new State(6, 60, 139, 29, 90)

    val stateProducer: StateKafkaProducer = new StateKafkaProducer()
    stateProducer.produce(state)

  }
}