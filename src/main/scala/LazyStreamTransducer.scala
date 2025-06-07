import scala.compiletime.{erasedValue, summonInline}

type Opt[A] = A match
  case Int => Option[Int]
  case _   => List[A]

trait Transducer[A]:
  lazy val state = new java.util.concurrent.atomic.AtomicInteger(0)
  def emit(a: A): Opt[A]

class IntTransducer extends Transducer[Int]:
  def emit(a: Int): Opt[Int] =
    state.incrementAndGet()
    Some(a * 2)

class GenericTransducer[A] extends Transducer[A]:
  def emit(a: A): Opt[A] =
    state.incrementAndGet()
    List(a).asInstanceOf[Opt[A]]

inline def transducer[A]: Transducer[A] =
  inline erasedValue[A] match
    case _: Int => new IntTransducer().asInstanceOf[Transducer[A]]
    case _      => new GenericTransducer[A]

@main def runTransducer() =
  val t1 = transducer[Int]
  println(t1.emit(6))                     // prints Some(12)
  val t2 = transducer[String]
  println(t2.emit("ok"))                  // prints List(ok)
