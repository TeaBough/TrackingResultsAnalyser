import org.joda.time.DateTime

object SessionDurationVariation {

  def getSessionDurationVariation(all: List[List[String]]): List[Long] = {
    val dateTime = new DateTime

    val groupByWeek: Map[Integer, List[List[Any]]] = all.groupBy({ line =>
      TimeService.getDateTime(line(4)).getWeekOfWeekyear
    })
    val groupByWeekSorted = groupByWeek.toSeq.sortBy(_._1)

    val sessionWithDuration: List[Long] = groupByWeekSorted.map({
      case (k, v) => SessionsAverage.getAvgSession(v)
    }).toList

    val res = sessionWithDuration.foldLeft(sessionWithDuration)((acc, num) => {
      val num1 = acc.head
      val num2 = acc.tail.head
      acc.tail :+ (num2 - num1)
    }).init
    res
  }

  def main(args: Array[String]) {
    val all = Data.getData
    val sessionVariations: List[Long] = getSessionDurationVariation(all)
  }


}
