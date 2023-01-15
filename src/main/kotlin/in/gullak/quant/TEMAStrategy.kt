package `in`.gullak.quant

import org.roboquant.common.Asset
import org.roboquant.strategies.PriceStrategy
import org.roboquant.strategies.Rating
import org.roboquant.strategies.Rating.HOLD
import org.roboquant.strategies.Signal
import org.roboquant.strategies.SignalType.BOTH
import org.roboquant.strategies.SignalType.ENTRY
import org.roboquant.strategies.SignalType.EXIT
import java.time.Instant

class TEMAStrategy(
  private val smoothingConstant: Double = 2.0,
  private val emaPeriod: Double = 8.0,
  private val temaShortPeriod: Double = 13.0,
  private val temaMediumPeriod: Double = 21.0,
  private val temaLongPeriod: Double = 55.0,
) : PriceStrategy() {

  private val assets: HashMap<Asset, TEMACalculator> = HashMap()
  private val factoryTEMACalculator = TEMACalculator()
  private var emaIndicator = 0.0
  private var shortTEMAIndicator = 0.0
  private var mediumTEMAIndicator = 0.0
  private var longTEMAIndicator = 0.0

  private inner class TEMACalculator() {

    private var periods = 0.0
    fun getCalculator(asset: Asset): TEMACalculator {
      assets[asset]?.let {
        return it
      }

      val assetCalculator = TEMACalculator()
      assets[asset] = assetCalculator
      return assetCalculator
    }

    fun addPrice(price: Double) {
      emaIndicator = updateIndicator(price, emaPeriod, emaIndicator)
      shortTEMAIndicator = updateIndicator(price, temaShortPeriod, shortTEMAIndicator)
      mediumTEMAIndicator = updateIndicator(price, temaMediumPeriod, mediumTEMAIndicator)
      longTEMAIndicator = updateIndicator(price, temaLongPeriod, longTEMAIndicator)
    }

    fun hasEnoughData(): Boolean = periods > temaLongPeriod

    private fun updateIndicator(price: Double, period: Double, indicator: Double) = when {
      periods < period - 1 -> indicator + price
      periods == period - 1 -> (indicator + price) / (periods + 1)
      else -> (price - indicator) * (smoothingConstant / period) + indicator
    }
  }

  override fun generate(asset: Asset, price: Double, time: Instant): Signal {
    val calculator = factoryTEMACalculator.getCalculator(asset)
    calculator.addPrice(price)

    if (calculator.hasEnoughData()) {
      return when (val indicatorStatus = getIndicatorStatus()) {
        Rating.BUY -> Signal(asset = asset, rating = indicatorStatus, type = ENTRY)
        Rating.SELL -> Signal(asset = asset, rating = indicatorStatus, type = EXIT)
        else -> Signal(asset = asset, rating = indicatorStatus, type = BOTH)
      }
    }

    return Signal(asset = asset, rating = HOLD, type = BOTH)
  }

  private fun getIndicatorStatus(): Rating {
    return when {
      longTEMAIndicator < emaIndicator && longTEMAIndicator < shortTEMAIndicator && longTEMAIndicator < mediumTEMAIndicator -> Rating.BUY
      longTEMAIndicator > emaIndicator && longTEMAIndicator > shortTEMAIndicator && longTEMAIndicator > mediumTEMAIndicator -> Rating.SELL
      else -> HOLD
    }
  }
}