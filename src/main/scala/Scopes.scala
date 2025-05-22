object Scopes {
  class A:
    class B:
      class C:
        class D:
          object E:
            class F
  
  
  def main(args: Array[String]): Unit = {
    val a = new A
    val b = new a.B
    val c = new b.C
    val d = new c.D
    val e = d.E // E is a singleton object, accessed from an instance of D
    val f = new e.F // F is a class defined inside object E
  }
}
