package uniform

object Options extends App {
  
    def mapReduce() = {
    val list = Option(423)
    val concat = list.map(_.toString)
      .filter(_.length() > 1)
      .reduce((s1, s2) => s"$s1, $s2")
    println(concat)
  }
  
  mapReduce()

}