package tasks

class Task[R, T](val name: String, val unitOfWork: Function1[R, T]) {
  
}