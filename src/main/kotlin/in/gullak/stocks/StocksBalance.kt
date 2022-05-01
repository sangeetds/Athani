package `in`.gullak.stocks

import `in`.gullak.common.Balance
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class StocksBalance(
  override val id: Long,
  override val accountId: Long,
  override val dateObserved: LocalDateTime,
  override val amount: Long,
  val source: String,
): Balance(id, accountId, dateObserved, amount)
