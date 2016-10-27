def rand(int c) {
  return Math.round(Math.random() * c)
}

while (true) {
  int o = rand(2)
  String ostr = o == 0 ? '+' : '-'
  int a = rand(20)
  int b = o == 0 ? rand(20) : rand(a)
  int r = o == 0 ? a + b : a - b
  String str = ""
  int c = 0
  while (str.trim() == "") {
    str = System.console().readLine("Larry, $a $ostr $b = ")
    if (str == null || str.toLowerCase() in ['exit', 'quit', 'q']) System.exit(0)
    try {
      c = str.toInteger()
    } catch (Exception e) {
      str = ""
    }
  } 
  if (r == c) println "Congradulation, Larry"
  else println "Wrong answer"
  println ""
}
