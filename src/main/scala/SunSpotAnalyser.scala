
case class SunSpot(x: Int, y: Int, heat: Int)

class Sun(values: Seq[Int]) {

  private val size = values.head

  val sunSpots = for {
    (value, i) <- values.tail.zipWithIndex
  } yield SunSpot(i % size, i / size, value)
}

class SunSpotAnalyser(inputStr: String) {

  private val input = inputStr.split(' ').map(_.toInt).toSeq

  private val sun: Sun = new Sun(input.tail)

  private val resultSize = input.head

  private val score = (spot: SunSpot) => sun.sunSpots.filter(s => (spot.x - 1 to spot.x + 1).contains(s.x) && (spot.y - 1 to spot.y + 1).contains(s.y))

  private def scores = sun.sunSpots.map(spot => (spot, score(spot).map(_.heat).sum)).sortBy(_._2).reverse

  def analyse: String = scores.take(resultSize).map{ case (spot, score) => s"(${spot.x},${spot.y} score:$score)"}.mkString
}
