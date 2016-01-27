package com.remingtron.chess.piece

case class Piece(color: PieceColor, pieceType: PieceType, position: Position) {
}

trait ReadableTrait {
  override def toString: String = this.getClass.getSimpleName
}

sealed trait PieceColor extends ReadableTrait

object PieceColor {
  object White extends PieceColor
  object Black extends PieceColor
}

sealed trait PieceType extends ReadableTrait

object PieceType {
  object Pawn extends PieceType
}
