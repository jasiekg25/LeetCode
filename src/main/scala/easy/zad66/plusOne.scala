package easy.zad66

object plusOne {
  def main(args: Array[String]): Unit = {
    val digits1 = Array(1,2,3)
    val digits2 = Array(4,3,2,1)
    val digits3 = Array(0)
    val digits4 = Array(9)

    println(plusOne(digits1).mkString("Array(", ", ", ")"))
    println(plusOne(digits2).mkString("Array(", ", ", ")"))
    println(plusOne(digits3).mkString("Array(", ", ", ")"))
    println(plusOne(digits4).mkString("Array(", ", ", ")"))

  }

  def plusOne(digits: Array[Int]): Array[Int] = {
    val resultDigits: Array[Int] = Array.fill(digits.length + 1){0}
    var digitToAdd = 1

    for (reversedIdx <- (digits.length -1) to 0 by -1){
      val currentSum = digits(reversedIdx) + digitToAdd
      resultDigits(reversedIdx + 1) = currentSum % 10
      digitToAdd = currentSum / 10
    }

    resultDigits(0) = digitToAdd
    if(resultDigits(0) == 0) resultDigits.tail else resultDigits
  }
}
