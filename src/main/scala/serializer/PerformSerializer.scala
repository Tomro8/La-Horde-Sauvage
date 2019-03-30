
package serializer

class PerformSerializer extends Serializer[Perform] {

  override def configure(map: util.Map[String, _], b: Boolean): Unit = {

  }

  override def serialize(s: String, t: Perform): Array[Byte] = {
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