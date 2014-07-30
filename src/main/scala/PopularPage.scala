object PopularPage extends App {
  val all = Data.getData(args(0))
  val pages = getPagePopularity(all)
  println("Pages populaires : " + pages)

  def getPagePopularity(all: List[List[String]]): List[String] = {
    val pages = all.groupBy(_(3))
    val pagesWithCount = pages.map({
      case (k, v) => k -> v.size
    })
    val pagesSorted = pagesWithCount.toSeq.sortBy(_._2).toList.reverse
    pagesSorted.map(_._1)
  }

}
