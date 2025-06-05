object DataStructsFunctional {
  // head -> e1 -> e2 -> .... -> tail
  // empty list head? => false
  trait CS474List[+T]
  case object EmptyList474 extends CS474List[Nothing]
  case class ::[T](head: T, tail: CS474List[T]) extends CS474List[T]

  def processList[T](lst: CS474List[T], what2Find: T): CS474List[T] =
    lst match {
      case ::(head, tail) => if head == what2Find then tail else processList(tail, what2Find)
      case EmptyList474 => lst
      case _ => ???
    }

  def main(args: Array[String]): Unit = {
    val lst1 = ::("Roberto", EmptyList474)
    val lst2 = ::("Zak", lst1)
    val lst3 = ::("Dominic", lst2)
    val genLst = ::("Dominic",::("Zak",::("Roberto",EmptyList474)))
    println(lst3)
    println {
      processList(lst3, "Zak")
    }
  }
}
