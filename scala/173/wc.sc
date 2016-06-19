val line = "Shellless mollusk lives in wallless house in wellness. Aaaarrghh!"

line.foldLeft("")((acc: String, c: Char) => {
  if ( ! acc.isEmpty && acc.last == c) acc
  else acc + c
})
