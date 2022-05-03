package `in`.gullak.crypto

import `in`.gullak.common.Balance
import kotlinx.datetime.LocalDateTime

class CryptoBalanceServiceImpl : CryptoBalanceService {

  private val balances = mapOf(
    1L to mutableListOf(CryptoBalance(
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

  override fun addBalance(balance: Balance, accountId: Long) {
    val balanceForCrypto = balances[accountId] ?: return
    balanceForCrypto.add(balance as CryptoBalance)
  }
}