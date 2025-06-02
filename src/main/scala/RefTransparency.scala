import scala.collection.mutable.ListBuffer

object RefTransparency {

  val lst: ListBuffer[Int] = ListBuffer(1,2,3)

  def SideEffectIncFunc(lst: ListBuffer[Int]) = {
    val lstOut: ListBuffer[Int] = ListBuffer()

    var i = 0
    while (i < lst.length) {
      //    val res = lst(i)+1
      lstOut.insert(i, lst(i) + 1)
      i += 1
    }
  }

  def myMap(lst: ListBuffer[Int], f: Int => Int): ListBuffer[Int] = {
    val lstOut: ListBuffer[Int] = ListBuffer()

    var i = 0
    while (i < lst.length) {
      //    val res = lst(i)+1
      lstOut.insert(i, f(lst(i)))
      i += 1
    }
    lstOut
  }

  def main(args: Array[String]): Unit = {
    println(SideEffectIncFunc(ListBuffer(1,2,3)))
    println(myMap(ListBuffer(1,2,3), x => 2*x))
    println(List(1,2,3).map(_+10))
  }

}
