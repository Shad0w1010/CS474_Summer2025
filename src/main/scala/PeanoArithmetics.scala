object PeanoArithmetics {
  trait Peano
  case object Zero extends Peano
  case class Succ(prev: Peano) extends Peano

  def add(op1:Peano, op2:Peano): Peano =
    op1 match {
      case Zero => op2
      case Succ(prev) => Succ(add(prev, op2))
    }

  def main(args: Array[String]): Unit = {
    val zero = Zero
    val one = Succ(zero)
    val two = Succ(one)
    println(add(one,two))
  }

}
