import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration.Duration

import tasks.GetClientTask
import tasks.TaskScheduler
import tasks.TransactionTask

object TaskSchedulerExample extends App {

  val scheduler = new TaskScheduler

  def runExample(x: Unit => Any) {
    println("Running tasks")
    x.apply()
    println("Done")
  }

  def parallelRun = {
    runExample(_ => {
      scheduler.perform(new GetClientTask(), 23)
      scheduler.perform(new GetClientTask(), 35)
      scheduler.perform(new GetClientTask(), 42)
    })

  }

  def getAllResults = {
    runExample(_ => {
      val allResults = List(
        scheduler.perform(new GetClientTask(), 23),
        scheduler.perform(new GetClientTask(), 35),
        scheduler.perform(new GetClientTask(), 42))

      val allClients = Future.sequence(allResults)
      println(Await.result(allClients, Duration.Inf))
    })
  }

  def performTransaction = {
    runExample(_ => {
      val fClient1 = scheduler.perform(new GetClientTask(), 23)
      val fClient2 = scheduler.perform(new GetClientTask(), 35)
      val fClients = Future.sequence(List(fClient1, fClient2))

      val fTrans = fClients.map(clients =>
        scheduler.perform(new TransactionTask(), (clients(0), clients(1), 300)))

      Await.result(fTrans, Duration.Inf)
      println("performed a transaction, woohoo!")
    })
  }

  //  parallelRun
  //  getAllResults
  performTransaction

  Thread.sleep(1000)
  println("Exiting")
}