package `in`.gullak.crypto

import kotlinx.datetime.LocalDateTime

data class BalanceDTO(
  val id: Long,
  val balance: Long,
  val dateObserved: LocalDateTime
)
