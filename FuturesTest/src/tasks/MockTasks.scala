package tasks

import domain.Client


object MockTasks {
  val clients = Map(
    23 -> Client(23, "Vasja"),
    35 -> Client(35, "Petja"),
    42 -> Client(42, "Natasha")
  )

  def getClientById(id: Int): Client = {
    Thread.sleep(3000);

    clients(id)
  }
  
  def transaction(trans: (Client, Client, Int)) = {
    val (creditor, beneficiary, value) = trans
    
    Thread.sleep(500)
    
    println(s"Transfered ${value}$$ from ${creditor} to ${beneficiary}")
  }
}