package algorithms.Sorting.BubbleSort

object BubbleSort {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 5, 2, 10, 3, 16, 2, 6)
    println(bubbleSort(nums).mkString("Array(", ", ", ")"))
  }

  def bubbleSort(nums: Array[Int]): Array[Int] = {
    val length = nums.length
    for (idx <- nums.indices) {
      for (innerIdx <- 0 until (length - 1 - idx)){
        if(nums(innerIdx) > nums(innerIdx + 1)) swap(nums, innerIdx, innerIdx + 1)
      }
    }
    nums
  }

  def swap(array: Array[Int], firstIdx: Int, secondIdx: Int): Unit ={
    val tmp = array(firstIdx)
    array(firstIdx) = array(secondIdx)
    array(secondIdx) = tmp
  }
}
