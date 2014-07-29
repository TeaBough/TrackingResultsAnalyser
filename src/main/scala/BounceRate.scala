object BounceRate {
  def getBounceRate(all: List[List[String]]): Double = {
    val sessionWithCheckout = getSessionsWithCheckout(all)
    val sessionWithCheckoutCleared = Utils.removeEmptyListFromMap(sessionWithCheckout)
    sessionWithCheckoutCleared.size.toDouble / sessionWithCheckout.size.toDouble
  }


  def getSessionsWithCheckout(all: List[List[String]]) = {
    val sessions = all.groupBy(_.head)
    sessions.map({
      case (k, v) => k -> {
        if (v.filter(l => l(3).contains("checkout")).isEmpty) Nil else v
      }
    })
  }

  def main(args: Array[String]) {
    val all = Data.getData
    val bounceRate = getBounceRate(all)
  }
}
