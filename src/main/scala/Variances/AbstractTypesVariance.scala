package Variances

trait Container {
  type A
  val value: A
}

class StringContainer(val value: String) extends Container {
  type A = String
}

class IntContainer(val value: Int) extends Container {
  type A = Int
}
object AbstractTypesVariance {
  def printContainer(c: Container { type A <: String }): Unit =
    println(c.value)

  def main(args: Array[String]): Unit =
    printContainer(new StringContainer("Scala Abstract Types"))
//    printContainer(new IntContainer(2))
}
