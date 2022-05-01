package `in`.gullak.di

import `in`.gullak.stocks.StocksAccountService
import `in`.gullak.stocks.StocksAccountServiceImpl
import `in`.gullak.stocks.StocksBalanceService
import `in`.gullak.stocks.StocksBalanceServiceImpl
import org.koin.dsl.module

val GullakModule = module {
  single<StocksAccountService>() { StocksAccountServiceImpl() }
  single<StocksBalanceService>() { StocksBalanceServiceImpl() }
}