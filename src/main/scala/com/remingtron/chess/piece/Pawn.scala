package com.remingtron.chess.piece

import com.remingtron.chess.Board

case class Pawn(color: PieceColor, board: Option[Board]) extends Piece {
  val pieceCharacter = None

  def copy(color: PieceColor = this.color, board: Option[Board] = this.board): Pawn = {
    new Pawn(color, board)
  }
}
