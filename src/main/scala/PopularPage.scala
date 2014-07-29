object PopularPage {

  def getPagePopularity(all: List[List[String]]): List[String] = {
    val pages = all.groupBy(_(3))
    val pagesWithCount = pages.map({
      case (k, v) => k -> v.size
    })
    val pagesSorted = pagesWithCount.toSeq.sortBy(_._2).toList.reverse
    pagesSorted.map(_._1)
  }

  def main(args: Array[String]) {
    val all = Data.getData
    val pagePopularity = getPagePopularity(all)
  }

}
