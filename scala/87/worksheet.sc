
val size = 3
val m = Array.fill[Int](size, size)(0)

def setRow(i: Int, x: Int): Unit = {
  m(i) = Array.fill[Int](size)(x)
}

def setCol(j: Int, x: Int): Unit = {
  m.foreach(_(j) = x)
}

def queryRow(i: Int): Unit = {
  println(m(i).sum)
}

def queryCol(j: Int): Unit = {
  println(m.map(_(j)).sum)
}

val setRowPat = "SetRow ([0-9]+) ([0-9]+)".r
val setColPat = "SetCol ([0-9]+) ([0-9]+)".r
val queryRowPat = "QueryRow ([0-9]+)".r
val queryColPat = "QueryCol ([0-9]+)".r

def processLine(line: String): Unit = {
  line match {
    case setRowPat(i, x) => setRow(i.toInt, x.toInt)
    case setColPat(j, x) => setCol(j.toInt, x.toInt)
    case queryRowPat(i) => queryRow(i.toInt)
    case queryColPat(j) => queryCol(j.toInt)
  }
}

setRow(2, 9)
setCol(1, 2)

queryRow(0)
queryRow(1)
queryRow(2)

queryCol(0)
queryCol(1)
queryCol(2)

processLine("SetCol 2 20")

m.map(_.toList)




