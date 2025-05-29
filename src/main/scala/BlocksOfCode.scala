object BlocksOfCode {
  lazy val blockVar = {
    println("subblock")
    2+3
  }

  var i = 0
  def marksIf(cond: => Boolean)(trueBlock: => Any)(falseBlock: => Any) =
    if cond then trueBlock else falseBlock

  def marksWhile(cond: => Boolean)(block: => Any):Any =
    if cond then {
      block
      marksWhile(cond)(block)
    }

  /*try{
    println("try")
    throw new Exception("error")
  } catch {
    case e: Exception => println(e.getMessage)
  }*/

  def main(args: Array[String]): Unit = {
//    println(blockVar)
    marksWhile(i < 5){
      println(i)
      i = i + 1
    }
    marksIf(blockVar == 2){
      println("true block")
    }{
      println("false block")
    }
  }

}
