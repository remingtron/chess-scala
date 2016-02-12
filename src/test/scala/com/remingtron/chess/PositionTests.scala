package com.remingtron.chess

import com.remingtron.chess.piece.Position
import org.scalatest.{Matchers, path}

class PositionTests extends path.FunSpec with Matchers {

  describe("Position") {

    it("should be human-readable as string") {
      ("a4": Position).toString shouldEqual "a4"
    }

    it("two positions with the same value should be equal") {
      ("a5": Position) shouldEqual ("a5": Position)
    }

  }

}
