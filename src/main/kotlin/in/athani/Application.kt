package `in`.athani

import `in`.athani.plugins.configureHTTP
import `in`.athani.plugins.configureMonitoring
import `in`.athani.plugins.configureRouting
import `in`.athani.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.tomcat.*

fun main() {
  embeddedServer(Tomcat, port = 0, host = "0.0.0.0") {
    configureRouting()
    configureHTTP()
    configureMonitoring()
    configureSerialization()
  }.start(wait = true)
}
