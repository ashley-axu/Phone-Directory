public class DirectoryEntry {
    private String name;
    private String number;

    public DirectoryEntry(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstName(){
        String[] fullname = this.name.split(" ");
        return fullname[0];
    }

    public String getLastName(){
        String[] fullname = this.name.split(" ");
        return fullname[1];
    }

    @Override
    public String toString() {
        return "Contact Name: "+ this.name + "\n"
                +"Contact Phone: "+this.number;
    }
}
