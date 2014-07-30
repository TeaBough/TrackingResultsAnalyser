import java.io.File

import com.github.tototoshi.csv._

object Data {
  def getData(file: String): List[List[String]] = {
    val reader = CSVReader.open(new File(file))
    val all = reader.all()
    reader.close()
    all
  }
}
