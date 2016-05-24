/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tweetsec.challenge

import twitter4j.Twitter

class YouShallNotPassword(val twitter: Twitter) {

  def eval(author: String, password: String) {
    val score = PasswordStrengthEvaluator.eval(password)
    var status = author + " "
    if (score.value >= 50) {
      twitter.updateStatus(
        "Congratulations %s '%s' is a strong password!".format(author, password)
      )
    } else if (score.value > 10) {
      val suggestion = hardening(password)
      twitter.updateStatus(
        "%s '%s' is a weak password, try with '%s'".format(author, password, suggestion)
      )
    } else {
      twitter.updateStatus(
        "%s unacceptable password, please try again with a better password!".format(author)
      )
    }
  }

  def hardening(text: String) = {
    val pattern = "[^aeio]".r
    text.collect(_.toLower match {
      //case pattern(c) => c
      case 'a' => '4'
      case 'e' => '3'
      case 'i' => '1'
      case 'o' => '0'
      case extra => extra
    })
  }
}
