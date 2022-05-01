package `in`.gullak.plugins

import `in`.gullak.bank.stockSchema
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.sangeet.kgraphql.GraphQL

fun Application.configureKGraphQL() {
  install(GraphQL) {
    playground = true
    endpoint = "/gullak/v1/"

    schema { stockSchema() }
  }
}