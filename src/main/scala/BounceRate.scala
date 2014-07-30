object BounceRate extends App {
  val all = Data.getData(args(0))
  val bounceRate = getBounceRate(all)
  println("Taux de rebond : " + bounceRate )

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
}
