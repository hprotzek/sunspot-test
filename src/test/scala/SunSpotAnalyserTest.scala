import org.scalatest._

class SunSpotAnalyserSpec extends FlatSpec with Matchers {

  "This test data" should
    "results" in {
    val sunSpot = new SunSpotAnalyser("3 4 2 3 2 1 4 4 2 0 3 4 1 1 2 3 4 4")
    sunSpot.analyse shouldBe ("(1,2 score:27)(1,1 score:25)(2,2 score:23)")
  }


}
