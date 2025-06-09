object MonadExperiments:
  val objList = List((s:String)=>s.length)
  val objInts = List(5,10)


  @main def runMain_MonadExperiments(): Unit =
    //    List(List(6, 7), List(11, 12)) for map
    println("cs474 in Summer 2025".flatMap(c=>c.toString))
    println(objInts.flatMap((i:Int)=>List(i+1, i+2)))
    println(objList.flatMap(f=>List((s:String)=>f(s))))
    println(objList.flatMap(f=>List(f("Aswin"))))