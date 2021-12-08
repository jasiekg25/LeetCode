package easy.zad28

import scala.annotation.tailrec

object StrStr {

  def main(args: Array[String]): Unit = {
    val string1 = "hello"
    val substring1 = "ll"

    val string2 = "aaaaa"
    val substring2 = "bba"

    val string3 = ""
    val substring3 = ""

    println(strStr(string1, substring1))
    println(strStr(string2, substring2))
    println(strStr(string3, substring3))
  }


  def strStr(string: String, subString: String): Int = {
    val SubStringLength = subString.length
    /*
    1) check if the haystack length is not less than needle length. Searching beyond this is meaningless.
    2) before getting the slice out of haystack check if the first character matches. Used && instead of &
    3) For the edge case mentioned in the questions of needle being empty checked it before calling recursive function.
    */
    @tailrec
    def recursiveStrStr(innerString: String, idx: Int): Int = {
      if (innerString.length >= SubStringLength) {
        if (subString(0) == innerString(0) && innerString.slice(0, SubStringLength) == subString) idx
        else recursiveStrStr(innerString.tail, idx + 1)
      }
      else -1
    }
    if (SubStringLength == 0) 0 else recursiveStrStr(string, 0)  //for the edge case of needle being empty
  }
}


