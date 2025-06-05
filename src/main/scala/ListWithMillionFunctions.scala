object ListWithMillionFunctions {
  val lst = List.fill(100000)((i:Int)=>i+2)
  def main(args: Array[String]): Unit = {
    val res = lst.foldLeft(1)((acc, f)=> f(acc))
    val funcComp = lst.foldLeft((i:Int)=>i)((acc, f)=> acc andThen f)
    println(funcComp)
    println(funcComp(1))
  }
}
