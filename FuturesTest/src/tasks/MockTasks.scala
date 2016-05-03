package tasks

import domain.Client


object MockTasks {
  def getClientById(id: Int): Client = {
    Thread.sleep(3000);

    new Client(id, "Vasja")
  }
  
  def transaction(trans: (Client, Client, Int)) = {
    Thread.sleep(500)
    
    println(s"Transfered ${trans._3} from ${trans._1} to ${trans._2}")
  }
}