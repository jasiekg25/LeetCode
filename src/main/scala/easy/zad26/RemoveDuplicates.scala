package easy.zad26

object RemoveDuplicates {
  def main(args: Array[String]): Unit = {
    val nums1 = Array(1, 1, 2)
    val nums2 = Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)

    println(removeDuplicates(nums1))
    println(nums1.mkString("Array(", ", ", ")"))
    println(removeDuplicates(nums2))
    println(nums2.mkString("Array(", ", ", ")"))
  }

  def removeDuplicates(nums: Array[Int]): Int = {
    var inputIdx = 0
    var outputIdx = 0

    if (nums.length == 0) 0
    else {
      inputIdx = 1
      while (inputIdx < nums.length && outputIdx < nums.length) {
        if (nums(outputIdx) == nums(inputIdx)) inputIdx += 1
        else { // (nums(inputIdx) < nums(outputIdx))
          outputIdx += 1
          nums(outputIdx) = nums(inputIdx)
          inputIdx += 1
        }
      }
      outputIdx + 1

    }
  }
}
