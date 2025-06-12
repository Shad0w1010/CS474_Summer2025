package Variances

/*
Specifically, the error message: covariant type F occurs in contravariant position in type F[A] of parameter fa arises because the Functor trait itself cannot be covariant in its higher-kinded type parameter F[_]. Rather, the variance annotations are typically placed at the element-level type parameter, not on the type constructor itself.

trait Functor[+F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

object ListFunctor extends Functor[List] {
  def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
}

object HigherKindedVariance {
  def main(args: Array[String]): Unit =
    println(ListFunctor.map(List("Scala", "Higher"))(_.length))
}
*/

trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

object ListFunctor extends Functor[List] {
  def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
}

object HigherKindedVariance {
  def main(args: Array[String]): Unit =
    println(ListFunctor.map(List("Scala", "Higher"))(_.length))
}
