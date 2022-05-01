package `in`.gullak.stocks

import `in`.gullak.common.Account
import kotlinx.serialization.Serializable

@Serializable
data class StocksAccount(
  override val id: Long,
  override val userId: Long,
  override val accountNumber: Long,
  override val accountType: String,
  override val balances: List<StocksBalance>
) : Account(id, userId, accountNumber, accountType, balances)