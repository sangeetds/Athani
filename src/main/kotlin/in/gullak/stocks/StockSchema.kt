package `in`.gullak.stocks

import io.ktor.server.plugins.NotFoundException
import kotlinx.datetime.LocalDateTime
import org.koin.java.KoinJavaComponent.inject
import org.sangeet.kgraphql.schema.dsl.SchemaBuilder

fun SchemaBuilder.stockSchema() {

  val accountService by inject<StocksAccountService>(StocksAccountService::class.java)
  val balanceService by inject<StocksBalanceService>(StocksBalanceService::class.java)

  stringScalar<LocalDateTime> {
    description = "LocalDateTime at which the balance was observed"
    serialize = { date -> date.toString() }
    deserialize = { dateString -> LocalDateTime.parse(dateString) }
  }

  query("stock") {
    description = "Returns a single Stock Account based on the id"

    resolver { id: Long ->
      accountService.findById(id) ?: throw NotFoundException("Account with id: $id does not exist")
    }
  }

  query("balance") {
    description = "Returns the latest balance for the user for the given account number"

    resolver { accountId: Long ->
      balanceService.fetchLatestBalance(accountId)
        ?: throw NotFoundException("Account with id: $accountId does not exist")
    }
  }

  type<StocksBalance> {
    description = "Balances in the account"
  }

  type<StocksAccount>() {
    description = "Account of a particular place"
  }
}