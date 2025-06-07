trait Greeter[F[_]]:
  def greet(name: String): F[String]

class ConsoleGreeter extends Greeter[Option]:
  override def greet(name: String) = Some(s"Howdy, $name")

given Greeter[Option] = new ConsoleGreeter

def hello[F[_]](name: => String)(using g: Greeter[F]) = g.greet(name)

@main def runLazyGiven() =
  println(hello("Mark"))
