package `in`.gullak.common

import kotlinx.datetime.LocalDateTime

abstract class Balance(
  open val id: Long,
  open val accountId: Long,
  open val dateObserved: LocalDateTime,
  open val amount: Long,
) {
  constructor(): this(0, 0L, LocalDateTime(0, 0, 0, 0, 0, 0), 0)
}
