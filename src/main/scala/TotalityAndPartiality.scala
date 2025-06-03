object TotalityAndPartiality {

  def mean(lst:List[Float]): Float =
    lst.sum/lst.length

  class MeanComputation extends PartialFunction[List[Float], Float] {
    override def isDefinedAt(x: List[Float]): Boolean = if x.length == 0 then false else true

    override def apply(lst: List[Float]): Float = lst.sum/lst.length
  }
  val pf:PartialFunction[List[Float], Float] = (lst: List[Float])=>lst.sum/lst.length
  def main(args: Array[String]): Unit = {
    println(mean(List(5.0f, 7.0f, 10.0f)))
    println(mean(List()))
  }

}
