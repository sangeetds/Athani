package `in`.gullak.bank

import `in`.gullak.common.Account
import kotlinx.serialization.Serializable

@Serializable
data class BankAccount(
  override val id: Long,
  override val accountNumber: Long,
  override val accountType: String,
  override val balances: List<BankBalance>
) : Account(id, accountNumber, accountType, balances)