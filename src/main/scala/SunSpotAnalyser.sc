val values = "3 4 2 3 2 1 4 4 2 0 3 4 1 1 2 3 4 4".split(' ').map(_.toInt).toSeq
val sunSpots = for { (value, i) <- values.tail.tail.zipWithIndex } yield (i % values.tail.head, i / values.tail.head, value)
val score = (spot: Tuple3[Int, Int, Int]) => sunSpots.filter(s => (spot._1 - 1 to spot._1 + 1).contains(s._1) && (spot._2 - 1 to spot._2 + 1).contains(s._2))
def scores = sunSpots.map(spot => (spot, score(spot).map(_._3).sum)).sortBy(_._2).reverse
println(scores.take(values.head).map{ case (spot, score) => s"(${spot._1},${spot._2} score:$score)"}.mkString)



