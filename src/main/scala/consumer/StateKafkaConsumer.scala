
package consumer

import java.util.Properties

import model.State
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import org.apache.kafka.common.serialization.StringDeserializer

import scala.collection.JavaConverters._
import java.io._

class StateKafkaConsumer() {
  val topics = List("state_topic")
  val props:Properties = new Properties()
  val writer = new PrintWriter(new File("state_logs.txt"))


  props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092")
  props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer])
  props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[deserializer.StateDeserializer])
  props.put(ConsumerConfig.GROUP_ID_CONFIG, "myconsumergrp")
  //props.put("enable.auto.commit", "true") //Todo keep ?
  //props.put("auto.commit.interval.ms", "1000") //Todo keep ?

  val consumer = new KafkaConsumer[String, State](props)
  consumer.subscribe(topics.asJava)
  print("State consumer created, subscribed on state_topic ")

  def consume() {
    print("State consumer started to consume")
    try {
      //For this example, we are not going to consume continuously. Therefore we removed the while() loop
      //while (true) {
        val records = consumer.poll(5000)
        for (record<-records.asScala) {
          println("Offset:" + record.offset() + ", key: " + record.key() + ", value: " + record.value())
          store(record.value())
        }
      //}
    } catch {
      case e:Exception => e.printStackTrace()
    } finally {
      print("State Consumer Closed")
      consumer.close()
      writer.close()
    }
  }

  def store(state: State): Unit = {
    writer.write(state.toString + "\n")
  }

}