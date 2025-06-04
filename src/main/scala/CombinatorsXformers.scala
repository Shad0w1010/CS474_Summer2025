object CombinatorsXformers {

  case class SmartMeterData[T](v:T):
    def map[S](f: T => S): SmartMeterData[S] = SmartMeterData(f(v))

  def main(args: Array[String]): Unit = {
    val input = SmartMeterData(2.35d)
    val o1 = input.map(v=>v.toString)
    val o2 = o1.map(v=>v+"; "+v)
    val o3 = o2.map(v=>v.replace(';', '-'))
    println(o3)
    println{
      SmartMeterData(2).map(_.toString).map(v=>v+ "  -" +v).map(_.reverse)
    }
  }
}
