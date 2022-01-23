package `in`.gullak.authentication

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.log
import io.ktor.server.locations.Location
import io.ktor.server.response.respond
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

@Location("/authenticate")
class Authenticate {
  @Location("/login")
  data class Login(val user: User)

  @Location("/logout")
  data class Logout(val user: User)
}

val users =
  listOf(
    User(
      id = 1,
      name = "Sangeet",
      email = "sangeetnarayands@gmail.com",
      loggedIn = false,
      null
    )
  )

fun Application.userRouting() {
  routing {
    post<Authenticate.Login> { login ->
      val user = login.user
      log.info("Logging in user ${user.name}")
      val existingUser = users.firstOrNull { it.id == user.id }

      if (existingUser != null) {
        existingUser.loggedIn = true
        log.info("User ${user.name} logged in successfully")
        call.respond(HttpStatusCode.OK, user)
      }

      log.error("User ${user.id} not found")
      call.respond(HttpStatusCode.BadRequest)
    }
    post<Authenticate.Logout> { login ->
      val user = login.user
      log.info("Logging out user ${user.name}")
      val existingUser = users.firstOrNull { it.id == user.id }

      if (existingUser != null) {
        log.info("User ${user.name} logged out successfully")
        existingUser.loggedIn = false
        call.respond(HttpStatusCode.OK, user)
      }

      log.error("User ${user.id} not found")
      call.respond(HttpStatusCode.BadRequest)
    }
  }
}