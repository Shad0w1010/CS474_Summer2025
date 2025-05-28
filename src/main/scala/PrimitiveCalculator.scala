object PrimitiveCalculator {
  enum CalcOps {
    case Value(v:Int)
    case Add(op1: CalcOps, op2:CalcOps)
    case Mult(op1: CalcOps, op2:CalcOps)
  }

  def eval(exp: CalcOps): Int = {
    exp match {
      case CalcOps.Value(v) => v
      case CalcOps.Add(op1, op2) => eval(op1) + eval(op2)
      case CalcOps.Mult(op1, op2) => eval(op1) * eval(op2)
    }
  }
  enum Student:
    case Roberto
    case Isaac

/*  trait Studentt
  class Roberto extends Studentt
  class Isaac extends Studentt*/

  def main(args: Array[String]): Unit = {
//    val st1 = Student.Roberto
    import CalcOps.*
    val program = Add(Add(Value(2),Value(3)),Mult(Add(Value(2),Value(6)),Value(3)))
    println(program)
    println(eval(program))
  }
}
