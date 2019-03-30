
package src.main.scala.deserializer

class StateDeserializer extends Deserializer[State] {
  override def configure(map: util.Map[String, _], b: Boolean): Unit = {

  }
  override def deserialize(s: String, bytes: Array[Byte]): State = {
    val mapper = new ObjectMapper()
    val state = mapper.readValue(bytes, classOf[State])
    state
  }

  override def close(): Unit = {
      
  }
}