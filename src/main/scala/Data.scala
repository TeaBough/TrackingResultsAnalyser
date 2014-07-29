import java.io.File

import com.github.tototoshi.csv._

object Data {
  def getData: List[List[String]] = {
    val reader = CSVReader.open(new File("data.csv"))
    val all = reader.all()
    reader.close()
    all
  }
}
