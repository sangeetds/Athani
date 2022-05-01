package `in`.gullak.bank

import io.ktor.server.plugins.NotFoundException
import kotlinx.datetime.LocalDateTime
import org.koin.java.KoinJavaComponent.inject
import org.sangeet.kgraphql.schema.dsl.SchemaBuilder

fun SchemaBuilder.stockSchema() {

  val service by inject<StocksService>(StocksService::class.java)

  stringScalar<LocalDateTime> {
    serialize = { date -> date.toString() }
    deserialize = { dateString -> LocalDateTime.parse(dateString) }
  }

  query("stock") {
    description = "Returns a single Stock Account based on the id"

    resolver { id: Long ->
      service.findById(id) ?: throw NotFoundException("Account with id: $id does not exist")
    }
  }
}