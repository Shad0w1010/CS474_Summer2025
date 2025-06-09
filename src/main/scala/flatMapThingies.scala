object flatMapThingies {
  val lst = Vector(2, 5, 8)
  val f = (i:Int)=>Vector(i-1,i,i+1)
  def main(args: Array[String]): Unit = {
    println(lst.map(f))
    println(lst.map(f).flatten)
    println(lst.flatMap(f))
  }

}
