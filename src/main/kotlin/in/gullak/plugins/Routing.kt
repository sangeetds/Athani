package `in`.gullak.plugins

import `in`.gullak.authentication.userRouting
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.StatusPages
import io.ktor.server.response.respond
import io.ktor.server.routing.routing

fun Application.configureRouting() {

  routing {
    userRouting()

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
