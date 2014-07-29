object Utils {
  def removeEmptyListFromMap(sessionWithCheckout: Map[String, List[List[String]]]): Map[String, List[List[String]]] = {
    sessionWithCheckout.filter({
      case (k, v) => !v.isEmpty
    })
  }
}
