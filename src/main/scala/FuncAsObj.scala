object FuncAsObj {
  class MyOwnFunc extends (Int=>String){
    override def apply(v1: Int): String = v1.toString + v1.toString
  }

  class MyOwnFuncEquivalent extends Function1[Int, String]{
    override def apply(v1: Int): String = v1.toString + v1.toString
  }

  def main(args: Array[String]): Unit = {
    println {
      new MyOwnFunc().apply(1) == new MyOwnFuncEquivalent().apply(1)
    }

    println {
      new MyOwnFunc().apply(1) == ((v1:Int)=>v1.toString + v1.toString)(1)
    }
  }

}
