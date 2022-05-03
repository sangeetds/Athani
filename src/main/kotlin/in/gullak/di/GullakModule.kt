package `in`.gullak.di

import `in`.gullak.crypto.CryptoAccountService
import `in`.gullak.crypto.CryptoAccountServiceImpl
import `in`.gullak.crypto.CryptoBalanceService
import `in`.gullak.crypto.CryptoBalanceServiceImpl
import org.koin.dsl.module

val GullakModule = module {
  single<CryptoAccountService>() { CryptoAccountServiceImpl() }
  single<CryptoBalanceService>() { CryptoBalanceServiceImpl() }
}