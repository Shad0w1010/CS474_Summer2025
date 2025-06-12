package Variances

object ExistentialCovariance {
  def printArray(arr: Array[? <: String]): Unit = arr.foreach(println)

  def main(args: Array[String]): Unit = {
    val strings = Array("Scala", "Existential", "Covariance")
    val ints = Array(1, 2, 3)
    printArray(strings)
//    printArray(ints)
  }
}
