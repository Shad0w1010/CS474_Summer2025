object AsyncFutureDispatch {

  import scala.concurrent.*
  import scala.concurrent.ExecutionContext.Implicits.global

  trait Task[F[_]]:
    def run[A](fa: F[A]): Unit

  class FutureTask extends Task[Future]:
    def run[A](fa: Future[A]) = fa.foreach(a => println(s"done $a"))

  lazy val task: Task[Future] = new FutureTask

  @main def runFuture() =
    val fut = Future {
      Thread.sleep(100); 99
    }
    task.run(fut)
    Thread.sleep(200)
}
