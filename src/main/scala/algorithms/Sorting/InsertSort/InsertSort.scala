package algorithms.Sorting.InsertSort

object InsertSort {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 5, 2, 10, 3, 16, 2, 6)
    println(insertSort(nums).mkString("Array(", ", ", ")"))
  }

  def insertSort(nums: Array[Int]): Array[Int] = {
    val length = nums.length
    for (idx <- 1 until length){
      val valueToCheck = nums(idx)
      var innerIdx = idx - 1
      while(innerIdx >= 0 && valueToCheck < nums(innerIdx)){
        nums(innerIdx + 1) = nums(innerIdx)
        innerIdx -= 1
      }
      nums(innerIdx + 1) = valueToCheck
    }
    nums
  }

}
