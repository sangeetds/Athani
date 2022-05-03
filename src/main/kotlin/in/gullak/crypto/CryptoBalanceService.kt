package `in`.gullak.crypto

import `in`.gullak.common.Balance

interface CryptoBalanceService {

  fun fetchLatestBalance(accountId: Long): BalanceDTO?

  fun addBalance(balance: Balance, accountId: Long)
}
