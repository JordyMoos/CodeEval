
val line = "72 64 150 | 100 18 33 | 13 250 -6"
line.split('|').map(_.trim).map(_.split(' ').foreach(println))
