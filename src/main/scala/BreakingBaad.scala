object BreakingBaad {
/*  breakable {
    int x = 1
    int y = x+3
    doBreak
    println(x)
  }*/

  def doBreak = throw new Exception("Breaking Baad")
  def breakable(block: => Any): Any =
    try {
      block
    } catch {
      case e: Exception => println(e.getMessage)
    }

  def main(args: Array[String]): Unit = {
    println("Breaking Baad")
    breakable {
      val x = 1
      val y = x+3
      println("before the break")
      doBreak
      println(x)
      println("after the break")
    }
  }
}
