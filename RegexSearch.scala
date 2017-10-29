object RegexSearch extends App {
  val text =  "きつねたぬたぬしせたぬいきたぬききつねたぬききつねわいぴる"
  val pattern = "たぬききつね"
  val matchIndexs = pattern.r.findAllIn(text).matchData.map(_.start).toList
  println(s"出現場所: ${matchIndexs}")
}

// String.r 文字列をRegex型に変換
// findAllIn Regex型のメソッドで与えられた正規表現にマッチするIteratorを取得(戻り値はMatchIterator)
// matchData MatchIteratorにマッチした文字列に対する様々な情報を与えるIterator[Match]型を与える
// map(_.start) マッチ情報から出現箇所のインデックスを取得(Iterator[Match]型がIterator[Int]型に変換)
// toList Iterator[Int]型をtoList関数を呼び出してSeqとして扱えるList[Int]型に変換
