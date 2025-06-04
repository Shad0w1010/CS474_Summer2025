class CupOfCoffee {

  class CupOfCoffee
  class Charge
  class CreditCard
  class Payment

  def buyCoffee(n:Int): List[CupOfCoffee] = ???
  def charge4Coffee(lst:List[CupOfCoffee]): Charge = ???
  def pay4Coffee(c: Charge, creditCard: CreditCard): Payment = ???

  def main(args: Array[String]): Unit = {
    pay4Coffee(charge4Coffee(buyCoffee(3)), CreditCard())
  }

}
