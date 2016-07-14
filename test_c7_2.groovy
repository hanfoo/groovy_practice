//2016-07-06

class Counter {
  public count = 0

  Object get(String name) {
    return 'fake value'
  }
  void set(String name, Object v) {
    count++
  }
}

def counter = new Counter()
assert counter.no1 == 'fake value'
assert counter.count == 0

counter.no2 = 3
assert counter.count == 1

assert counter['no3'] == 'fake value'

counter['no4'] = 'ff'

assert counter.count == 2
