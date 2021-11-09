# Comp20-proj4
Develop a Java program that maintains a list of names and phone numbers, or a phone directory of your friends.
. For the program, you should use the class
DirectoryEntry (see p. 69 of your textbook) to represent each item in the phone
directory. Then, you need to define the class PhoneDirectory that has
ArrayList<DirectoryEntry> theDirectory (see p. 69 of your textbook) as its private
data field and the following methods (in addition to its constructor and accessor
methods):
  
public String addOrChangeEntry(String name, String number)
// add an entry to directory or change an existing entry; return the old number or null if it is a
// new entry
  
public DirectoryEntry searchEntry(String name)
// search the entry referenced by name; return the entry searched or null if there is no entry
// for name
  
public DirectoryEntry removeEntry(String name)
// remove the entry referenced by name; return the entry removed or null if there is no entry
// for name
  
public void displayAllEntries()
// display all entries in a nice and readable format
  
Finally, you need to write a separate class (i.e., a driver program), named
proj4.java, that provides a user-friendly and menu driven program to allow the
user to select and execute the following operations/services:
1. Load a previously saved phone directory from file
2. Add or change an entry
3. Remove an entry
4. Search for an entry
5. Display all entries
6. Save the current phone directory to a file
7. Quit the program
Note that for both options 1 & 6 above, the program should prompt the user to
enter a file name. Further, for option 6, the program should ask the user if the file
should be replaced or appended.
