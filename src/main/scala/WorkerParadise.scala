object WorkerParadise:

  type Result[T] = T match
    case Int    => Long
    case String => Int
    case _      => T

  trait Worker[T]:
    def work(v: T): Result[T]

  final class IntWorker extends Worker[Int]:
    def work(v: Int): Long = v.toLong * v

  final class StringWorker extends Worker[String]:
    def work(v: String): Int = v.length

  lazy val choose: Boolean = scala.util.Random.nextBoolean()

  lazy val task: (IntWorker, Int) | (StringWorker, String) =
    if choose then
      (new IntWorker, 7)
    else
      (new StringWorker, "abc")

  @main def runMatchType() =
    val result = task match
      // each branch refines both components to a concrete type
      case (w: IntWorker,  n: Int)    => w.work(n)
      case (w: StringWorker, s: String) => w.work(s)
    println(result)
