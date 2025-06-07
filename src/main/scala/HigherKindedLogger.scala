object HigherKindedLogger {
  trait LogF[F[_]]:
    def unit[A](a: => A): F[A]

  given LogF[LazyList] with
    def unit[A](a: => A): LazyList[A] = LazyList.cons(a, LazyList.empty)

  def acquire[F[_], A](res: => A)(using L: LogF[F]) = L.unit(res)

  @main def runHKLogger() =
    val first = acquire(LazyList("open file"))
    println(first.head.take(1).head)
}
