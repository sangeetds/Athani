package `in`.gullak.quant

import org.roboquant.Roboquant
import org.roboquant.brokers.sim.SimBroker
import org.roboquant.common.USD
import org.roboquant.common.Wallet
import org.roboquant.feeds.csv.CSVFeed
import org.roboquant.feeds.csv.LazyCSVFeed
import org.roboquant.loggers.ConsoleLogger
import org.roboquant.metrics.AccountMetric
import org.roboquant.policies.FlexPolicy

fun main() {
  val quant = Quant()
  quant.startTrade()
}

class Quant {

  fun startTrade() {
    val strategy = TEMAStrategy()
    val metric = AccountMetric()
    val roboQuant = Roboquant(strategy, metric, logger = ConsoleLogger(), broker = SimBroker(initialDeposit = Wallet(300_000.USD)), policy = FlexPolicy(priceType = "CLOSE"))
    println(metric)
    val feed = CSVFeed("HUL.csv")
    roboQuant.run(feed)
    println(metric)
  }
}