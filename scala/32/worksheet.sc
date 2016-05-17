
val line = "Hello World,World"
val Array(message, postFix) = line.split(",")
println(if (message.endsWith(postFix)) "1" else "0")


