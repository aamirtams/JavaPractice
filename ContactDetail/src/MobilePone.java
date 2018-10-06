import java.util.ArrayList;

public class MobilePone {
    String myNumber;
    ArrayList<Contacts> myContacts;

    public MobilePone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public boolean addNewContact (Contacts contacts){
        if (findContacts(contacts.getName()) >= 0){
            System.out.print("Contact already exist");
            return false;
        }
        myContacts.add(contacts);
        return true;
    }

    public boolean updateNewContact(Contacts oldContact, Contacts newContacts){
        int position = findContacts(oldContact);
        if (position < 0){
            System.out.print(oldContact.getName() + " was not found");
            return false;
        }
        myContacts.set(position, newContacts);
        System.out.print(oldContact.getName() + " is replaced with " + newContacts.getName());
        return true;
    }

    public boolean removeContact(Contacts contacts){
        int position = findContacts(contacts);
        if (position < 0){
            System.out.print(contacts.getName() + " was not found");
            return false;
        }

        myContacts.remove(position);
        System.out.println(contacts.getName() + " is removed");
        return true;
    }

    private int findContacts(Contacts contacts){
        return this.myContacts.indexOf(contacts);
    }

    private int findContacts(String contactName){
        for (int i = 0; i < this.myContacts.size(); i++){
            Contacts contacts = this.myContacts.get(i);
            if (contacts.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contacts){
        if (findContacts(contacts) >= 0){
            return contacts.getName();
        }
        return null;
    }

    public Contacts queryContact(String name){
        int position = findContacts(name);
        if (position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Contact List----");
        for (int i = 0; i < this.myContacts.size(); i++){
            System.out.println((i+1) + " - " +
                        this.myContacts.get(i).getName() + " --> " +
                        this.myContacts.get(i).getPhoneNumber());
        }
    }
}
