package com.remingtron.chess.piece

case class Position(file: Int, rank: Int) {
  override def toString: String = file.toChar.toString + rank.toChar
}

object Position {
  implicit def stringToPosition(string: String): Position = {
    new Position(file = string.charAt(0).toLower, rank = string.charAt(1))
  }
}
