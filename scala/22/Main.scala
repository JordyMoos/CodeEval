import scala.annotation.tailrec
object Main extends App {
  def fib(n: Int): Int = {
    @tailrec def loop(acc: Int, prev: Int, n: Int): Int = {
      if (n == 0) acc
      else loop(acc + prev, acc, n - 1)
    }
    loop(0, 1, n)
  }

  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0).map(_.toInt)
  lines.map(fib).foreach(println)
}
