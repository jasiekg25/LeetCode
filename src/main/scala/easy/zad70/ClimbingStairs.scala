package easy.zad70

object ClimbingStairs {
  def main(args: Array[String]): Unit = {
    val n1 = 2
    val n2 = 3

    println(climbStairs(n1))
    println(climbStairs(n2))
  }

  def climbStairs(n: Int): Int = if (n <= 1) 1 else climbStairs(n - 1) + climbStairs(n - 2)
}
