package `in`.gullak.bank

import `in`.gullak.common.Balance
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class BankBalance(
  override val id: Long,
  override val dateObserved: LocalDateTime,
  override val amount: Long
): Balance(id, dateObserved, amount)
