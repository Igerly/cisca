package uniform

object Collections extends App {
  
  def mapReduce() = {
    val list = List(1, 22, 423, 94, 5, 26)
    val concat = list.map(_.toString)
      .filter(_.length() > 1)

      println(concat)
  }
  
  mapReduce()
}