

object SessionsAverage extends App {

  val all = Data.getData(args(0))
  val avgSession = getAvgSession(all)
  println("Session moyenne : " + avgSession + " min")

  def getAvgSession(all: List[List[Any]]): Long = {
    val sessions = all.groupBy(_.head)
    val sessionWithDuration = sessions.map({
      case (k, v) => getSessionDuration(v)
    })
    sessionWithDuration.sum.toLong / sessionWithDuration.size / 60000
  }

  def getSessionDuration(session: List[List[Any]]): Long = {
    val v = session.map(x => TimeService.getTimeStampFromDate(x(4).asInstanceOf[String]))
    v.max - v.min
  }

}