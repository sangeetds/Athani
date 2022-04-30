package `in`.gullak.plugins

import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.cors.CORS

fun Application.configureHTTP() {
  install(CORS) {
    methods.addAll(
      listOf(
        HttpMethod.Options,
        HttpMethod.Put,
        HttpMethod.Put,
        HttpMethod.Delete,
        HttpMethod.Patch
      )
    )
    headers.add(HttpHeaders.Authorization)
    anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
  }
}
