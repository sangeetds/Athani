package `in`.gullak

import `in`.gullak.plugins.configureHTTP
import `in`.gullak.plugins.configureMonitoring
import `in`.gullak.plugins.configureRouting
import `in`.gullak.plugins.configureSerialization
import `in`.gullak.plugins.initiateKoin
import io.ktor.server.engine.embeddedServer
import io.ktor.server.tomcat.Tomcat

fun main() {
  embeddedServer(Tomcat, port = 0, host = "0.0.0.0") {
    configureRouting()
    configureHTTP()
    configureMonitoring()
    configureSerialization()
    initiateKoin()
  }.start(wait = true)
}
