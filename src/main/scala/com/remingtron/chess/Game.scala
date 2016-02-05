package com.remingtron.chess

import com.remingtron.chess.piece.{PieceColor, Piece}
import com.remingtron.chess.piece.PieceColor.{Black, White}

class Game(private val pieces: List[Piece], val currentTurn: PieceColor = White) {

  def availableMoves(): List[Move] = {
    pieces.filter(_.color == currentTurn).flatMap(piece => availableMovesForPiece(piece))
  }

  def availableMovesForPiece(piece: Piece): List[Move] = {
    def moveSpaces(n: Int): Move = {
      new Move(piece, piece.position.copy(rank = piece.position.rank + moveDirection * n))
    }
    def pawnInStartingPosition: Boolean = {
      List((White, '2'), (Black, '7')).contains(piece.color, piece.position.rank)
    }
    if (pawnInStartingPosition) List(moveSpaces(1), moveSpaces(2)) else List(moveSpaces(1))
  }

  private def moveDirection = if (currentTurn == White) 1 else -1

}
