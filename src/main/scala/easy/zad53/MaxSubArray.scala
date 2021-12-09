package easy.zad53

object MaxSubArray {
  def main(args: Array[String]): Unit = {
    val nums1 = Array(-2,1,-3,4,-1,2,1,-5,4)
    val nums2 = Array(1)
    val nums3 = Array(5,4,-1,7,8)

    println(maxSubArray(nums1))
    println(maxSubArray(nums2))
    println(maxSubArray(nums3))

  }

  /* Kadane's Algorithm:
  Initialize:
    max_so_far = INT_MIN
    max_ending_here = 0

  Loop for each element of the array
    (a) max_ending_here = max_ending_here + a[i]
    (b) if(max_so_far < max_ending_here)
              max_so_far = max_ending_here
    (c) if(max_ending_here < 0)
              max_ending_here = 0
  return max_so_far

  Kadane's Algorithm Explanation:
  The simple idea of Kadane’s algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this).
  And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this).
  Each time we get a positive-sum compare it with max_so_far and update max_so_far if it is greater than max_so_far
  * */

  def maxSubArray(nums: Array[Int]): Int = {
    var max_so_far = -1
    var max_ending_here = 0

    for(idx <- nums.indices){
      max_ending_here = max_ending_here + nums(idx)
      if(max_so_far < max_ending_here) max_so_far = max_ending_here
      else if (max_ending_here < 0) max_ending_here = 0
      else max_so_far // can be any action -> scala lang specific need solution like this
    }
    max_so_far
  }


}
