package easy.zad35

import scala.annotation.tailrec

object SearchInsertPosition {
  def main(args: Array[String]): Unit = {
    val nums0 = Array(1, 3, 5, 6)
    val nums1 = Array(1)

    val insertValue0 = 5
    val insertValue1 = 2
    val insertValue2 = 7
    val insertValue3 = 0

    println(searchInsertPosition(nums0, insertValue0))
    println(searchInsertPosition(nums0, insertValue1))
    println(searchInsertPosition(nums0, insertValue2))
    println(searchInsertPosition(nums0, insertValue3))
    println(searchInsertPosition(nums1, insertValue3))


  }

  def searchInsertPosition(nums: Array[Int], value: Int): Int = {
    @tailrec
    def searchInsertPositionRec(nums: Array[Int], value: Int, leftBorder: Int, rightBorder: Int): Int = {
      val idxToCheck: Int = (rightBorder - leftBorder) / 2
      if (leftBorder == rightBorder) leftBorder
      else if (nums(idxToCheck) < value)
        searchInsertPositionRec(nums, value, idxToCheck + 1, rightBorder)
      else if (nums(idxToCheck) > value)
        searchInsertPositionRec(nums, value, leftBorder, idxToCheck)
      else idxToCheck
    }

    if (nums(0) > value) 0
    else if (nums.last < value) nums.length
    else searchInsertPositionRec(nums, value, 0, nums.length)
  }

}
