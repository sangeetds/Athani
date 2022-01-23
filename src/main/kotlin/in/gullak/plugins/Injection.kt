package `in`.gullak.plugins

import `in`.gullak.di.KoinPlugin
import io.ktor.events.EventDefinition
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationPlugin
import io.ktor.server.application.ApplicationStopping
import io.ktor.server.application.install
import io.ktor.util.AttributeKey
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
  // Install Ktor features
  install(KoinPlugin) {
    slf4jLogger()
  }
}