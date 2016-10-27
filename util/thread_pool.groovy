import groovy.sql.Sql
import java.util.concurrent.ConcurrentLinkedQueue

dbConfig = ['jdbc:mysql://100.81.152.39:16427/oceanbase?useCursorFetch=true', 'root', '', 'com.mysql.jdbc.Driver']
db = Sql.newInstance(*dbConfig)

if (args.size() >= 1 && args[0] == '-c') {
  db.execute '''drop table if exists t2;'''
  db.execute '''create table t2 (pk int primary key, v varchar(2048));'''
  insert_sql = '''insert into t2 values(?,?);'''
  queue = new ConcurrentLinkedQueue()
  queue_end = false
  threads = []
  
  64.times {
    threads << Thread.start {
      long t = 0, c = 0
      def db = Sql.newInstance(*dbConfig)
      while (true) {
        def e = queue.poll()
        if (e) {
          def s = System.currentTimeMillis()
          db.execute insert_sql, [e, 'X' * 1024]
          t += System.currentTimeMillis() - s
          c ++
        } else if (queue_end) {
          break
        }
      }
      println "$t / $c = ${t.div(c)}"
    }
  }
  
  for (it in 1..1000000) {
    queue.add(it)
  }
  
  queue_end = true
  
  threads.each { it.join() }
}

db.execute '''set ob_query_timeout = 10000000000;'''
db.execute '''set ob_trx_timeout = 10000000000;'''

def ps = db.getConnection().prepareStatement('''select * from t2;''')
ps.setFetchSize(Integer.MIN_VALUE)
def rs = ps.executeQuery()
while (rs.next()) {
  //sleep(1)
}

