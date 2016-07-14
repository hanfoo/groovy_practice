//2016-07-07

String oracle(Object o) { return 'object' }
String oracle(String s) { return "string: $s" }

Object i1 = 1
Object s1 = '1'

assert oracle(i1) == 'object'
assert oracle(s1) == 'string: 1'

class A {
  boolean equals(A o) {
    return true
  }
}

Object a1 = new A(), a2 = new A()
Object o = new Object()

assert a1 == a2
assert !(a1 == o)

class B {
}

Object b1 = new B(), b2 = new B()
assert !(b1 == b2)
