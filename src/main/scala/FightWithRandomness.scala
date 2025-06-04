import scala.util.Random

object FightWithRandomness {
  trait RNG {
    def nextInt: (Int, RNG)
  }

  type STATERNG = RNG => (Int, RNG)

  def unit(seed:Int): (STATERNG, RNG) =
    ((rgs: RNG)=>rgs.nextInt, ConcreteGenerator(seed))

  class ConcreteGenerator(seed:Int) extends RNG:
    private val rg = new Random(seed)
    override def nextInt: (Int, RNG) = (rg.between(1, 100), this)



  def main(args: Array[String]): Unit = {
    val (f, rg) = unit(10)
    val (v1, rg1) = f(rg)
    println("1st: "+ v1)

    val (v2:Int, rg2:RNG) = rg1.nextInt
    println("2st: " + v2)

    val (v3, rg3) = rg2.nextInt
    println("3st: " + v3)

  }
}
