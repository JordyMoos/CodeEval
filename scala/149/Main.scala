object Main extends App {
  def consumeNumber(input: Array[String], output: Array[String], number: String): Array[String] = {
    consumeFlag(input.tail, output :+ (number * input.head.length))
  }

  def consumeFlag(input: Array[String], output: Array[String] = Array()): Array[String] = {
    if (input.isEmpty) output
    else {
      input.head match {
        case "0" => consumeNumber(input.tail, output, "0")
        case "00" => consumeNumber(input.tail, output, "1")
      }
    }
  }

  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    println(BigInt(consumeFlag(line.split(" ")).mkString(""), 2))
  }
}
