import scala.util.Success

object AsyncFutureDispatch {

  import scala.concurrent.*
  import scala.concurrent.ExecutionContext.Implicits.global

  trait Task[F[_]]:
    def run[A, B](fa: F[A])(f: A => B): Future[B]

  class FutureTask extends Task[Future]:
//    def run[A](fa: Future[A]) = fa.foreach(a => println(s"done $a"))
    override def run[A, B](fa: Future[A])(f: A => B): Future[B] =
      fa.map(a=>f(a))

  lazy val task = new FutureTask

  @main def runFuture() =
    val fut = Future {
      Thread.sleep(100); 99
    }
    task.run(fut)((i:Int)=>i+11) onComplete {
      case Success(value) => println(value)
    }
    Thread.sleep(200)
}
