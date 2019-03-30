import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord, RecordMetadata}
import org.apache.kafka.common.serialization.StringSerializer
import src.main.model.Drone

import scala.io.Source

object Producer extends App {

  val d: Drone = new Drone()

  val props: Properties = new Properties()
  props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
  props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
  props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])

  val producer: KafkaProducer[String, String] = new KafkaProducer[String, String](props)

  val key = "key1"
  val value = "value1"
  val record = new ProducerRecord[String, String]("test1", key, value)

  producer.send(record, (recordMetadata: RecordMetadata, exception: Exception) => {
    if (exception != null) {
      exception.printStackTrace()
    } else {
      println(s"Metadata about the sent record: $recordMetadata")
    }
  })

  producer.close()

  /*
  Source.fromFile("/shared_data/Functionnal_Data_Programming/TP/TP2/TP2 Kafka.pdf")
    .getLines()
    .drop(1)
    .foreach()
    */
}
