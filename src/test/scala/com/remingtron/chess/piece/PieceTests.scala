package com.remingtron.chess.piece

import com.remingtron.chess.Board
import com.remingtron.chess.piece.PieceColor.{Black, White}
import org.scalatest.{Matchers, path}

class PieceTests extends path.FunSpec with Matchers {

  case class SamplePiece(color: PieceColor) extends Piece {
    val board = None
    val pieceCharacter = Some('m')

    override def copy(color: PieceColor, board: Option[Board]): Piece = new SamplePiece(color)
  }

  describe("Piece") {

    it("can be white") {
      new SamplePiece(White).color shouldBe White
    }

    it("can be black") {
      new SamplePiece(Black).color shouldBe Black
    }

    it("can be displayed when white") {
      new SamplePiece(White).displayString shouldBe "wm"
    }

    it("can be displayed when black") {
      new SamplePiece(Black).displayString shouldBe "bm"
    }

  }

}
