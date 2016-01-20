package com.remingtron.chess.piece

import com.remingtron.chess.piece.PieceColor.White
import org.scalatest.{Matchers, path}

class PawnTests extends path.FunSpec with Matchers {

  describe("Pawn") {

    it("does not have a display character") {
      new Pawn(White, None).displayString shouldBe "w"
    }
  }

}
