import java.util

object MyFunctorImpl:
  trait MyFunctor[Container[_]]:
    def map[From,To <: From](storage: Container[From])(f: From=>To):Container[To]

  class MyFunctorList extends MyFunctor[util.ArrayList]:
    override def map[From, To <: From](storage: util.ArrayList[From])
                                      (f: From => To): util.ArrayList[To] =
      val newArrList = new util.ArrayList[To]()
      val len = storage.size()
      var i:Int = 0
      while(i < len){
        val elem = storage.get(i)
        newArrList.add(i, f(elem))
        i = i + 1
      }
      newArrList

  @main def runMain_MyFunctorImpl(): Unit =
    val al = new util.ArrayList[String]()
    al.add("Mark  ")
    al.add("   cs474")
    println((new MyFunctorList).map(al)(e=>e.strip().concat("hehe")))