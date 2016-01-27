package com.remingtron.chess

import com.remingtron.chess.piece.Piece
import com.remingtron.chess.piece.PieceColor.{Black, White}
import com.remingtron.chess.piece.PieceType.Pawn
import org.scalatest.{Matchers, path}

class GameTests extends path.FunSpec with Matchers {

  describe("Game") {

    describe("when board only has a single white pawn on a3") {

      val pawn = new Piece(White, Pawn, "a3")
      val game = new Game(pieces = List(pawn))

      it("has one available move on white's turn - pawn to a4") {
        game.availableMoves should contain(new Move(piece = pawn, position = "a4"))
      }

      it("has no available moves on black's turn") {
        game.currentTurn = Black
        game.availableMoves shouldBe empty
      }

    }

  }

}

