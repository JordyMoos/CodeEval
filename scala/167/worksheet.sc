
val line = "Amy Lawrence was proud and glad, and she tried to make Tom see it in her face - but he wouldn't look."
if (line.length > 55) {
  val chunked = line.substring(0, 40)
  val split = chunked splitAt (chunked lastIndexOf ' ')
  val text = if (split._1.length > 0) split._1 else split._2
  println(text + "... <Read More>")
}
else
  println(line)
