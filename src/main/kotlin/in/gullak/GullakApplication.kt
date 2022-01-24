package `in`.gullak

import `in`.gullak.plugins.configureHTTP
import `in`.gullak.plugins.configureKoin
import `in`.gullak.plugins.configureLocations
import `in`.gullak.plugins.configureMonitoring
import `in`.gullak.plugins.configureRouting
import `in`.gullak.plugins.configureSerialization
import com.typesafe.config.ConfigFactory
import io.ktor.server.application.port
import io.ktor.server.config.HoconApplicationConfig
import io.ktor.server.engine.embeddedServer
import io.ktor.server.tomcat.Tomcat

fun main() {
  val config = HoconApplicationConfig(ConfigFactory.load())
  embeddedServer(Tomcat, port = config.port, host = "0.0.0.0") {
    configureLocations()
    configureRouting()
    configureHTTP()
    configureMonitoring()
    configureSerialization()
    configureKoin()
  }.start(wait = true)
}
