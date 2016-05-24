object Main extends App {
  for (i <- 1 to 12; j <- 1 to 12) {
    if (j == 1) print(" " + (i * j) takeRight 2)
    else print("    " + (i * j) takeRight 4)
    if (j == 12) println()
  }
}
