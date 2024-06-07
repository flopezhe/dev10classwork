# Capsule Hotel Plan

## The application user is the hotel administrator.

- On start up, the application prompts the administrator for the hotel's capacity. The capacity determines how many capsules are available.
- The administrator may book a guest in an unoccupied numbered capsule.
- The administrator may check out a guest from an occupied capsule.
- The administrator may view guests and their capsule numbers in groups of 11.
## Technical Requirements

- When the program starts up, capsules and guests will be represented by a String[] of the appropriate size.
Unoccupied capsules are represented by a null array value.
Occupied capsules are represented by the occupant's name as a String.
At least one method beyond main is required. A few more methods may make your life easier.

Start Up 
- Welcome output
- Output hotel capacity and availability status
  - sout (messages)
  - print an array displaying capsules empty or occupied
    - if empty print null, if occupied print guest name
-  Give options
Options 
- Give the below options to the admin
  - Use method() to give out prompt
  - Use do() and switch()
    - case 1 booking on unoccupied
      - Give error when occupied
     - case 2 check out guest from occupied
       - Give error when unoccupied
     - case 3 view guests 
       - Do so in groups of 11 (5 before or after)
      