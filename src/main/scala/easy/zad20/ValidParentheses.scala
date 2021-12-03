package easy.zad20

sealed trait BracketType
object CurlyBracket extends BracketType
object SquareBracket extends BracketType
object RoundBracket extends BracketType

object ValidParentheses {
  def main(args: Array[String]): Unit = {
    val strings = List("()", "()[]{}", "(]", "([)]", "{[]}")

    print(strings.map(brackets => (brackets, ValidParentheses(brackets).validate)))
  }
}

case class ValidParentheses(s: String) {
  import BracketMapper._

  def validate: Boolean = {
    var curlyCounter = 0 // {
    var roundCouter = 0 // (
    var squareCounter = 0 // [

    var lastOpened: Option[BracketType] = None

    for (idx <- s.indices) {
      val bracket = s(idx)
      val bracketType = getBracketType(bracket)

      bracketType match {
        case RoundBracket => roundCouter += valueMapper(bracket)
        case CurlyBracket => curlyCounter += valueMapper(bracket)
        case SquareBracket => squareCounter += valueMapper(bracket)
      }

      if (!lastOpened.contains(bracketType)) return false
      if (isOpening(bracket)) lastOpened = Some(bracketType)
      if (roundCouter < 0 || curlyCounter < 0 || squareCounter < 0) return false
    }

    true
  }
}

object BracketMapper {
  def getBracketType(bracketSymbol: Char): BracketType = bracketSymbol match {
    case '(' => RoundBracket
    case ')' => RoundBracket
    case '[' => SquareBracket
    case ']' => SquareBracket
    case '{' => CurlyBracket
    case '}' => CurlyBracket
  }

  val valueMapper: Map[Char, Int] = Map(
    '(' -> 1,
    '{' -> 1,
    '[' -> 1,
    ')' -> -1,
    '}' -> -1,
    ']' -> -1
  )

  def isOpening(bracketSymbol: Char): Boolean = bracketSymbol match {
    case ')' => false
    case '(' => true
    case ']' => false
    case '[' => true
    case '}' => false
    case '{' => true
  }
}

