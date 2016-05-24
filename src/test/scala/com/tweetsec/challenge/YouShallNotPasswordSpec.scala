/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tweetsec.challenge

import twitter4j.Twitter
import org.mockito.Mockito._

class YouShallNotPasswordSpec extends UnitSpec {

  behavior of "YouShallNotPassword"

  it should "send a congratulatory tweet in response for strong passwords" in {
    val m = mock[Twitter]
    val app = new YouShallNotPassword(m)
    app.eval("@JohnDoe", "4 v3ry str0ng passw0rd.")
    
    verify(m).updateStatus("Congratulations @JohnDoe '4 v3ry str0ng passw0rd.' is a strong password!")
  }

  it should "send a strengthened version of the original password for weak passwords" in {
    //The modified version should be no longer than the original, unless it must 
    //be lengthened to qualify as strong.
    val m = mock[Twitter]
    val app = new YouShallNotPassword(m)
    app.eval("@JohnDoe", "s0_0per 5n4k3")
    
    verify(m).updateStatus("@JohnDoe 's0_0per 5n4k3' is a weak password, try with 's0_0p3r 5n4k3'")
  }

  it should "send a response suggesting that the sender try again with a better password." in {
    val m = mock[Twitter]
    val app = new YouShallNotPassword(m)
    app.eval("@JohnDoe", "password1")
    
    verify(m).updateStatus("@JohnDoe unacceptable password, please try again with a better password!")
  }
  
  //FIXME: add tests for some common error responses like statusCode=403, message=Status is a duplicate.
}
