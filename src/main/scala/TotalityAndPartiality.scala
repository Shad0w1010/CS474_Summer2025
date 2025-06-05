object TotalityAndPartiality {

  trait Maybe[+T]
  case object Bupkis extends Maybe[Nothing]
  case class Perfect[T](v:T) extends Maybe[T]
  
  def mean(lst:List[Float]): Maybe[Float] = {
    if lst.isEmpty then Bupkis else Perfect(lst.sum/lst.length)
  }  
  
  def meanO(lst:List[Float]): Option[Float] = {
    if lst.isEmpty then None else Some(lst.sum/lst.length)
  }

  def meanE(lst: List[Float]): Either[String, Float] = {
    if lst.isEmpty then Left("You cannot divide by zero") else Right(lst.sum / lst.length)
  }

  class MeanComputation extends PartialFunction[List[Float], Float] {
    override def isDefinedAt(x: List[Float]): Boolean = if x.length == 0 then false else true

    override def apply(lst: List[Float]): Float = lst.sum/lst.length
  }
  val pf:PartialFunction[List[Float], Float] = (lst: List[Float])=>lst.sum/lst.length
  def main(args: Array[String]): Unit = {
    println(mean(List(5.0f, 7.0f, 10.0f)))
    println(mean(List()))
    println(meanE(List()))
  }

}
