object BindingFuncNames {
  val field:Int = 5
  
  val mital:3 = 3

  def m(i: Int): Unit = {
    def m1() = println("m1")
    require(i > 0)
    m1()
    println(i)
  }

  def main(args: Array[String]): Unit = {
//    println(mital)
    m(5)
//    m(-3)
  }
}
