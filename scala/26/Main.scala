import java.io.File

object Main extends App {
  val file = new File(args(0))
  println(file.length)
}
