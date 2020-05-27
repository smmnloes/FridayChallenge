# Friday Coding Challenge

## How to run:  
- **Via Gradle:**  
    Use `$ ./gradlew run --args="\"<address input here>\"""`  (dont forget the escaped quotes)  
    The resulting JSON will be printed out to the command line.  
    
    Use `$ ./ gradlew test` to run tests.
    
- **Via IDE (IntelliJ):**  
  Run the main class with the input string as the parameter, wrapped in quotes.  
  You will need to enable annotation processing for Lombok to work, I would also  
  recommend to install the Lombok plugin for IntelliJ.
  
 ## Thoughts on the task:
 The way I realized the task is via Regex. This is not an ideal solution of course, because there  
 are nearly infinitely many address formats in the world which cannot be covered completely  
 this way.  
 It would also be possible to use some kind of heuristic on the tokenized string, which would run  
 into similar problems as the regex.  
 The best way would be to have a database of existing addresses and to query the input string against
 it to find a best match.  
 In any case, the best way would be to just call an existing Geocoding API, but that  
 felt a little like cheating :) In a real world scenario this would have been my preferred option, though.
  