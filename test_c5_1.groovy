//2016-07-09

def x = 0

2.times {
  10.times {
    x += it
  }
  println x
}

def cc = { x += it }
2.times {
  10.times cc
  println x
}

def createClosure() {
  def y = 0
  return {
    y += 1
    println y
  }
}

3.times createClosure()
3.times createClosure()
