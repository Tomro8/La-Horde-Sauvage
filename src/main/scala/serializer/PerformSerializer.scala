
package serializer

import java.util

import com.fasterxml.jackson.databind.ObjectMapper
import model.Perform
import org.apache.kafka.common.serialization.Serializer

class PerformSerializer extends Serializer[Perform] {

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

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = { }
}