/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tweetsec.challenge

class CharHelperSpec extends UnitSpec {
  behavior of "CharHelper"

  // whitespaces only password
  it should "return 1 types count for whitespaces string" in {
    val expected = 1
    val actual = CharHelper.parse("\t\n ")
    assert(actual("typesCount") == expected)
  }

  it should "return 1 words count for whitespaces string" in {
    val expected = 1
    val actual = CharHelper.parse("\t\n ")
    assert(actual("wordsCount") == expected)
  }
  
  // alphabetic only password
  it should "return 1 types count for alphabetic string" in {
    val expected = 1
    val actual = CharHelper.parse("abc")
    assert(actual("typesCount") == expected)
  }
  
  it should "return 1 words count for alphabetic string" in {
    val expected = 1
    val actual = CharHelper.parse("abc")
    assert(actual("wordsCount") == expected)
  }
  
  // numeric only password
  it should "return 1 types count for numeric string" in {
    val expected = 1
    val actual = CharHelper.parse("12345")
    assert(actual("typesCount") == expected)
  }
  
  it should "return 1 words count for numeric string" in {
    val expected = 1
    val actual = CharHelper.parse("12345")
    assert(actual("wordsCount") == expected)
  }
  
  // special case: empty string
  it should "return 0 types count for empty string" in {
    val expected = 0
    val actual = CharHelper.parse("")
    assert(actual("typesCount") == expected)
  }
  
  it should "return 0 words count for empty string" in {
    val expected = 0
    val actual = CharHelper.parse("")
    assert(actual("wordsCount") == expected)
  }
  
  // special case: null
  it should "return 0 types count for null" in {
    val expected = 0
    val actual = CharHelper.parse(null)
    assert(actual("typesCount") == expected)
  }
  
  it should "return 0 words count for null" in {
    val expected = 0
    val actual = CharHelper.parse(null)
    assert(actual("wordsCount") == expected)
  }
  
  // challenge example passwords
  it should "return 2 types count for 'password1' string" in {
    val expected = 2
    val actual = CharHelper.parse("password1")
    assert(actual("typesCount") == expected)
  }
  
  it should "return 2 words count for 'password1' string" in {
    val expected = 2
    val actual = CharHelper.parse("password1")
    assert(actual("wordsCount") == expected)
  }
  
  it should "return 3 types count for 'goat m4n' string" in {
    val expected = 3
    val actual = CharHelper.parse("goat m4n")
    assert(actual("typesCount") == expected)
  }
  
  it should "return 5 words count for 'goat m4n' string" in {
    val expected = 5
    val actual = CharHelper.parse("goat m4n")
    assert(actual("wordsCount") == expected)
  }
  
  it should "return 4 types count for 's0_0per 5n4k3' string" in {
    val expected = 4
    val actual = CharHelper.parse("s0_0per 5n4k3")
    assert(actual("typesCount") == expected)
  }
  
  it should "return 11 words count for 's0_0per 5n4k3' string" in {
    val expected = 11
    val actual = CharHelper.parse("s0_0per 5n4k3")
    assert(actual("wordsCount") == expected)
  }
}
