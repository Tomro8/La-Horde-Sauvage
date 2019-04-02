
package deserializer

import org.apache.kafka.common.serialization.Deserializer
import com.fasterxml.jackson.databind.ObjectMapper
import model.Perform
import java.util

class PerformDeserializer extends Deserializer[Perform] {
  override def deserialize(s: String, bytes: Array[Byte]): Perform = {
    val mapper = new ObjectMapper()
    val perform = mapper.readValue(bytes, classOf[Perform])
    perform
  }
  override def configure(map: util.Map[String, _], b: Boolean): Unit = {
  }
  override def close(): Unit = {
  }
}