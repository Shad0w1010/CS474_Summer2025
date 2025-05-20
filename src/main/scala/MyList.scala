class MyList(val head: Any, val tail: MyList) {
  def getHead: Any = head
}

class MyListWithLength(val head1: Any, val tail1: MyList, val len:Int) extends MyList(head1, tail1)

object MyList {
  def main(args: Array[String]): Unit = {
    val myList = new MyList(1, new MyList(2, new MyList(3, new MyList(4, new MyList(5, null)))))
    println(myList.getHead)
  }
}
