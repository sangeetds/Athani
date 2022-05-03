package `in`.gullak.crypto

import `in`.gullak.common.Balance
import io.ktor.server.plugins.NotFoundException
import kotlinx.datetime.LocalDateTime
import org.koin.java.KoinJavaComponent.inject
import org.sangeet.kgraphql.schema.dsl.SchemaBuilder

fun SchemaBuilder.cryptoSchema() {

  val accountService by inject<CryptoAccountService>(CryptoAccountService::class.java)
  val balanceService by inject<CryptoBalanceService>(CryptoBalanceService::class.java)

  queries(accountService, balanceService)
  mutations(accountService, balanceService)
  scalars()
  types()
}

private fun SchemaBuilder.mutations(accountService: CryptoAccountService, balanceService: CryptoBalanceService) {
  mutation("crypto") {
    description = "Adds a new crypto account"

    resolver { input: CryptoAccount ->
      accountService.addNewAccount(input)
    }
  }

  mutation("balance") {
    description = "Adds a new balance"

    resolver { balance: Balance, accountId: Long ->
      balanceService.addBalance(balance, accountId)
    }
  }
}

private fun SchemaBuilder.scalars() {
  stringScalar<LocalDateTime> {
    description = "LocalDateTime at which the balance was observed"
    serialize = { date -> date.toString() }
    deserialize = { dateString -> LocalDateTime.parse(dateString) }
  }
}

private fun SchemaBuilder.types() {
  type<CryptoBalance> {
    description = "Balances in the account"
  }

  type<CryptoAccount>() {
    description = "Account of a particular place"
  }
}

private fun SchemaBuilder.queries(
  accountService: CryptoAccountService,
  balanceService: CryptoBalanceService
) {
  query("crypto") {
    description = "Returns a single Crypto Account based on the id"

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
}