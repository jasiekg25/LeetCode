package easy.zad13

case class RomanNumber(romanNumber: String){
  val valueMapper: Map[Char, Int] = Map(
    'I' -> 1,
    'V' -> 5,
    'X' -> 10,
    'L' -> 50,
    'C' -> 100,
    'D' -> 500,
    'M' -> 1000
  )
  def convertToInt: Int = {
    lazy val reversedRomanNumber = romanNumber.reverse
    lazy val size = romanNumber.length
    var i = 0
    var sum = 0

    while (i < size){
      val currentRomanSymbol: Char = reversedRomanNumber(i)
      val nextRomanSymbol: Char = if (i + 1 < size) reversedRomanNumber(i + 1) else 'M'

      if (valueMapper(currentRomanSymbol) > valueMapper(nextRomanSymbol)) {
        sum = sum + valueMapper(currentRomanSymbol) - valueMapper(nextRomanSymbol)
        i = i + 2
      } else {
        sum = sum + valueMapper(currentRomanSymbol)
        i = i + 1
      }
    }
    sum
  }

}

object RomanNumber {
  def main(args: Array[String]): Unit ={
    val romanNumber = "MCMXCIV"
    print(RomanNumber(romanNumber).convertToInt)
  }
}