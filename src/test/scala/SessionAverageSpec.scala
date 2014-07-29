import org.scalatest._

class SessionAverageSpec extends FlatSpec {

  "getAvgSession" should "compute the average of a session" in {
    val line1 = List("1", "email1", "1", "page1", "2014-07-25T08:10:00Z", "view")
    val line2 = List("1", "email1", "1", "page2", "2014-07-25T08:20:00Z", "view")
    val line3 = List("2", "email2", "2", "page1", "2014-07-25T08:20:00Z", "view")
    val line4 = List("2", "email2", "2", "page2", "2014-07-25T08:30:00Z", "view")
    val line5 = List("3", "email3", "3", "page1", "2014-07-25T08:00:00Z", "view")
    val line6 = List("3", "email3", "3", "page2", "2014-07-25T08:04:00Z", "view")
    val data = List(line1, line2, line3, line4, line5, line6)
    assert(SessionsAverage.getAvgSession(data) === 8)
  }
}
