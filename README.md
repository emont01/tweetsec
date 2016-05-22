# TweetSec
My solution to the TweetSec challenge https://gist.github.com/patbenatar/069e46e6a34d65f35108


## Intro

Our newest client, TweetSec Ltd., has developed a proprietary method for
evaluating password strength. As part of a marketing initiative they'd like us
to develop a Twitter bot that will apply the algorithm to any message it
receives, and reply with the result.

## Enter @YouShallNotPassword

Our product is a Twitter bot written in your technology of choice. It should:
* Capture tweets sent to its account
* Evaluate the 'password strength' of each message
* Post a reply tweet with the result

## The TweetSec Password Strength Evaluator

TweetSec's patented password strength evaluation algorithm consists of three
steps. Beginning with the text of the tweet, we must:

1. Replace any complete English words in the text with any lower-case letter,
preferring longer replacements. For example, given `12password34` we should
replace the full word 'password' rather than replacing 'pass' or 'sword'.
1. Find the number of 'character types' represented in the updated text.
Character types include:
  * alphabet (A-Z, a-z)
  * digits (0-9)
  * whitespace (spaces, tabs, newline characters)
  * other (punctuation, unicode characters, etc.)
1. Multiply the number of represented character types by the length of
the updated text to arrive at a numerical 'strength' value.

For example, here are some passwords and their strength rating:
* `password1` --> 4
* `goat m4n` --> 15
* `s0_0per 5n4k3` --> 44

## Responses

Based on the strength rating of a password, it should be placed into one of
three categories:
* __Strong__ - for `strength >= 50`
* __Weak__ - for `strength > 10` and `strength < 50`
* __Unacceptable__ - for `strength =< 10`

__Strong__ passwords should receive a congratulatory tweet in response.

__Weak__ passwords should receive a modified version of the original tweet which
has been strengthened enough to qualify as __strong__. The modified version
should be no longer than the original, unless it _must_ be lengthened to qualify
as __strong__.

__Unacceptable__ passwords should receive a response suggesting that the sender
try again with a better password.

## The icebox

While not a requirement at this stage, TweetSec is interested in maintaining the
memorability of passwords for their potential clients. If you find yourself with
extra time, consider optimizing the way passwords are strengthened to prefer
changes that maintain the essence of the original password (for example, `foo`
might become `f00` rather than `f^o` or `6oo`).

----

# Deliverables

* A Github repository containing all code/documentation for the app

# Guidelines

* Feel free to develop any type of app. A command-line script and
  a Rails app are both perfectly acceptable, business logic is the priority.
* Leave a detailed commit history -- no need to write novel-length commit
  messages, but be descriptive enough that we can follow your progress.
* We hope this will take 2-4 hours to complete. If you hit 5 hours, stop and
  push what you have. If you finish much earlier you can try the non-required
  features above, but keep in mind the client will want to see completed
  functionality.
