package `in`.gullak.bank

import `in`.gullak.authentication.users
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.locations.Location
import io.ktor.server.locations.get
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.util.logging.Logger

@Location("/bank/{userId}")
data class Bank(val userId: Long)

fun Route.stocksRouting(log: Logger) {
  get<Bank> { bank ->
    val userId = bank.userId
    val user = users.firstOrNull { it.id == userId }

    if (user != null) {
      log.info("User ${user.name} found.")
      if (user.stocksAccount != null) {
        log.info("User ${user.name} has bank account authorized")
        call.respond(HttpStatusCode.OK, user.stocksAccount.balances[0])
      }

      log.error("User ${user.name} has not authorized bank account")
      call.respond(HttpStatusCode.Unauthorized)
    }

    log.error("User with id $userId not found")
    call.respond(HttpStatusCode.BadRequest)
  }
}