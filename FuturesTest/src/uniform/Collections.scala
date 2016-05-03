package uniform

object Collections extends App {
  
  // TODO: def vs val
  def mapReduce() = {
    val list = List(1, 22, 423, 94, 5, 26)
    val concat = list.map(_.toString)
      .filter(_.length() > 1)
      .reduce((s1, s2) => s"$s1, $s2")
    println(concat)
  }
  
  mapReduce()
}