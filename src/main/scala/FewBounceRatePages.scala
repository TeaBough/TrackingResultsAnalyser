object FewBounceRatePages {


  def getFewBounceRatePages(all: List[List[String]]): List[String] = {
    val sessionWithCheckout = BounceRate.getSessionsWithCheckout(all)
    val sessionWithCheckoutCleared = Utils.removeEmptyListFromMap(sessionWithCheckout)
    val flattenPages = sessionWithCheckoutCleared.values.flatten.toList

    val allPages = all.map(_(3)).toSet

    val decreasedPopularPages = PopularPage.getPagePopularity(flattenPages).reverse
    allPages.toList.diff(decreasedPopularPages) ::: decreasedPopularPages
  }

  def main(args: Array[String]) {
    val all = Data.getData
    val bounceRate = getFewBounceRatePages(all)
  }
}
