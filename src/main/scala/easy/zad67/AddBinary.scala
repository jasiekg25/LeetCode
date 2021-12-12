package easy.zad67

object AddBinary {

  def main(args: Array[String]): Unit = {
    val a = "11"
    val b = "1"
    val c = "1010"
    val d = "1011"

    println(addBinary(a,b))
    println(addBinary(c,d))
  }

  def addBinary(first: String, second: String): String ={
    val longer = if (first.length < second.length) second else first
    val shorter = if(first == longer) second else first
    var longerIdx = longer.length - 1
    var shorterIdx = shorter.length - 1

    var resultNumber = ""
    var toAdd = 0

    while (longerIdx >= 0){
      val currentSum: Int =
        if (shorterIdx < 0) longer(longerIdx).asDigit + toAdd
        else longer(longerIdx).asDigit + shorter(shorterIdx).asDigit  + toAdd

      toAdd = if(currentSum == 2) 1 else 0
      resultNumber = (if(currentSum == 1) "1" else "0") ++ resultNumber

      longerIdx -= 1
      shorterIdx -= 1
    }

    if(toAdd == 0) resultNumber else "1" ++ resultNumber
  }
}
