import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat

object TimeService {
  val formatter = {
    val formatter = ISODateTimeFormat.dateTimeNoMillis()
    formatter.withZoneUTC()
    formatter
  }

  def getDateTime(s: String): DateTime = {
    formatter.parseDateTime(s)
  }

  def getTimeStampFromDate(s: String): Long = {
    formatter.parseDateTime(s).getMillis
  }
}
