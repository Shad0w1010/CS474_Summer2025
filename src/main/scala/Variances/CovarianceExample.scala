package Variances

class Box[+T](val content: T)

object CovarianceExample {
  def printBox(box: Box[Any]): Unit = println(box.content)

  def main(args: Array[String]): Unit = {
    val stringBox = new Box[String]("Scala Covariance")
    printBox(stringBox)
  }
}
