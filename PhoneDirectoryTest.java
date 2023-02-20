import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneDirectoryTest {
    public static void main(String[] args) {

        System.out.println("This is a program that help you save your contact info\n");

        PhoneDirectory myPhoneDir = new PhoneDirectory();
        outerLoop:
        while (true) {

            System.out.println("\n===================================================================");
            System.out.println("| Now please select and execute the following operations/services |");
            System.out.println("===================================================================");
            System.out.println("| # 1. Load a previously saved phone directory from file          |");
            System.out.println("| # 2. Add or change an entry                                     |");
            System.out.println("| # 3. Remove an entry                                            |");
            System.out.println("| # 4. Search for an entry                                        |");
            System.out.println("| # 5. Display all entries                                        |");
            System.out.println("| # 6. Save the current phone directory to a file                 |");
            System.out.println("| # 7. Quit the program                                           |");
            System.out.println("===================================================================");

            Scanner sc = new Scanner(System.in);
            int selection = sc.nextInt();

            switch (selection) {
                case 1:
                    // load a previously saved phone directory from file
                    System.out.println("The file format has to be: FIRST_NAME LAST_NAME PHONE (each contact per line, each content separate by a single space.");
                    System.out.println("Please enter the name of the file: ");
                    String fileName = sc.next();
                    myPhoneDir = loadExistingFile(fileName, myPhoneDir);
                    break;

                case 2:
                    // add or change an entry
                    System.out.println("Please enter the name you want to add/change: ");
                    System.out.print("First Name: ");
                    String fn = sc.next();
                    System.out.print("Last Name: ");
                    String ln = sc.next();
                    System.out.print("Phone Number: ");
                    String phoneNumber = sc.next();
                    myPhoneDir.addOrChangeEntry(fn + " " + ln, phoneNumber);
                    System.out.println("Entry has been updated successfully.");
                    break;

                case 3:
                    // remove an entry
                    System.out.println("Please enter the name you want to remove: ");
                    String name = sc.next();
                    DirectoryEntry entry = myPhoneDir.searchEntry(name);
                    if (entry != null) {
                        System.out.println(entry);
                        System.out.println("Are you sure you want to remove ?");
                        System.out.println("Say: yes / no");
                        String decision = sc.next();
                        if (decision.equalsIgnoreCase("yes")) {
                            myPhoneDir.removeEntry(entry.getName());
                            System.out.println("Contact has been removed successfully!");
                        }
                        else if (decision.equalsIgnoreCase("no")){
                            System.out.println("Fail to remove...");
                        }
                        else{
                            System.out.println("invalid input, skipped...");
                        }

                    }else {
                        System.out.println("Contact not found...");
                    }

                    break;

                case 4:
                    // search for an entry
                    System.out.println("Please enter the name you want to look for: ");
                    name = sc.next();
                    entry = myPhoneDir.searchEntry(name);
                    if (entry != null) {
                        System.out.println(entry);
                    }else {
                        System.out.println("Contact not found...");
                    }
                    break;

                case 5:
                    // display all entries
                    myPhoneDir.displayAllEntries();
                    break;

                case 6:
                    // save the current phone directory to a file, if it exists, we append
                    System.out.println("Please enter the name of the file: ");
                    fileName = sc.next();
                    saveFile(fileName, myPhoneDir);
                    break;

                case 7:
                    // quit the program
                    break outerLoop;

                default:
                    // invalid input
                    System.out.println("Please enter a valid command: 1~7 ");
                    break;
            }

        }

    }

    public static PhoneDirectory loadExistingFile(String fileName, PhoneDirectory phoneDirectory){
        // load a previously saved phone directory from file
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String info = br.readLine();
            while(info != null){
                // read info
                String[] infos = info.split(" ");
                String fullName = infos[0] + " " + infos[1];
                String number = infos[2];
                phoneDirectory.addOrChangeEntry(fullName, number);

                info = br.readLine();
            }

            br.close();
            fr.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found, fail to load...");
            return null;
        } catch (IOException e) {
            System.out.println("IO exception happened, fail to load...");
            return null;
        }

        System.out.println("File has been loaded successfully!");
        return phoneDirectory;
    }

    public static void saveFile(String fileName, PhoneDirectory phoneDirectory){
        // save the current phone directory to a file
        List<DirectoryEntry> dir = phoneDirectory.getTheDirectory();

        PrintWriter output;

        try {
            output = new PrintWriter(new FileOutputStream(fileName));
            for (int i = 0; i < dir.size(); i++) {
                output.println(dir.get(i).getFirstName() + " " +
                        dir.get(i).getLastName()+ " "+
                        dir.get(i).getNumber());
            }

            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fail to process...");
        }

        System.out.println("File saved successfully !");

    }



}

