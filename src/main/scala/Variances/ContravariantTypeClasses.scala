package Variances

trait Show[-T] {
  def show(value: T): String
}

object Show {
  def apply[T](using sh: Show[T]): Show[T] = sh

  given showAny: Show[Any] = _.toString
}

object ContravariantTypeClasses {
  def printIt[T: Show](t: T): Unit =
    println(Show[T].show(t))

  def main(args: Array[String]): Unit =
    printIt("Contravariant Type Classes")
}
