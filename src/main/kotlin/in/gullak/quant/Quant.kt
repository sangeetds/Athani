package `in`.gullak.quant

import org.roboquant.Roboquant
import org.roboquant.feeds.csv.CSVFeed
import org.roboquant.metrics.AccountMetric

fun main() {
  val quant = Quant()
  quant.startTrade()
}

class Quant {

  fun startTrade() {
    val strategy = TEMAStrategy()
    val metric = AccountMetric()
    val roboQuant = Roboquant(strategy, metric)

    val feed = CSVFeed("HINDUNILVR.NS.csv")
    roboQuant.run(feed)
  }
}