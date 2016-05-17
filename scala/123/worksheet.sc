
val line = "92,19,19,76,19,21,19,85,19,19,19,94,19,19,22,67,83,19,19,54,59,1,19,19"
val numbers = line.split(",").map(_.toInt).sortWith(_ < _)
val halfLength = numbers.length / 2
val middle = numbers(halfLength)
val count = numbers.count(_ == middle)

println(if (count > halfLength) middle else "None")
