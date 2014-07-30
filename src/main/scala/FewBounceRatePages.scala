object FewBounceRatePages extends App {
  val all = Data.getData(args(0))
  val pages = getFewBounceRatePages(all)
  println("Pages qui entraînent le moins de conversion : " + pages)

  def getFewBounceRatePages(all: List[List[String]]): List[String] = {
    val sessionWithCheckout = BounceRate.getSessionsWithCheckout(all)
    val sessionWithCheckoutCleared = Utils.removeEmptyListFromMap(sessionWithCheckout)
    val flattenPages = sessionWithCheckoutCleared.values.flatten.toList

    val allPages = all.map(_(3)).toSet

    val decreasedPopularPages = PopularPage.getPagePopularity(flattenPages).reverse
    allPages.toList.diff(decreasedPopularPages) ::: decreasedPopularPages
  }

}
