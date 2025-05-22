abstract class Scholar {
  def name: String
}

class Grad extends Scholar {
  def name: String = "Grad"
}

class PhD extends Grad {
  override def name: String = "PhD"
}

def main(args: Array[String]): Unit = {
  
}
