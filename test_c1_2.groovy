// 2016-07-05

objs = [String, List, File]

for (o in objs)
{
  println o.'package'.name
}

println objs.'package'.name

println( [String, List, File].'package'.name )
