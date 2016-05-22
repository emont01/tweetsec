/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tweetsec.challenge

class YouShallNotPasswordSpec extends UnitSpec {
  behavior of "YouShallNotPassword"
  
  it should "Strong passwords should receive a congratulatory tweet in response" in {
    //
  }
  
  it should "Weak passwords should receive a strengthened version of the original password" in {
    //The modified version should be no longer than the original, unless it must 
    //be lengthened to qualify as strong.
  }
  
  it should "Unacceptable passwords should receive a response suggesting that the sender try again with a better password." in {
    //
  }
}
