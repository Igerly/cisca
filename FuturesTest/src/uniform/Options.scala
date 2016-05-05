package uniform

object Options extends App {
  
    def mapFilter() = {
    val option = Option(423)
    val isOdd = option.map(_ % 2)
      .filter(_ == 1)
      .nonEmpty
      
    println(isOdd)
  }
  
  mapFilter()

}