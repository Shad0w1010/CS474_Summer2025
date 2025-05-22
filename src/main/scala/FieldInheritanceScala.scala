object FieldInheritanceScala {
  class Parent {
    val field = 10
  }

  class Child extends Parent {
    override val field = 20
  }
  
  object Bubble:
    val field = 10
    def method = "x"
  
  def main(args: Array[String]): Unit = {
    val res: Parent = new Child
    println(res.field)
    println(Bubble.field)
    println(Bubble.method)
  }
}
