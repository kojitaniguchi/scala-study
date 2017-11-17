case class Edge(from: Char, to: Char, distance: Int)

object ShortestPath {
  // 頂点
  val vertexes = 'A' to 'G'

  // 辺
  val edges = Seq(
    Edge('A', 'B', 1),
    Edge('A', 'C', 8),
    Edge('B', 'A', 1),
    Edge('B', 'C', 6),
    Edge('B', 'D', 6),
    Edge('B', 'E', 6),
    Edge('C', 'A', 8),
    Edge('C', 'B', 6),
    Edge('C', 'D', 7),
    Edge('D', 'B', 6),
    Edge('D', 'C', 7),
    Edge('D', 'F', 2),
    Edge('E', 'B', 6),
    Edge('E', 'F', 6),
    Edge('E', 'G', 8),
    Edge('F', 'D', 2),
    Edge('F', 'E', 6),
    Edge('F', 'G', 5),
    Edge('G', 'E', 8),
    Edge('G', 'F', 5)
  )

  def solveByBellmanFord(start: Char, goal: Char): Unit = {
    // 各頂点までの距離の初期化
    var distances = vertexes.map(v => (v -> Int.MaxValue)).toMap
    distances = distances + (start -> 0)

    var isUpdated = true
    while (isUpdated) {
      isUpdated = false
      edges.foreach { e =>
        if(distances(e.from) != Int.MaxValue && distances(e.to) > distances(e.from) + e.distance) {
          distances = distances + (e.to -> (distances(e.from) + e.distance))
          isUpdated = true
        }
      }
    }

    println(distances)
    println(distances(goal))
  }

  def solveByDijkstra(start: Char, goal: Char): Unit = {
  // 各頂点までの距離の初期化
  var distances = vertexes.map(v => (v -> Int.MaxValue)).toMap
  distances = distances + (start -> 0)
  var usedEdges: Set[Edge] = Set()
  var isUpdated = true
  while (isUpdated) {
    isUpdated = false
    edges.foreach { e =>
      if(!usedEdges.contains(e)
        && distances(e.from) != Int.MaxValue
        && distances(e.to) > distances(e.from) + e.distance) {
        distances = distances + (e.to -> (distances(e.from) + e.distance))
        usedEdges = usedEdges + e
        isUpdated = true
      }
    }
  }
  println(distances)
  println(distances(goal))
}

def solveByWarshallFloyd(start: Char, goal: Char): Unit = {
  // 二頂点間の距離の初期化
  var distanceMap: Map[(Char, Char), Int] = vertexes.map(v => ((v , v) -> 0)).toMap
  distanceMap = distanceMap ++ edges.map(e => (e.from, e.to) -> e.distance)
  def distance(v1: Char, v2: Char): Int = distanceMap.getOrElse((v1, v2), Int.MaxValue / 2)
  for (v1 <- vertexes; v2 <- vertexes; v3 <- vertexes) {
    distanceMap =  distanceMap + ((v2, v3) -> math.min(distance(v2, v3), distance(v2, v1) + distance(v1, v3)))
  }
  println(distanceMap)
  println(distanceMap((start, goal)))
}

}
