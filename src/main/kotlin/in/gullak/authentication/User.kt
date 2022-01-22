package `in`.gullak.authentication

data class User(
  val id: Int,
  val name: String,
  val email: String,
  var loggedIn: Boolean
)
