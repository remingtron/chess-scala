package com.remingtron.chess.piece

import com.remingtron.chess.Board
import com.remingtron.chess.piece.PieceColor.White

trait Piece {

  val color: PieceColor
  val board: Option[Board]
  val pieceCharacter: Option[Char]

  def displayString: String = {
    val colorString = if (color == White) "w" else "b"
    colorString + pieceCharacter.getOrElse("")
  }

  def copy(color: PieceColor = this.color, board: Option[Board] = this.board): Piece

}

sealed trait PieceColor

object PieceColor {
  object White extends PieceColor
  object Black extends PieceColor
}
