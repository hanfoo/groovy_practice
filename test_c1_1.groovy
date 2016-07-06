// 2016-07-05

def num = 0
new File('test_c1_1.groovy').eachLine { line ->
  num++
  println "$num: $line"
}
