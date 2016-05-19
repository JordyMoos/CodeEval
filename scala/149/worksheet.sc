
def consume(input: Array[String], output: Array[String], number: String): Array[String] = {
  flag(input.tail, output :+ (number * input.head.length))
}

def flag(input: Array[String], output: Array[String]): Array[String] = {
  if (input.isEmpty) output
  else {
    input.head match {
      case "0" => consume(input.tail, output, "0")
      case "00" => consume(input.tail, output, "1")
    }
  }
}

val line = "00 0 0 00 00 0"
val values = line.split(" ")

Integer.parseInt(flag(values, Array()).mkString("").dropWhile(_ == '0'), 2)

