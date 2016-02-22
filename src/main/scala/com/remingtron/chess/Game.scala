package com.remingtron.chess

import java.lang.Math.{abs, max}

import com.remingtron.chess.piece.{Position, PieceColor, Piece}
import com.remingtron.chess.piece.PieceColor.{Black, White}

class Game(private val pieces: List[Piece], val currentTurn: PieceColor = White) {

  def availableMoves(): List[Move] = {
    pieces.filter(_.color == currentTurn).flatMap(piece => availableMovesForPiece(piece))
  }

  def availableMovesForPiece(piece: Piece): List[Move] = {
    possibleNonCaptureMoves(piece) ++ possibleCaptureMoves(piece)
  }

  private def movingOffBoard(position: Position): Boolean = {
    position.rank > '8' || position.rank < '1'
  }

  private def possibleNonCaptureMoves(piece: Piece): List[Move] = {
    def moveSpaces(n: Int): Move = {
      new NonCaptureMove(piece, piece.position.copy(rank = piece.position.rank + moveDirection * n))
    }
    def pawnInStartingPosition: Boolean = {
      List((White, '2'), (Black, '7')).contains(piece.color, piece.position.rank)
    }
    val possibleNonCaptureMoves = if (pawnInStartingPosition) List(moveSpaces(1), moveSpaces(2)) else List(moveSpaces(1))
    possibleNonCaptureMoves.filterNot(move => movingOffBoard(move.position) || pieceExistsAlongPath(move.piece.position, move.position))
  }

  private def pieceExistsAlongPath(startingPosition: Position, endingPosition: Position): Boolean = {
    def convertToDirection(numberOfSpaces: Int): Int = {
      if (numberOfSpaces == 0) 0 else numberOfSpaces / abs(numberOfSpaces)
    }
    val numberOfFilesToMove = endingPosition.file - startingPosition.file
    val numberOfRanksToMove = endingPosition.rank - startingPosition.rank
    val fileDirectionToMove = convertToDirection(numberOfFilesToMove)
    val rankDirectionToMove = convertToDirection(numberOfRanksToMove)
    val numberOfSpacesToMove = max(abs(numberOfFilesToMove), abs(numberOfRanksToMove))

    (1 to numberOfSpacesToMove).map(n =>
      Position(rank = startingPosition.rank + rankDirectionToMove * n,
        file = startingPosition.file + fileDirectionToMove * n))
      .exists(position => pieceExistsAtPosition(position, None))
  }

  private def pieceExistsAtPosition(position: Position, color: Option[PieceColor]): Boolean = {
    pieces.exists(piece => piece.position == position && (color.isEmpty || color.get == piece.color))
  }

  private def moveDirection = if (currentTurn == White) 1 else -1

  private def oppositeColor(color: PieceColor) = if (color == White) Black else White

  private def possibleCaptureMoves(piece: Piece): List[CaptureMove] = {
    def candidate(files: Int) = new Position(rank = piece.position.rank + moveDirection, file = piece.position.file + files)
    List(-1, 1).map(files => new CaptureMove(piece = piece, position = candidate(files))).filter(c => pieceExistsAtPosition(c.position, Some(oppositeColor(piece.color))))
  }

}
