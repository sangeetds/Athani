package `in`.gullak.plugins

import `in`.gullak.stocks.stockSchema
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.sangeet.kgraphql.GraphQL

fun Application.configureKGraphQL() {
  install(GraphQL) {
    playground = true
    endpoint = "/gullak/v1/"
    wrapErrors = false

    schema { listOf(stockSchema()) }
  }
}