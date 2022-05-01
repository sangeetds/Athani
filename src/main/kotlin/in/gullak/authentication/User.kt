package `in`.gullak.authentication

import `in`.gullak.stocks.StocksAccount
import `in`.gullak.stocks.StocksBalance
import kotlinx.datetime.LocalDateTime

data class User(
  val id: Long,
  val name: String,
  val email: String,
  var loggedIn: Boolean,
  val stocksAccount: StocksAccount?
)

val users =
  listOf(
    User(
      id = 1,
      name = "Sangeet",
      email = "sangeetnarayands@gmail.com",
      loggedIn = false,
      stocksAccount = StocksAccount(
        id = 1,
        userId = 1,
        accountNumber = 213456,
        accountType = "Savings",
        balances = listOf(
          StocksBalance(
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