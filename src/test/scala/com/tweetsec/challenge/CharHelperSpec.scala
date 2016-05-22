/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tweetsec.challenge

class CharHelperSpec extends UnitSpec {
  behavior of "CharHelper"

  it should "return 1 for alphabetic string" in {
    val expected = 1
    val actual = CharHelper.parse("abc")
    assert(actual("typesCount") == expected)
  }
  
  it should "return 1 for numeric string" in {
    val expected = 1
    val actual = CharHelper.parse("123")
    assert(actual("typesCount") == expected)
  }
  
  it should "return 1 for whitespaces string" in {
    val expected = 1
    val actual = CharHelper.parse("\\t\\n ")
    assert(actual("typesCount") == expected)
  }
  
  it should "return 0 for empty string" in {
    val expected = 0
    val actual = CharHelper.parse("abc")
    assert(actual("typesCount") == expected)
  }
  
  it should "return 0 for null" in {
    val expected = 0
    val actual = CharHelper.parse("abc")
    assert(actual("typesCount") == expected)
  }
  
  it should "return 0 for a numeric type" in {
    val expected = 0
    val actual = CharHelper.parse("abc")
    assert(actual("typesCount") == expected)
  }
  
}
