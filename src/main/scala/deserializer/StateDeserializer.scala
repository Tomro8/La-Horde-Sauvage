
package deserializer

import org.apache.kafka.common.serialization.Deserializer
import com.fasterxml.jackson.databind.ObjectMapper
import model.State
import java.util

class StateDeserializer extends Deserializer[State] {
  override def deserialize(s: String, bytes: Array[Byte]): State = {
    val mapper = new ObjectMapper()
    val state = mapper.readValue(bytes, classOf[State])
    state
  }
  override def configure(map: util.Map[String, _], b: Boolean): Unit = {
  }
  override def close(): Unit = {
  }
}