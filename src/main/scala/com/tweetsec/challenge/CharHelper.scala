/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tweetsec.challenge

object CharHelper {
  def parse(password: String): Map[String, Int] = {
    if (password == null || password.length <= 0) {
      return Map("typesCount" -> 0, "wordsCount" -> 0)
    }
    var types = 0
    var words = 0
    
    val alphaMatches = "[A-Za-z]+".r.findAllIn(password).length
    if (alphaMatches > 0) {
      types += 1
      words += alphaMatches
    }
    
    val numericMatches = "[0-9]+".r.findAllIn(password).length
    if (numericMatches > 0) {
      types += 1
      words += numericMatches
    }
    
    val blanksMatches = "\\s+".r.findAllIn(password).length
    if (blanksMatches > 0) {
      types += 1
      words += blanksMatches
    }
    
    val othersMatches = "[^A-Za-z0-9\\s]+".r.findAllIn(password).length
    if (othersMatches > 0) {
      types += 1
      words += othersMatches
    }
    
    return Map("typesCount" -> types, "wordsCount" -> words)
  }
}
