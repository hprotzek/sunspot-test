case class SunSpot(x: Int, y: Int, heat: Int)

val values = "3 4 2 3 2 1 4 4 2 0 3 4 1 1 2 3 4 4".split(' ').map(_.toInt).toSeq

val sunSpots = for {
  (value, i) <- values.tail.zipWithIndex
} yield SunSpot(i % values.head, i / values.head, value)

val score = (spot: SunSpot) => sunSpots.filter(s => (spot.x - 1 to spot.x + 1).contains(s.x) && (spot.y - 1 to spot.y + 1).contains(s.y))

def scores = sunSpots.map(spot => (spot, score(spot).map(_.heat).sum)).sortBy(_._2).reverse

println(scores.take(values.head).map{ case (spot, score) => s"(${spot.x},${spot.y} score:$score)"}.mkString)
