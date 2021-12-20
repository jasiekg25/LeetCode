package algorithms.Sorting.QuickSort

object QuickSort {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 5, 2, 10, 3, 16, 2, 6)
    println(quickSort(nums).mkString("Array(", ", ", ")"))
  }

  def quickSort(nums: Array[Int]): Array[Int] = {
    def swap(array: Array[Int], firstIdx: Int, secondIdx: Int): Unit = {
      val tmp = array(firstIdx)
      array(firstIdx) = array(secondIdx)
      array(secondIdx) = tmp
    }

    def quickSort(nums: Array[Int], startIdx: Int, endIdx: Int): Unit = {
      if (startIdx < endIdx) {
        val pivotIdx = partition(nums, startIdx, endIdx)

        quickSort(nums, startIdx, pivotIdx - 1)
        quickSort(nums, pivotIdx, endIdx)
      }
    }

    def partition(nums: Array[Int], startIdx: Int, endIdx: Int): Int = {
      val pivot = nums(endIdx)
      var lastLesserElementIdx = (startIdx - 1)

      for (currentIdx <- startIdx until endIdx) {
        if (nums(currentIdx) < pivot) {
          lastLesserElementIdx = lastLesserElementIdx + 1
          swap(nums, lastLesserElementIdx, currentIdx)
        }
      }
      swap(nums, lastLesserElementIdx + 1, endIdx)
      lastLesserElementIdx + 1
    }

    quickSort(nums, 0, nums.length - 1)
    nums
  }
}
