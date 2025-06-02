object BasicLambdaFromLec7 {
//  λf. λx.f(f x) or λfx.f(f x)
  val lambdaExp = (f:Int=>Int)=>(x:Int)=>f(f(x))

  val _f: Int=>Int = x=>x+1
  val ff: Int=>Int  = i=>_f(_f(i))
  class DoubleApp extends Function1[Int,Int] {
    override def apply(v1: Int): Int = ff(v1)
  }

  val fff: Int => Int = (i:Int)=> _f(ff(i))
  def main(args: Array[String]): Unit = {
    println(lambdaExp(x=>x+10)(2))
    println(_f(2))
    println(ff(2))
    println(fff(2))
    val d = new DoubleApp
    println(d(2))
  }
}
