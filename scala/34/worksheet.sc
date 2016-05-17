
val line = "2,4,5,6,9,11,15;20"
val Array(numbersString, totalString) = line.split(";")

val total = totalString.toInt
val numbers = numbersString.split(",")
val index = numbers.zipWithIndex.toMap

def isEligible(x: Int): Boolean = {
  val remainder = total - x
  if (x * 2 >= total)
    false
  else if (numbers contains remainder.toString)
    true
  else false
}

def expand(x: Int): String = {
  val remainder = total - x

  x.toString + "," + remainder.toString
}

val newLine = numbers.map(_.toInt)
  .filter(isEligible)
  .map(expand)
  .mkString(";")

if (newLine.length > 0)
  println(newLine)
else
  println("NULL")
