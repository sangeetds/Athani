package `in`.gullak.crypto

import `in`.gullak.common.Account
import kotlinx.datetime.LocalDateTime

class CryptoAccountServiceImpl : CryptoAccountService {

  private val cryptos = mutableMapOf(
    1L to CryptoAccount(
      1L,
      1L,
      123456789L,
      "Holdings",
      balances = listOf(
        CryptoBalance(
          id = 1L,
          accountId = 1L,
          dateObserved = LocalDateTime.parse("2017-01-13T17:09:42.411"),
          1000L,
          "Zerodha"
        )
      )
    )
  )

  override fun findById(id: Long): CryptoDto? {
    val cryptoCoins = cryptos[id] ?: return null
    return CryptoDto(cryptoCoins.id, cryptoCoins.accountNumber, cryptoCoins.accountType)
  }

  override fun addNewAccount(crypto: Account) {
    cryptos[(2L..100000L).random()] = crypto as CryptoAccount
  }
}