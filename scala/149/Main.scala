object Main extends App {
  def consume(input: Array[String], output: Array[String], number: String): Array[String] = {
    flag(input.tail, output :+ (number * input.head.length))
  }

  def flag(input: Array[String], output: Array[String] = Array()): Array[String] = {
    if (input.isEmpty) output
    else {
      input.head match {
        case "0" => consume(input.tail, output, "0")
        case "00" => consume(input.tail, output, "1")
      }
    }
  }

  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    println(Integer.parseInt(flag(line.split(" ")).mkString("").dropWhile(_ == '0'), 2))
  }
}