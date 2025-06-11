object Functor {
  trait FunctorType[F[_]]:
    extension [A](fa: F[A]) def fmap[B](f: A => B): F[B]

  given FunctorType[List] with
    extension [A](fa: List[A]) def fmap[B](f: A => B) = fa.map(f)

  lazy val numbers: List[Int] = List.range(1, 4)

  @main def runExtension() =
    println(numbers.fmap(_ * 10).fmap(_+1).fmap(_.toHexString))
}
