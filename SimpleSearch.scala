object SimpleSearch extends App {
  val text =  "きつねたぬたぬしせたぬいきたぬききつねたぬききつねわいぴる".toSeq
  val pattern = "たぬききつね".toSeq
  val matchIndexs = serch(text, pattern)

  def serch(text: Seq[Char], patterm: Seq[Char]): Seq[Int] = {
    var matchIndexs = Seq[Int]()
    for (i <- 0 to text.length - 1) {
      val partText = text.slice(i, i + pattern.length)
      if (isMatch(partText, pattern)) matchIndexs = matchIndexs :+ i
    }
    matchIndexs
  }

  def isMatch(textPart: Seq[Char], pattern: Seq[Char]): Boolean = {
    var isMatch = true
    for (i <- 0 to pattern.length - 1) {
      if (textPart.length < pattern.length || textPart(i) != pattern(i)) isMatch = false
    }
    isMatch
  }

  println(s"出現場所: ${matchIndexs}")
}
