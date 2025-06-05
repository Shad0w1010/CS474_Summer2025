object InfiniteDataSource {

  def infiniteDataStream(initVal: Int): LazyList[Int] =
    initVal #:: infiniteDataStream(initVal+1)

  def main(args: Array[String]): Unit = {
    val stream = infiniteDataStream(0)
    println(stream)
    println(stream.take(50).toList)
    println(stream.drop(50).take(50).toList)
  }
}
