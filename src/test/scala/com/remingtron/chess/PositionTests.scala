package com.remingtron.chess

import com.remingtron.chess.piece.Position
import org.scalatest.{Matchers, path}

class PositionTests extends path.FunSpec with Matchers {

  describe("Position") {

    it("should be human-readable as string") {
      ("a4": Position).toString shouldEqual "a4"
    }

  }

}
