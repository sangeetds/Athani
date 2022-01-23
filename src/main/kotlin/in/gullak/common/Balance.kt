package `in`.gullak.common

import kotlinx.datetime.LocalDateTime

abstract class Balance(
  open val id: Long,
  open val dateObserved: LocalDateTime,
  open val amount: Long
)
