package com.remingtron.chess

import com.remingtron.chess.piece.Piece
import com.remingtron.chess.piece.PieceColor.{Black, White}
import com.remingtron.chess.piece.PieceType.Pawn
import org.scalatest.{Matchers, path}

class GameTests extends path.FunSpec with Matchers {

  describe("Game") {

    describe("Pawns") {

      describe("when board only has a single white pawn on a3") {

        val whitePawn = new Piece(White, Pawn, "a3")

        it("has one available move on white's turn - pawn to a4") {
          val game = new Game(pieces = List(whitePawn), currentTurn = White)
          game.availableMoves should contain theSameElementsAs moveList(whitePawn, List("a4"))
        }

        it("has no available moves on black's turn") {
          val game = new Game(pieces = List(whitePawn), currentTurn = Black)
          game.availableMoves shouldBe empty
        }

      }

      describe("when board only has a single black pawn on a3") {

        val blackPawn = new Piece(Black, Pawn, "a3")

        it("has one available move on black's turn - pawn to a2") {
          val game = new Game(pieces = List(blackPawn), currentTurn = Black)
          game.availableMoves should contain theSameElementsAs moveList(blackPawn, List("a2"))
        }

        it("has no available moves on white's turn") {
          val game = new Game(pieces = List(blackPawn), currentTurn = White)
          game.availableMoves shouldBe empty
        }

      }

      describe("when board only has a single white pawn on a2") {

        val whitePawn = new Piece(White, Pawn, "a2")

        it("has two available moves on white's turn - pawn to a3 and pawn to a4") {
          val game = new Game(pieces = List(whitePawn), currentTurn = White)
          game.availableMoves should contain theSameElementsAs moveList(whitePawn, List("a3", "a4"))
        }

      }

      describe("when board only has a single black pawn on d7") {

        val blackPawn = new Piece(Black, Pawn, "d7")

        it("has two available moves on black's turn - pawn to d6 and pawn to d5") {
          val game = new Game(pieces = List(blackPawn), currentTurn = Black)
          game.availableMoves should contain theSameElementsAs moveList(blackPawn, List("d6", "d5"))
        }

      }

      describe("when board only has a single white pawn on d7") {

        val whitePawn = new Piece(White, Pawn, "d7")

        it("has one available move on white's turn - pawn to d8") {
          val game = new Game(pieces = List(whitePawn), currentTurn = White)
          game.availableMoves should contain theSameElementsAs moveList(whitePawn, List("d8"))
        }

      }

      describe("when board has a white pawn on d7 and a black pawn on d8") {

        val whitePawn = new Piece(White, Pawn, "d7")
        val blackPawn = new Piece(Black, Pawn, "d8")

        it("has no available moves on white's turn") {
          val game = new Game(pieces = List(whitePawn, blackPawn), currentTurn = White)
          game.availableMoves shouldBe empty
        }

      }

      describe("when board has a white pawn on a2 and a black pawn on a4") {

        val whitePawn = new Piece(White, Pawn, "a2")
        val blackPawn = new Piece(Black, Pawn, "a4")

        it("has one available move on white's turn - pawn to a3") {
          val game = new Game(pieces = List(whitePawn, blackPawn), currentTurn = White)
          game.availableMoves should contain theSameElementsAs moveList(whitePawn, List("a3"))
        }

      }

      describe("when board has a white pawn on a2 and a black pawn on a3") {

        val whitePawn = new Piece(White, Pawn, "a2")
        val blackPawn = new Piece(Black, Pawn, "a3")

        it("has no available moves on white's turn") {
          val game = new Game(pieces = List(whitePawn, blackPawn), currentTurn = White)
          game.availableMoves shouldBe empty
        }

      }

      describe("when board has a white pawn on b8") {
        val whitePawn = new Piece(White, Pawn, "b8")

        it("has no available moves on white's turn") {
          val game = new Game(pieces = List(whitePawn), currentTurn = White)
          game.availableMoves shouldBe empty
        }
      }

      describe("when board has a black pawn on b1") {
        val blackPawn = new Piece(Black, Pawn, "b1")

        it("has no available moves on black's turn") {
          val game = new Game(pieces = List(blackPawn), currentTurn = Black)
          game.availableMoves shouldBe empty
        }
      }

      def moveList(piece: Piece, positions: List[String]): List[Move] = {
        positions.map(position => new Move(piece = piece, position = position))
      }
    }

  }

}

