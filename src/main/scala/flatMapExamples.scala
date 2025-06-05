object flatMapExamples {

  val lst = List(1,2,3)
  val newLst = lst.map(e => List(e-1, e, e+1))
  val newLst1 = lst.flatMap(e => List(e-1, e, e+1))
  def main(args: Array[String]): Unit = {
    println(newLst)
    println(newLst1)
  }

}
