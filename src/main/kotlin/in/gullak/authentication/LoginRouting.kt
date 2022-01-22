package `in`.gullak.authentication

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
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

val users = listOf(User(id = 1, name = "Sangeet", email = "sangeetnarayands@gmail.com", loggedIn = false))

fun Application.userRouting() {
  routing {
    post<Authenticate.Login> { login ->
      val user = login.user
      val existingUser = users.firstOrNull { it.id == user.id }

      if (existingUser != null) {
        existingUser.loggedIn = true
        call.respond(HttpStatusCode.OK, user)
      }

      call.respond(HttpStatusCode.BadRequest)
    }
    post<Authenticate.Logout> { login ->
      val user = login.user
      val existingUser = users.firstOrNull { it.id == user.id }

      if (existingUser != null) {
        existingUser.loggedIn = false
        call.respond(HttpStatusCode.OK, user)
      }

      call.respond(HttpStatusCode.BadRequest)
    }
  }
}