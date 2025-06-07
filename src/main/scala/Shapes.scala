object Shapes {
  enum Shape derives CanEqual:
    case Square(side: Double)
    case Circle(radius: Double)

    def area: Double = this match
      case Square(s) => s * s
      case Circle(r) => math.Pi * r * r

  val maker: [S] => () => Shape = [S] => () => Shape.Square(2.0)

  lazy val cachedShape: Shape = maker[Int]()

  @main def runLazyLambda() =
    println(cachedShape.area)
}
