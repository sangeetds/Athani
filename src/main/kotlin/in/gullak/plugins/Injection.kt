package `in`.gullak.plugins

import `in`.gullak.di.KoinPlugin
import `in`.gullak.di.gullakModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.logger.slf4jLogger

fun Application.initiateKoin() {
  // Install Ktor features
  install(KoinPlugin) {
    slf4jLogger()
    modules(gullakModule)
  }
}