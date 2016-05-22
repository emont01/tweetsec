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
}
