object Distance extends App {
  val kilometersPerHours = 11.0
  val minutes = 100.0
  val distance = kilometersPerHours * minutes / 60.0
  // s は文字リテラルの中で変数${aaaa}を使うときに必要
  println(s"走った距離は${distance}キロメートルです")
}
