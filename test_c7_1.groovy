//2016-07-06

class Counter {
  public count = 0
}

def counter = new Counter()

counter.count = 1
assert counter.count == 1

def fieldName = 'count'
counter[fieldName]++
assert counter.count == 2
assert counter['count'] == 2
assert counter.@count == 2

