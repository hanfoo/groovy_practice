//2016-07-10

f = [
  'Hello',
  12,
  1.1,
  [1, 2, 3],
  [1: 1, 2: 2],
  1..3]

println f.class.methods.each { println it.properties }
println ''

println f.metaClass.metaMethods.name
