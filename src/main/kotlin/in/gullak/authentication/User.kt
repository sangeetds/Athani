package `in`.gullak.authentication

import `in`.gullak.crypto.CryptoAccount
import `in`.gullak.crypto.CryptoBalance
import kotlinx.datetime.LocalDateTime

data class User(
  val id: Long,
  val name: String,
  val email: String,
  var loggedIn: Boolean,
  val cryptoAccount: CryptoAccount?
)

val users =
  listOf(
    User(
      id = 1,
      name = "Sangeet",
      email = "sangeetnarayands@gmail.com",
      loggedIn = false,
      cryptoAccount = CryptoAccount(
        id = 1,
        userId = 1,
        accountNumber = 213456,
        accountType = "Savings",
        balances = listOf(
          CryptoBalance(
            id = 1,
            accountId = 1,
            dateObserved = LocalDateTime(2022, 1, 1, 0, 0, 0),
            amount = 1000,
            source = "Zerodha",
          )
        )
      )
    )
  )