import consumer.StateKafkaConsumer

object ConsumeTest extends App {
  //Consume Kafka topics to get Drone info
  val stateConsumer: StateKafkaConsumer = new StateKafkaConsumer()
  stateConsumer.consume()
}