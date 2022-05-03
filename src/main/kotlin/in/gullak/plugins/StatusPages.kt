package `in`.gullak.plugins

import `in`.gullak.exceptions.InternalServerError
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.application.log
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun Application.configureStatusPage() {
  install(StatusPages) {
    exception<Throwable> { call, cause ->
      call.application.log.error("Error caused due to: $cause")
      call.respond(HttpStatusCode.InternalServerError, Json.encodeToString(InternalServerError))
    }
  }
}

