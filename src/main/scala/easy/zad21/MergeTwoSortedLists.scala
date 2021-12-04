package easy.zad21

import scala.math.min

case class MergeTwoSortedLists(firstList: List[Int], secondList: List[Int]) {
  def mergedListes: List[Int] = {
    val firstListLength = firstList.length
    val secondListLength = secondList.length

    var currentIdxFirst = 0
    var currentIdxSecond = 0

    var resultList: List[Int] = Nil

    while (currentIdxFirst < firstListLength || currentIdxSecond < secondListLength) {
      val addedValue: Int =
        if (currentIdxFirst < firstListLength && currentIdxSecond < secondListLength) {
          val value: Int = min(firstList(currentIdxFirst), secondList(currentIdxSecond))
          if (value == firstList(currentIdxFirst)) currentIdxFirst += 1 else currentIdxSecond += 1
          value
        } else if (currentIdxFirst >= firstListLength) {
          val value = secondList(currentIdxSecond)
          currentIdxSecond += 1
          value
        } else {
          val value = firstList(currentIdxFirst)
          currentIdxFirst += 1
          value
        }
      resultList = addedValue :: resultList
    }
    resultList
  }
}

object MergeTwoSortedLists {
  def main(args: Array[String]): Unit = {
    val list1 = List()
    val list2 = List()
    val list3 = List(0)

    print(MergeTwoSortedLists(list1, list2).mergedListes)
    print(MergeTwoSortedLists(list1, list3).mergedListes)


  }
}
