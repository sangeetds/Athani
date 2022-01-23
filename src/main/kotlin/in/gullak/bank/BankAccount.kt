package `in`.gullak.bank

import `in`.gullak.common.Account

data class BankAccount(
  val balance: Long,
  override val id: Long,
  override val accountNumber: Long,
  override val accountType: String
) : Account()