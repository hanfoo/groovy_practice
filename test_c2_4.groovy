//2016-07-06

def l = ['1', '2', '3', '4']

assert l[1] == '2'

l[7] = '8'

println l

assert l.size() == 8

def http = [
  100 : 'CONTINUE',
  200 : 'OK',
  400 : 'BAD REQUEST' ]

assert http.size() == 3

http[500] = 'INTERNAL SERVER ERROR'

assert http.size() == 4

assert l instanceof List
assert http instanceof Map

println http


def r = 1..10
println r
assert r.contains(5)
assert r.contains(11) == false
println r.from + '..' + r.to

print 10..1

assert (10..1).contains(5)
