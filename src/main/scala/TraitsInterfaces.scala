object TraitsInterfaces {
  trait Glasses
  trait Student
  class Undergraduate extends Student
//  class UndergraduateBespec extends Student with Glasses
  class Graduate extends Student
//  class GraduateBespec extends Student with Glasses

  def main(args: Array[String]): Unit = {
    val jesus:Student = new Undergraduate with Glasses
  }
}
