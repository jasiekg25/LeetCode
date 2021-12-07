package easy.zad27

object RemoveElement {
  def main(args: Array[String]): Unit = {
    val args1 = Array(3,2,2,3)
    val value1 = 3

    val args2 = Array(0, 1, 2, 2, 3, 0, 4, 2)
    val value2 = 2

    println(removeDuplicate(args1, value1))
    println(removeDuplicate(args2, value2))

    println(args1.mkString("Array[", " , ", "]"))
    println(args2.mkString("Array[", " , ", "]"))
  }

  def removeDuplicate(nums: Array[Int], value: Int): Int = {
    var currentIdx = 0
    var outputIdx = 0
    if(nums.length == 0) 0
    else
      while(outputIdx < nums.length && currentIdx < nums.length){
        if(nums(currentIdx) != value){
          nums(outputIdx) = nums(currentIdx)
          currentIdx += 1
          outputIdx += 1
        } else{
          currentIdx += 1
        }
    }
    outputIdx
  }
}
