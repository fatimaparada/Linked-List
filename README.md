# project1-cs3345-s20-datastruct
This project creates a custom linked list structure.
Introduction:

   This project creates a custom linked list structure.  
   It serves as an exercise in working with linked lists and nodes.
   


Overview:

   Suppose the names "Bob", "Dan", and "Ben", are added, the result is:

                -----     -----     -----     -----     -----
       head -->|  B  |-->| Ben |-->| Bob |-->|  D  |-->| Dan |--
                -----     -----     -----     -----     -----   |
                                                               ---
                                                                - 
                                                    


   If the names "Deb" and "Sarah" are added, it looks like this:

                -----     -----     -----     -----     -----     -----      -----     -----
       head -->|  B  |-->| Ben |-->| Bob |-->|  D  |-->| Dan |-->| Deb |--> |  S  |-->|Sarah|--
                -----     -----     -----     -----     -----     -----      -----     -----   |
                                                                                              ---
                                                                                               - 

   If "Deb" and "Sarah" are deleted, the list should look like the first list again.


Details:

   Create a Java class called NameList (not generic) that stores names and implements the
   structure shown above.  

   Note that the names are kept in sorted order.  Letter nodes are always uppercase.
   Lowercase names will follow uppercase names in normal sorted order.

   You may *not* use Java's LinkedList class.  You should create your own nodes and
   link them together as shown in the illustration.  

   Your class should support the following methods.  

   20 points
   add - Adds a new name.  Names must be at least 2 characters long.  Adds the letter node if not already present.

   20 points
   remove - Removes a name.  If the name is the last one for a letter, the letter
             node should also be removed.

   20 points
   removeLetter - Removes a letter and all names for that letter.  

   20 points
   find - Finds a name by traversing the nodes.

   10 points   
   toString - Returns a string of the list formatted as shown below using the first list above as an example:

       B
         Ben
         Bob
       D
         Dan      

   10 points
   main - Demonstrates the methods of your NameList class

  
Submit to eLearning:
  NameList.java
