//2016-07-11

def p = new GroovyShell().parse('a + m.c / d[0]')

p.a = 10
p.m = [c : 100]
p.d = [20, 30]

assert p.run() == 15

p.m.c = 50

assert p.run() == 12.5
