package `in`.gullak.stocks

import kotlinx.datetime.LocalDateTime

class StocksAccountServiceImpl : StocksAccountService {

  private val stocks = mapOf(
    1L to StocksAccount(
      1L,
      1L,
      123456789L,
      "Holdings",
      balances = listOf(
        StocksBalance(
          id = 1L,
          accountId = 1L,
          dateObserved = LocalDateTime.parse("2017-01-13T17:09:42.411"),
          1000L,
          "Zerodha"
        )
      )
    )
  )

  override fun findById(id: Long): StockDto? {
    val stock = stocks[id] ?: return null
    return StockDto(stock.id, stock.accountNumber, stock.accountType)
  }
}