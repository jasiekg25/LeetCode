package easy.zad14

case class CommonPrefix(words: Seq[String]) {
  def longestPrefix: String = {
    //    vars
    var letterIndex = 0
    var currentLetter: Char = words(0)(letterIndex)
    var prefix: List[Char] = Nil

    //    vals
    val maxIdx: Int = words.minBy(_.length).length

    while (letterIndex < maxIdx) {
      currentLetter = words(0)(letterIndex)
      for (currentWord <- words.indices)
        if (currentLetter != words(currentWord)(letterIndex)) return prefix.reverse.mkString

      prefix = currentLetter :: prefix
      letterIndex = letterIndex + 1
    }
    prefix.reverse.mkString
  }
}

object CommonPrefix {
  def main(args: Array[String]): Unit = {
    val strs = Seq("flower","flow","flight")
    val strs2 = Seq("dog","racecar","car")
    print("\nstrs1:\t" + CommonPrefix(strs).longestPrefix)
    print("\nstrs2:\t" + CommonPrefix(strs2).longestPrefix)
  }
}
