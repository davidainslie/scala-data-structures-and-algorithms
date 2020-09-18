package com.backwards.chap2

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

/*
[[[https://rob-bell.net/2009/06/a-beginners-guide-to-big-o-notation/]]]

How fast could an algorithm run?
How does it fare when you have ten input elements versus a million?
To answer such questions, we need to be aware of the notion of algorithmic complexity, which is expressed using the Big O notation.
An O(1) algorithm is faster than O(logn), for example.

What is this notation?
It talks about measuring the efficiency of an algorithm, which is proportional to the number of data items, N, being processed.

In simple words, this notation is used to describe how fast an algorithm will run.
It describes the growth of the algorithm's running time versus the size of input data.
*/
class BigONotationSpec extends AnyWordSpec with Matchers {
  "Big O" should {
    "reverse a list" in {
      lazy val rev: List[Int] => List[Int] = {
        case x :: xs => rev(xs) ++ List(x)
        case Nil => Nil
      }
      /*
      How many times does the first case clause match a list of six elements? 6.
      */

      rev(List(1, 2, 3, 4, 5, 6)) mustBe List(6, 5, 4, 3, 2, 1)
    }

    "count words" in {
      /*
      What is the hash table operation complexity for inserting/updating the pair?
      It is effectively constant time, that is, O(1). So the overall complexity is O(n).
      */

      val words = List("this", "is", "a", "that", "is", "a")

      val frequency: Map[String, Int] =
        words groupBy identity map { case (word, matches) =>
          word -> matches.length
        }

      frequency.get("is") mustBe Option(2)
    }
  }
}

/*
Basic steps of the "rev":

1 :: 2 :: 3

rev(2 :: 3) ++ List(1)

2 :: 3

rev(3) ++ List(2)

3 :: Nil

rev(Nil) ++ List(3)

Nil

-----------------

Nil ++ List(3)

Nil ++ List(3) ++ List(2)

Nil ++ List(3) ++ List(2) ++ List(1)

 */