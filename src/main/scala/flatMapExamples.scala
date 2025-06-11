object flatMapExamples {

  println{
  "This is our last week of classes".flatMap(c=>c.toString.toUpperCase)
  }
  val lstInts = List(1, 2, 3)
  val lstStrs = List("hoy", "ahi", "no")
  val f = (s: String, i: Int) => s + "--" + i.toString
  println {
    for {
      s <- lstStrs
      i <- lstInts
    } yield f(s, i)
  }

  if lstInts.nonEmpty then
    println {
      lstStrs.flatMap(s => lstInts.map(i => List(f(s, i))).flatten)
    }
  println {
    lstStrs.flatMap(s => {
      val f = (i: Int) => s + "--" + i.toString
      for {
        i <- lstInts
      } yield f(i)
    })
  }
  val newLst = lstInts.map(e => List(e - 1, e, e + 1))
  val newLst1 = lstInts.flatMap(e => List(e - 1, e, e + 1))

  def main(args: Array[String]): Unit = {
    println(newLst)
    println(newLst1)
  }

}
