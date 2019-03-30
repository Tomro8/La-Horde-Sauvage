
package src.main.scala.serializer

class StateSerializer extends Serializer[State] {

  override def configure(map: util.Map[String, _], b: Boolean): Unit = {

  }

  override def serialize(s: String, t: State): Array[Byte] = {
    if (t == null)
      null
    else {
        val objectMapper = new ObjectMapper()
        objectMapper.writeValueAsString(t).getBytes
    }
  }

  override def close(): Unit = {

  }
}