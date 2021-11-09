import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneDirectory {


    private List<DirectoryEntry> theDirectory;

    // constructor
    public PhoneDirectory() {
        this.theDirectory = new ArrayList<>();
    }

    // get method
    public List<DirectoryEntry> getTheDirectory() {
        return theDirectory;
    }

    public String addOrChangeEntry(String name, String number) {
        // add an entry to directory or change an existing entry; return the old number or null if it is new entry

        for (int i=0; i<theDirectory.size(); i++){
            if (theDirectory.get(i).getName().equalsIgnoreCase(name)){
                String old_number = theDirectory.get(i).getNumber();
                theDirectory.get(i).setNumber(number);
                return old_number;
            }
        }

        theDirectory.add(new DirectoryEntry(name,number));

        return null;
    }

    public DirectoryEntry searchEntry(String name) {
        // search the entry referenced by name; return the entry searched or null if there is no entry
        // for name

        Scanner sc = new Scanner(System.in);

        for (int i=0; i<theDirectory.size(); i++){
            if (theDirectory.get(i).getName().equalsIgnoreCase(name)){
                return theDirectory.get(i);
            }

            if (theDirectory.get(i).getFirstName().equalsIgnoreCase(name) ||
                    theDirectory.get(i).getLastName().equalsIgnoreCase(name)){
                System.out.println("Did you mean: "+theDirectory.get(i).getName()+ " ?");
                System.out.println("Say: yes / no");
                String decision = sc.next();
                if (decision.equalsIgnoreCase("yes")) {
                    return theDirectory.get(i);
                }
                else if (decision.equalsIgnoreCase("no")){
                    System.out.println("Skipped...");
                }
                else{
                    System.out.println("invalid input, skipped...");
                }
            }
        }

        return null;
    }

    public DirectoryEntry removeEntry(String name) {
        // remove the entry referenced by name; return the entry removed or null if there is no entry
        // for name

        for (int i=0; i<theDirectory.size(); i++){
            if (theDirectory.get(i).getName().equalsIgnoreCase(name)){
                return theDirectory.remove(i);
            }
        }
        return null;
    }

    public void displayAllEntries() {
        // display all entries in a nice and readable format

        if (this.theDirectory.size() == 0){
            System.out.println("The current directory is empty...");
        }


        for (int i=0; i<theDirectory.size(); i++){
            System.out.println("# "+(i+1));
            System.out.println("Contact name: "+theDirectory.get(i).getName());
            System.out.println("Contact number: "+theDirectory.get(i).getNumber());
            System.out.println();
        }
    }

}
