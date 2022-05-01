package `in`.gullak.common

abstract class Account(
  open val id: Long,
  open val accountNumber: Long,
  open val userId: Long,
  open val accountType: String,
  open val balances: List<Balance>,
) {
  constructor(): this(0, 0, 0, "", listOf())
}