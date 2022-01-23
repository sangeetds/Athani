package `in`.gullak.bank

import `in`.gullak.common.Account

data class BankAccount(
  override val id: Long,
  override val accountNumber: Long,
  override val accountType: String,
  override val balances: List<BankBalance>
) : Account(id, accountNumber, accountType, balances)