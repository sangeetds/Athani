package `in`.gullak.plugins

import io.ktor.http.HttpStatusCode.Companion.InternalServerError
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun Application.configureStatusPage() {
  install(StatusPages) {
    status(InternalServerError) { call, status ->
      call.respond(status, Json.encodeToString(`in`.gullak.exceptions.InternalServerError))
    }
  }
}

