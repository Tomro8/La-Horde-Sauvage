import consumer.StateKafkaConsumer
import model.State
import producer.StateKafkaProducer


object main {
  def main(args: Array[String]) {

    //Generating our fleet
    val state: State = new State(6, 60, 139, 29, 90)

    //Fleet produce into Kafka topics
    val stateProducer: StateKafkaProducer = new StateKafkaProducer()
    stateProducer.produce(state)

    //Consume Kafka topics to get Drone info
    val stateConsumer: StateKafkaConsumer = new StateKafkaConsumer()

    //Consomer les deux topics en boucle l'un après l'autre. Ou alors consommer sur des threads différents ?

    //Ecrire dans deux fichiers différents ?

    //Peut-on lire et écrire en même temps dans les fichiers ?

  }
}