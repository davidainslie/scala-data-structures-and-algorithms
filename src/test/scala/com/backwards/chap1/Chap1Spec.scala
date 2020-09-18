package com.backwards.chap1

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Chap1Spec extends AnyWordSpec with Matchers {
  "List" should {
    "be increasing" in {
      val x = List(1, 2, 3, 4, 5, 6, 7)
      val y = x zip x.drop(1)
      // List((1,2), (2,3), (3,4), (4,5), (5,6), (6,7))

      y forall { case (a, b) =>
        a < b
      } mustBe true
    }
  }
}