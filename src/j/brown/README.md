# Java-io-decorators

An experiment with the Decorator Pattern on Java-io-streams following on from the Head First Design Patterns chapter
 on the Decorator Pattern.
 
## InputStream Decorators
Four InputStream decorators are provided:
1. LowerCase - makes all characters lower case
2. FlipCase - flips the case of each character in the stream 
3. AlternatingCase - makes the alphabetic characters alternate in case e.g. AlTeRnAtE
4. L33tSpeak - translates to basic l33t speak where the vowels a, e, i and o are replaced with the numbers 4, 3, 1 and 0
 respectively e.g. 'Hello I am a robot' becomes 'H3ll0 1 4m 4 r0b0t'