/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tweetsec.challenge

class PasswordScore(val originalText: String) {
  val processedText: String = originalText.toLowerCase
  
  private[this] val _score: Map[String, Int] = CharHelper.parse(processedText)
  
  def value: Int = {
    _score("typesCount") * _score("wordsCount")
  }
}
