package `in`.gullak.di

import `in`.gullak.bank.StocksService
import `in`.gullak.bank.StocksServiceImpl
import org.koin.dsl.module
import org.koin.dsl.single

val GullakModule = module {
  single<StocksService>() { StocksServiceImpl() }
}