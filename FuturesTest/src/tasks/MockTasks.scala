package tasks

import domain.Client


object MockTasks {
  def getClientById(id: Int): Client = {
    Thread.sleep(3000);

    new Client(id, "Vasja")
  }
  
  def transaction(trans: (Client, Client, Int)) = {
    val (creditor, beneficiary, value) = trans
    
    Thread.sleep(500)
    
    println(s"Transfered ${value}$$ from ${creditor} to ${beneficiary}")
  }
}