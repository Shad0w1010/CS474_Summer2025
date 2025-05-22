object PassFunctionAsParam {

  def triple(i:Int, f: Int=>Int): Int = f(f(f(i)))

  def main(args: Array[String]): Unit = {
    val res = triple(5, x => x + 2)
    println(res)
  }
}
