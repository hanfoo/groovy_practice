def stat = [
  'Simple' : [
    'lf_fifo': [],
    'jemalloc': []
  ],
  'Window' : [
    'lf_fifo': [],
    'jemalloc': []
  ],
  'Pairwise' : [
    'lf_fifo': [],
    'jemalloc': []
  ],
]
def CurCase = ''
def CurAlloc = ''

System.in.eachLine {
  f = it =~ /\[ RUN      \] Test(\w+)Allocate.(\w+)/
  if (f) {
    CurCase = f[0][1]
    CurAlloc = f[0][2]
  } else {
    f = it =~ / *(\d+) +(\d+) +\d\d:\d\d:\d\d +\d\d:\d\d:\d\d/
    if (f) {
      stat[CurCase][CurAlloc][f[0][1].toInteger()] = f[0][2].toInteger()
    }
  }
}

def GpTemplate = """
set terminal pngcairo noenhanced
set output "${-> casename}.png"
set xlabel "Number of Threads"
set ylabel "Run Time [usec]"
set key top left
plot "/tmp/tmpdata" using 1:2 title "lf_fifo ${-> casename}" with lines, "" using 1:3 title "je_malloc ${-> casename}" with lines
"""

stat.each { c, d ->
  casename = c
  def fifo = d['lf_fifo']
  def je = d['jemalloc']
  new File("/tmp/tmpdata").withWriter { writer ->
    for (int i in 1..fifo.size()) {
      if (fifo[i]) writer.append("$i ${fifo[i]} ${je[i]}\n")
    }
  }
  new File("/tmp/11.gp").withWriter { writer ->
    writer.write(GpTemplate)
  }
  "gnuplot /tmp/11.gp".execute()
  // if no sleep here, the previous two images would be zero size
  // don't know what cause it
  sleep(1)
}

