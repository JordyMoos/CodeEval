
def isLetter(c: Char) = {
  c.toInt >= 97 && c.toInt <= 122
}

case class Acc(total: Int = 0, next: Int = 26)

"ABb.Ccc".toLowerCase
  .filter(isLetter)
  .groupBy(x => x)
  .map(data => data._2.length)
  .toList
  .sortBy(count => -count)
  .foldLeft(Acc())((acc, count) => {
    Acc(acc.total + count * acc.next, acc.next - 1)
  })
  .total
