import consumer.{PerformKafkaConsumer, StateKafkaConsumer}
import model.{Perform, State}
import producer.{PerformKafkaProducer, StateKafkaProducer}


object main {
  def main(args: Array[String]) {
/*
    //Generating our fleet
    val state: State = new State(6, 60, 150, 139, 29, 90)

    //Fleet produce into Kafka topics
    val stateProducer: StateKafkaProducer = new StateKafkaProducer()
    stateProducer.produce(state)

    //Consume Kafka topics to get Drone info and write it into files
    val stateConsumer: StateKafkaConsumer = new StateKafkaConsumer()
    stateConsumer.consume()

    //Consomer les deux topics en boucle l'un après l'autre. Ou alors consommer sur des threads différents ?
    // ==> on fait comme on le souhaite
*/

    val perf: Perform = new Perform(1, 1233, 0.7.toFloat, 90)

    val performProducer: PerformKafkaProducer = new PerformKafkaProducer()
    performProducer.produce(perf)

    val performConsumer: PerformKafkaConsumer = new PerformKafkaConsumer()
    performConsumer.consume()
  }
}