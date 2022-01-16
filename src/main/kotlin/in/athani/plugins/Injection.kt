package `in`.athani.plugins

import `in`.athani.di.KoinPlugin
import `in`.athani.di.athaniModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.logger.slf4jLogger

fun Application.initiateKoin() {
  // Install Ktor features
  install(KoinPlugin) {
    slf4jLogger()
    modules(athaniModule)
  }
}