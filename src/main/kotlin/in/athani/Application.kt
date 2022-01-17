package `in`.athani

import `in`.athani.plugins.configureHTTP
import `in`.athani.plugins.configureMonitoring
import `in`.athani.plugins.configureRouting
import `in`.athani.plugins.configureSerialization
import `in`.athani.plugins.initiateKoin
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
