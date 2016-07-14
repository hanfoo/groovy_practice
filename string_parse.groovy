class CString {
  private String str
  private List<String> splits = []
  CString(String str) {
    this.str = str
    splitStr(str)
  }
  private void splitStr(String str) {
    int lastPos = 0
    def m = (str =~ '\\$\\w+')
    while (m.find()) {
      println "${m.group()}: ${m.start()} ${m.end()}"
      if (m.start() > lastPos) {
        splits << str[lastPos..<m.start()]
      }
      splits << m.group()
      lastPos = m.end()
    }
    if (str.size() > lastPos) splits << str[lastPos..<str.size()]
    println splits
  }
}

def s = new CString('$H + $C$$$$ - $H + $C_DF_E$ABC /')
