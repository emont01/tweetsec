/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tweetsec.challenge

class PasswordStrengthEvaluatorSpec extends UnitSpec {
  behavior of "Password Strength Evaluator"
  
  it should "keep a copy of the original text" in {
    val originalText = "12Password34"
    val expected = "12Password34"
    val actual = PasswordStrengthEvaluator.eval(originalText)
    
    actual.originalText should equal(expected)
  }
  
  it should "replace any complete english words in text with any lower-case letter" in {
    val expected = "12password34"
    val actual = PasswordStrengthEvaluator.eval("12Password34")
    
    actual.processedText should equal(expected)
  }
  
  it should "assign the correct score for 'password1' --> 4" in {
    val expected = 4
    val passwordScore = PasswordStrengthEvaluator.eval("password1")
    val actual = passwordScore.value
    
    assert(actual == expected)
  }
  
  it should "assign the correct score for 'goat m4n' --> 15" in {
    val expected = 15
    val passwordScore = PasswordStrengthEvaluator.eval("goat m4n")
    val actual = passwordScore.value
    
    assert(actual == expected)
  }
  
  it should "assign the correct score for 's0_0per 5n4k3' --> 44" in {
    val expected = 44
    val passwordScore = PasswordStrengthEvaluator.eval("s0_0per 5n4k3")
    val actual = passwordScore.value
    
    assert(actual == expected)
  }
}
