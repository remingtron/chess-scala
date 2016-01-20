package com.remingtron.chess

import com.remingtron.chess.piece.{Piece, Pawn}
import com.remingtron.chess.piece.PieceColor.White
import org.scalatest.{Matchers, path}

class BoardTests extends path.FunSpec with Matchers {

  describe("Board") {

    val board = new Board
    val pawn = new Pawn(White, None)

    it("starts off empty") {
      (0 to 7).foreach(rank => (0 to 7).foreach(file => board.pieceAt(rank = rank, file = file) shouldBe None))
    }

    it("can have a pawn on one of its spaces") {
      board.placePiece(rank = 1, file = 1, piece = pawn)
      val piece = board.pieceAt(rank = 1, file = 1).get
      piece shouldBe a [Pawn]
      piece.color shouldBe pawn.color
    }

    it("doesn't have a piece on any other spaces") {
      board.placePiece(rank = 1, file = 1, piece = pawn)
      board.pieceAt(rank = 1, file = 2) shouldBe None
    }

    it("updates piece to have reference to board when placed") {
      board.placePiece(rank = 1, file = 3, piece = pawn)
      val piece = board.pieceAt(rank = 1, file = 3).get
      piece shouldBe a [Pawn]
      piece.color shouldBe pawn.color
      piece.board.get shouldBe board
    }

  }
}