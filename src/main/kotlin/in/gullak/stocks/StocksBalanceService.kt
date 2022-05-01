package `in`.gullak.stocks

interface StocksBalanceService {

  fun fetchLatestBalance(accountId: Long): BalanceDTO?
}
