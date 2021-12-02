package easy.zad9


case class Palindrome(value: Int) {
  private lazy val digits: Seq[Int] = getDigits(value)

  def isPalindrome: Boolean = {
    if(value < 0) return false
    var end = digits.length - 1
    var start = 0

    while(end != start){
      if(digits(start) != digits(end)) return false
      end -= 1
      start += 1
    }

    true
  }

  def getDigits(n: Int): List[Int] = {
    getDigits(n, Nil)
  }
  private def getDigits(n: Int, digits: List[Int]): List[Int] = {
    if (n < 10) n :: digits else getDigits(n / 10, (n % 10) :: digits)
  }
}

object Palindrome {
  def main(args: Array[String]): Unit ={
    print(Palindrome(121).isPalindrome)
  }
}
