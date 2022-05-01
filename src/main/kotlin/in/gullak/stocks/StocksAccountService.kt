package `in`.gullak.stocks

interface StocksAccountService {

  fun findById(id: Long): StockDto?
}