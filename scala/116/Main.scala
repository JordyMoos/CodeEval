import scala.collection.immutable.HashMap
object Main extends App {
  val codeMap = HashMap(("" -> ' '), (".-" -> 'A'), ("-..." -> 'B'), ("-.-." -> 'C'), ("-.." -> 'D'), ("." -> 'E'), ("..-." -> 'F'), ("--." -> 'G'), ("...." -> 'H'), (".." -> 'I'), (".---" -> 'J'), ("-.-" -> 'K'), (".-.." -> 'L'), ("--" -> 'M'), ("-." -> 'N'), ("---" -> 'O'), (".--." -> 'P'), ("--.-" -> 'Q'), (".-." -> 'R'), ("..." -> 'S'), ("-" -> 'T'), ("..-" -> 'U'), ("...-" -> 'V'), (".--" -> 'W'), ("-..-" -> 'X'), ("-.--" -> 'Y'), ("--.." -> 'Z'), (".----" -> '1'), ("..---" -> '2'), ("...--" -> '3'), ("....-" -> '4'), ("....." -> '5'), ("-...." -> '6'), ("--..." -> '7'), ("---.." -> '8'), ("----." -> '9'), ("-----" -> '0'))
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    println(line.split(" ").map(codeMap).mkString(""))
  }
}