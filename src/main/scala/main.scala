import consumer.{PerformKafkaConsumer, StateKafkaConsumer}
import model.{Perform, State}
import producer.{PerformKafkaProducer, StateKafkaProducer}


object main {
  def main(args: Array[String]) {
  
    //Fleet produce into Kafka state_topic
    val stateProducer: StateKafkaProducer = new StateKafkaProducer()
    stateProducer.produce(new State(1, 82, 130, 45, -1, 90))
    stateProducer.produce(new State(2, 60, 89, 46, 0, 12))
    stateProducer.produce(new State(3, 17, 123, 45, -1, 17))
    stateProducer.produce(new State(4, 99, 119, 45, -1, 75))
    stateProducer.produce(new State(5, 27, 90, 45, 2, 93))
    stateProducer.produce(new State(6, 91, 100, 46, 1, 74))
    stateProducer.produce(new State(7, 35, 99, 46, 1, 86))
    stateProducer.produce(new State(8, 2, 108, 45, 2, 98))
    stateProducer.produce(new State(9, 11, 122, 45, 2, 100))
    stateProducer.produce(new State(10, 60, 84, 46, 0, 5))

    //Fleet produce into Kafka perform_topic
    val performProducer: PerformKafkaProducer = new PerformKafkaProducer()
    performProducer.produce(new Perform(1, 1233, 0.7.toFloat, 70))
    performProducer.produce(new Perform(2, 88, 0.1.toFloat, 90))
    performProducer.produce(new Perform(3, 780, 0.7.toFloat, 11))
    performProducer.produce(new Perform(4, 12, 0.1.toFloat, 99))
    performProducer.produce(new Perform(5, 236, 0.12.toFloat, 45))
    performProducer.produce(new Perform(6, 993, 0.9.toFloat, 91))
    performProducer.produce(new Perform(7, 71, 0.11.toFloat, 54))
    performProducer.produce(new Perform(8, 689, 0.45.toFloat, 46))
    performProducer.produce(new Perform(9, 9965, 0.92.toFloat, 31))
    performProducer.produce(new Perform(10, 5201, 0.87.toFloat, 65))

    //Consume Kafka state_topic to get Drone state info and write it into state_logs.txt file
    val stateConsumer: StateKafkaConsumer = new StateKafkaConsumer()
    stateConsumer.consume()

    //Consume Kafka perform_topic to get Drone performance info and write it into perform_logs.txt file
    val performConsumer: PerformKafkaConsumer = new PerformKafkaConsumer()
    performConsumer.consume()

  }
}