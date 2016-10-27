import groovy.sql.Sql

host = '10.101.194.52'
port = 56143
user = 'root@sys'
pwd  = ''

c = 0
db = Sql.newInstance("jdbc:mysql://$host:$port/", user, pwd, "com.mysql.jdbc.Driver")
while (true) {
  db.execute('alter system major freeze;')
  ++c
  println "major freeze $c"
  sleep(1000)
  while (true) {
    r = db.rows("select info from oceanbase.__all_zone where zone = '' and name = 'merge_status';")
    if (r.size() == 1 && r[0].info == 'MERGING') sleep(1000)
    else if (r.size() == 1 && r[0].info == 'IDLE') break
    else if (r.size() != 1) println "ERROR $r"
  }
  sleep(10000)
}
