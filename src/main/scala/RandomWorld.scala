object RandomWorld {

  import scala.util.Random

  trait RNG:
    def next(): Int

  class FastRNG extends RNG:
    lazy val seed = Random(100) // built lazily

    def next() = seed.between(1,100)

  class SecureRNG extends RNG:
    lazy val seed = Random(java.time.Instant.now.hashCode)

    def next() = seed.between(101,1000)

  transparent inline def rng(insecure: Boolean): RNG =
    if insecure then new FastRNG else new SecureRNG // decision at call-site

  @main def runTransparent() =
    val g = rng(insecure = Random.nextBoolean())
    println(g.next())
}
