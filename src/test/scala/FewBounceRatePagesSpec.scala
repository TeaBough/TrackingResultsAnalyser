import org.scalatest.FlatSpec

class FewBounceRatePagesSpec extends FlatSpec {
  "getFewBounceRatePages" should "rank page by fewer bounce rate" in {
    val line1 = List("1", "email1", "1", "page1", "2014-07-25T08:10:00Z", "view")
    val line2 = List("1", "email1", "1", "page2", "2014-07-25T08:20:00Z", "view")
    val line3 = List("1", "email1", "1", "checkout", "2014-07-25T08:28:00Z", "view")

    val line4 = List("2", "email2", "2", "page1", "2014-07-25T08:20:00Z", "view")
    val line5 = List("2", "email2", "2", "page3", "2014-07-25T08:30:00Z", "view")

    val line6 = List("3", "email3", "3", "page1", "2014-07-25T08:00:00Z", "view")
    val line8 = List("3", "email3", "3", "checkout", "2014-07-25T08:08:00Z", "view")
    val data = List(line1, line2, line3, line4, line5, line6, line8)
    val res = FewBounceRatePages.getFewBounceRatePages(data)
    assert(res(0) === "page3")
    assert(res(1) === "page2")
  }

}
