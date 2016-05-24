package com.tweetsec.challenge

import twitter4j._
import twitter4j.auth._
/**
 * @author ${user.name}
 */

object App {

  def main(args: Array[String]) {
    if (args.length == 0) {
      printUsage()
      System.exit(-1)
    }
    args(0) match {
      case "get_twitter_token" => getAccessToken()
      case "evaluator" => waitForTweets()
      case "help" => printUsage()
      case _ => printUsage()
    }
  }

  def getAccessToken() {
    val twitter = TwitterFactory.getSingleton()
    val requestToken = twitter.getOAuthRequestToken()
    var accessToken: AccessToken = null
    while (null == accessToken) {
      println("Open the following URL and grant access to your account:")
      println(requestToken.getAuthorizationURL())
      println("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
      val pin: String = scala.io.StdIn.readLine()
      try {
        if (pin.length > 0) {
          accessToken = twitter.getOAuthAccessToken(requestToken, pin);
        } else {
          accessToken = twitter.getOAuthAccessToken()
        }
      } catch {
        case tex: TwitterException => {
          if (401 == tex.getStatusCode()) {
            println("Unable to get the access token.")
          } else {
            tex.printStackTrace(System.out)
        }
          }
      }
    }
    printf(
      "Please use the following accessToken %s and accessTokenSecret %s\n",
      accessToken.getToken(),
      accessToken.getTokenSecret()
    )
    println("See http://twitter4j.org/en/configuration.html for more details")
  }

  def waitForTweets() {
    val twitter = TwitterFactory.getSingleton()
    var youShallNotPassword = new YouShallNotPassword(twitter)
    var currentUser = twitter.verifyCredentials()
    val statuses = twitter.getMentionsTimeline()
    var it = statuses.iterator()
    println("Processing mentions timeline for user: @%s".format(currentUser.getScreenName()))
    while (it.hasNext()) {
      Thread.sleep(10000) // FIXME: twitter limits can cause problems
      val status = it.next()
      val password = status.getText().replace("@%s".format(currentUser.getScreenName()), "").trim()
      if (password != "") {
        val author = "@" + status.getUser().getName()
        println("Evaluating password sent by %s: '%s'".format(author, password))
        youShallNotPassword.eval(author, password)
      }
    }
  }

  def printUsage() {
    println("Usage:\njava -jar you_shall_not_password.jar [command]")
    println("Command accepts any of the following: get_twitter_token, evaluator or help")
  }
}
