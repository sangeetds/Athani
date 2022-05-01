package `in`.gullak.stocks

import kotlinx.datetime.LocalDateTime

class StocksBalanceServiceImpl : StocksBalanceService {

  private val balances = mapOf(
    1L to listOf(StocksBalance(
      id = 1L,
      accountId = 1L,
      dateObserved = LocalDateTime.parse("2017-01-13T17:09:42.411"),
      1000L,
      "Zerodha"
    ))
  )

  override fun fetchLatestBalance(accountId: Long): BalanceDTO? {
    val balances = balances[accountId] ?: return null
    val latestBalance = balances.maxByOrNull { it.dateObserved } ?: return null
    return BalanceDTO(latestBalance.id, latestBalance.amount, latestBalance.dateObserved)
  }
}