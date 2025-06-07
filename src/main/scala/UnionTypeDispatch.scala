object UnionTypeDispatch {
  type Num = Int | Double

  trait Calc[T]:
    def plus(a: T, b: T): T

  class IntCalc extends Calc[Int]:
    def plus(a: Int, b: Int) = a + b

  class DoubleCalc extends Calc[Double]:
    def plus(a: Double, b: Double) = a + b

  def lazyPlus(x: => Num, y: => Num) =
    x match
      case a: Int => new IntCalc().plus(a, y.asInstanceOf[Int])
      case b: Double => new DoubleCalc().plus(b, y.asInstanceOf[Double])

  @main def runUnion() =
    println(lazyPlus(1, 2))
    println(lazyPlus(1.3, 4.7))
}
