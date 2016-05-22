/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tweetsec.challenge

object PasswordStrengthEvaluator {
  def eval(text: String): PasswordScore = {
    new PasswordScore(text)
  }
}
