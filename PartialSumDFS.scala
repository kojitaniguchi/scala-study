object PartialSumDFS extends App {
  val a = Seq(1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3 , 8, 13)
  val n = a.length
  val k = 444

  // 深さ優先探索
  def isMatchAndResult(index: Int, partial: Seq[Int]): (Boolean, Seq[Int]) = {
    if (index == n) {
      return if (partial.sum == k) (true, partial) else (false, Seq())
    }
    val (isMatchNotAdd, resultNotAdd) = isMatchAndResult(index + 1, partial)
    if (isMatchNotAdd) return (isMatchNotAdd, resultNotAdd)

    isMatchAndResult(index + 1, partial :+ a(index))
  }

  val (isMatch, result) = isMatchAndResult(0, Seq())
  if (isMatch) println(s"Yes ${result} ") else println("No")
}
