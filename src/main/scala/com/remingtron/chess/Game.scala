package com.remingtron.chess

import com.remingtron.chess.piece.{PieceColor, Piece}
import com.remingtron.chess.piece.PieceColor.White

class Game(private val pieces: List[Piece], var currentTurn: PieceColor = White) {

  def availableMoves(): List[Move] = {
    pieces.filter(_.color == currentTurn).map(piece => new Move(piece, piece.position.copy(rank = piece.position.rank + 1)))
  }

}
