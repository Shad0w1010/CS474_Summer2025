object Lambda2Scala {
//λx.x λx.x => λx.x => x

  def Identity[T](x: T): T = x

  def meth[T](p: T=>T): T=>T = (i:T)=>p(i)

//  Y(g) = (λf. (λx. f (x x)) (λx. f (x x))) g => g(Y(g))
  def Y(g: (Int=>Int)=>(Int=>Int) ): Int=>Int = (i:Int)=>g(Y(g))(i)

  def main(args: Array[String]): Unit = {
    println(Identity("cs474"))
    println(Identity(Identity))
    println {
      meth(meth(meth(_: Int => Int)))((i: Int) => i + 1)(2)
    }
    println {
      meth {
        Y((fact: Int => Int) => ((n: Int) => if n == 0 then 1 else n * fact(n - 1)))
      }(5)
    }
  }
}
