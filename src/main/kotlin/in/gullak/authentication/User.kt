package `in`.gullak.authentication

import `in`.gullak.bank.BankAccount

data class User(
  val id: Long,
  val name: String,
  val email: String,
  var loggedIn: Boolean,
  val bankAccount: BankAccount?
)
