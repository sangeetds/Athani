package `in`.gullak.exceptions

import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
open class StatusException(
  override val message: String?,

  @Serializable(HttpStatusSerializer::class)
  open val status: HttpStatusCode = HttpStatusCode.InternalServerError,

  @Contextual
  override val cause: Throwable? = null
) : Exception(message, cause)

val InternalServerError =
  StatusException("Sorry, we encountered an error and are working on it.",
    HttpStatusCode.InternalServerError
  )

object HttpStatusSerializer : KSerializer<HttpStatusCode> {
  override val descriptor = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)

  override fun deserialize(decoder: Decoder): HttpStatusCode {
    return HttpStatusCode.fromValue(decoder.decodeInt())
  }

  override fun serialize(encoder: Encoder, value: HttpStatusCode) {
    encoder.encodeString(value.toString())
  }
}