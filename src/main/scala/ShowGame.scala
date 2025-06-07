object ShowGame {
  import scala.deriving.*

  trait Show[T]:
    def show(t: T): String

  object Show:
    inline given derived[T](using m: Mirror.Of[T]): Show[T] = _ => s"derived(${m.toString})"

  case class Point(x: Int, y: Int) derives Show

  lazy val serializer: Show[Point] = summon[Show[Point]] // resolved lazily

  @main def runDerive() =
    println(serializer.show(Point(1, 2)))
}
