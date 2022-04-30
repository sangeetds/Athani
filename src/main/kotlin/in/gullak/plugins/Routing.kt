package `in`.gullak.plugins

import `in`.gullak.authentication.userRouting
import `in`.gullak.bank.bankRouting
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.application.log
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

fun Application.configureRouting() {

  routing {
    this@configureRouting.install(StatusPages) {
      exception<AuthenticationException> { call, _ ->
        call.respond(HttpStatusCode.Unauthorized)
      }
      exception<AuthorizationException> { call, _ ->
        call.respond(HttpStatusCode.Forbidden)
      }
    }

    route("/gullak/v1") {
      userRouting(this@configureRouting.log)
      bankRouting(this@configureRouting.log)
    }
  }
}

class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()
