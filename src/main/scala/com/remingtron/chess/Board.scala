package com.remingtron.chess

import com.remingtron.chess.piece.Piece

class Board {

  private val board: Array[Array[Option[Piece]]] = Array.fill(8, 8)(None)

  def placePiece(rank: Int, file: Int, piece: Piece) = {
    board(rank)(file) = Some(piece.copy(board = Some(this)))
  }

  def pieceAt(rank: Int, file: Int): Option[Piece] = {
    board(rank)(file)
  }

}
