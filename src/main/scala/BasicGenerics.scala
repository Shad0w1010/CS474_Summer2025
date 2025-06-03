object BasicGenerics {
  def identityX[TypeVar](x: TypeVar): TypeVar = x
//  def identityX(x: Any): Any = x
//  def xForm(x:Int):String = x.toString
//  def xForm(x:Float):String = x.toString
  def xForm[I,O](x: I, f: I=>O):O = f(x)

  def main(args: Array[String]): Unit = {
    println(identityX("cs474"))
    println(identityX(4.74f))
    println(xForm("cs474", (s:String)=>s.length))
  }
}
