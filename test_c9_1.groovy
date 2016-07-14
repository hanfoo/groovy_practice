//2016-07-10

f = [
  'Hello',
  12,
  1.1,
  [1, 2, 3],
  [1: 1, 2: 2],
  1..3]

println f
println f.toString()
println f.dump()
println f.inspect()
println ''

f.each { println it.dump() }
println ''

f.each { println it.inspect() }
println ''

println f.properties
println ''

f.each { println it.properties }

