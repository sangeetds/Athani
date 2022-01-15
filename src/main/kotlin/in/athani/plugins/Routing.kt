package `in`.athani.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.plugins.*
import io.ktor.server.locations.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

  routing {
    get("/") {
      call.respondText("Hello World!")
    }
    install(StatusPages) {
      exception<AuthenticationException> { call, _ ->
        call.respond(HttpStatusCode.Unauthorized)
      }
      exception<AuthorizationException> { call, _ ->
        call.respond(HttpStatusCode.Forbidden)
      }

    }
  }
}

class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()
