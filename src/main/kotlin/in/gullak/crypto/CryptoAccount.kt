package `in`.gullak.crypto

import `in`.gullak.common.Account
import kotlinx.serialization.Serializable

@Serializable
data class CryptoAccount(
  override val id: Long,
  override val userId: Long,
  override val accountNumber: Long,
  override val accountType: String,
  override val balances: List<CryptoBalance>
) : Account(id, userId, accountNumber, accountType, balances)