package tasks

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import java.util.Calendar

class TaskScheduler {

  def perform[T, R](task: Task[T, R], argument: T): Future[R] = {
    val taskResult = Future {
      task.unitOfWork.apply(argument)
    }

    taskResult.onSuccess { case _ =>
      println(s"[${Calendar.getInstance().getTime()}] Completed: ${task.name}($argument)")
    }

    taskResult
  }

}