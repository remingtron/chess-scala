package com.remingtron.chess

import com.remingtron.chess.piece.{Piece, Position}

abstract class Move {
  val piece: Piece
  val position: Position
}

case class NonCaptureMove(override val piece: Piece, override val position: Position) extends Move {

}

case class CaptureMove(override val piece: Piece, override val position: Position) extends Move {

}
