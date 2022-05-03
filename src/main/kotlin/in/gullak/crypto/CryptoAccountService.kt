package `in`.gullak.crypto

import `in`.gullak.common.Account

interface CryptoAccountService {

  fun findById(id: Long): CryptoDto?

  fun addNewAccount(crypto: Account)
}