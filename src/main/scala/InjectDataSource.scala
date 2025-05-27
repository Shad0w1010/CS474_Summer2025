object InjectDataSource {
  trait AbstractProcessor:
    def process(data: String): String

  class Binary extends AbstractProcessor:
    def process(data: String): String =
      println("binary")
      data
  class Yaml extends AbstractProcessor:
    def process(data: String): String =
      println("yaml")
      data
  class Json extends AbstractProcessor:
    def process(data: String): String =
      println("json")
      data
  class DataProcessing(val data: String):
    def processData(processor: AbstractProcessor): String = processor.process(data)

  def main(args: Array[String]): Unit = {
    new DataProcessing("cs474").processData(new Yaml)
  }
}
