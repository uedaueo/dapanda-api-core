/*
 * This code is generated by blanco Framework.
 */
package blanco.restgenerator.util

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

/**
 * Utility class commonly used by blancoRestGenerator. This class is used in the source code
 * generated by the blancoRestGenerator.<br> This class is used from the source code generated by
 * the blancoRestGenerator. It is not recommended to calls it directly.
 *
 * @author blanco Framework
 * @since 2020.09.01
 */
class BlancoRestGeneratorKtRequestDeserializer<S : RequestHeader, T : ApiTelegram>
constructor(
    /** A valueClass passed from the standard deserializer. */
    val vc: Class<*>?
) : StdDeserializer<CommonRequest<S, T>>(vc) {
  /** Sets the implementation class of CommonRequest#info. */
  var infoClazz: Class<S>? = null

  /** Sets the implementation class of CommonRequest#telegram. */
  var telegramClazz: Class<T>? = null

  /**
   * deserialize JSON content into the value type this serializer handles
   *
   * @param jp Receives a JsonParse class.
   * @param ctxt Receives a DeserializationContext.
   * @return Parses JSON, packs it into a CommonRequest, and returns it.
   */
  override fun deserialize(jp: JsonParser?, ctxt: DeserializationContext?): CommonRequest<S, T>? {
    val node = jp?.codec?.readTree<JsonNode>(jp)
    var info: S? = null
    var telegram: T? = null
    val fieldIte = node?.fields()

    while (fieldIte != null && fieldIte.hasNext()) {
      val fieldEntry = fieldIte.next()
      val value = fieldEntry.value
      if (value != null) {
        if ("info".equals(fieldEntry.key, true)) {
          info = this.parseRequestHeader(value)
        } else if ("telegram".equals(fieldEntry.key, true)) {
          telegram = this.parseTelegram(value)
        }
      }
    }

    var retval: CommonRequest<S, T>? = null
    if (info != null) {
      retval = CommonRequest<S, T>(info, telegram)
    }

    return retval
  }

  /**
   * Parses RequestHeader.
   *
   * @param node Receives a JsonNode class.
   * @return Parses JSON, packs it into S, and returns it.
   */
  private fun parseRequestHeader(node: JsonNode): S {
    val mapper = ObjectMapper()
    val header = mapper.convertValue<S>(node, infoClazz)
    return header
  }

  /**
   * Parses ApiTelegram.
   *
   * @param node Receives a JsonNode class.
   * @return Parses JSON, packs it into T, and returns it.
   */
  private fun parseTelegram(node: JsonNode): T? {
    val mapper = ObjectMapper()
    val telegram = mapper.convertValue<T>(node, telegramClazz)
    return telegram
  }
}
