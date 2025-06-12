package Variances

trait Printer[-T] {
  def print(value: T): Unit
}

class AnyPrinter extends Printer[Any] {
  override def print(value: Any): Unit = println(value)
}

object ContravarianceExample {
  def printerProcessor(printer: Printer[String]): Unit =
    printer.print("Scala Contravariance")

  def main(args: Array[String]): Unit =
    printerProcessor(new AnyPrinter)
}
