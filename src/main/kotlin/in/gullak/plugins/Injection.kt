package `in`.gullak.plugins

import `in`.gullak.di.GullakModule
import `in`.gullak.di.KoinPlugin
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
  install(KoinPlugin) {
    slf4jLogger()
    modules(GullakModule)
  }
}