package `in`.gullak.bank

interface StocksService {

  fun findById(id: Long): StocksAccount?
}