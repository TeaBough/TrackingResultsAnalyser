
object SessionDurationVariation extends App {
  val all = Data.getData(args(0))
  val sessionVariations: List[Long] = getSessionDurationVariation(all)
  println("variation de la durée moyenne d'une session, semaine par semaine : " + sessionVariations)

  def getSessionDurationVariation(all: List[List[String]]): List[Long] = {
    val groupByWeek: Map[Integer, List[List[Any]]] = all.groupBy({ line =>
      TimeService.getDateTime(line(4)).getWeekOfWeekyear
    })
    val groupByWeekSorted = groupByWeek.toSeq.sortBy(_._1)

    val sessionWithDuration: List[Long] = groupByWeekSorted.map({
      case (k, v) => SessionsAverage.getAvgSession(v)
    }).toList

    val res = sessionWithDuration.foldLeft(sessionWithDuration)((acc, num) => {
      if (acc.size > 1) {
        val num1 = acc.head
        val num2 = acc.tail.head
        acc.tail :+ (num2 - num1)
      } else acc
    }).init
    res
  }


}
