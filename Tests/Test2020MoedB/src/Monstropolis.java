import java.util.HashMap;

class Contact{
    private final String address;
    private final int phoneNumber;
    private final String name;

    public Contact(String name, int phoneNumber, String address){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }
}

class SmartPhone{
    public SmartPhone(){

    }

    public String searchBrouwser(String query){
        return "found 1000 results for " + query;
    }

    public void sendMessage(String contactName, String msg){
        System.out.println("send: " + msg + " to: " + contactName );
    }

    public void dial(int phoneNumber){

    }

    public void pickupCall(){
        System.out.println("picked up call");
    }

    public void navigate(String destination){
        System.out.println("Navigate to: "+ destination);
    }

    public void playMusic(){
        System.out.println("Music is playyingggg");
    }

    public void stopMusic(){
        System.out.println("Music stopped");
    }

    public void addContact(Contact contact){
        System.out.println("Added contact: "+ contact);
    }

    public void addContact(String name, int phoneNumber){

    }

    public Contact getContact(String contactName){
        return null;
    }

    public void callContact(String contactName){
        System.out.println("call contact: "+ contactName);
    }

}

class SimplePhone{
    private final Contact primaryContact;
    private final SmartPhone smartPhone;

    public SimplePhone(Contact primaryContact){
        this.primaryContact = primaryContact;
        this.smartPhone = new SmartPhone();
        this.smartPhone.addContact(primaryContact);
    }

    public void callPrimaryContact(){
        smartPhone.callContact(primaryContact.getName());
    }

    public void callEmergency(){
        smartPhone.addContact(new Contact("911", 911, "National"));
        smartPhone.callContact("911");
    }

    public void pickupCall(){
        smartPhone.pickupCall();
    }
}

@FunctionalInterface
interface SmartPhoneProcedure{
    void execute(SmartPhone p, String[] args);
}

class SimplePPP{
    private final Contact primaryContact;
    private SmartPhone smartPhone;
    private HashMap<String, SmartPhoneProcedure> procedures;

    public SimplePPP(Contact primaryContact){
        this.primaryContact = primaryContact;
        this.smartPhone = new SmartPhone();
        this.smartPhone.addContact(primaryContact);
        this.procedures = new HashMap<>();
    }

    public void addProcedure(String procedureName, SmartPhoneProcedure f){
        procedures.put(procedureName, f);
    }

    public void executeProcedure(String procedureName, String[] args){
        procedures.get(procedureName).execute(smartPhone, args);
    }
}

public class Monstropolis {
    public static void main(String[] args) {
        SmartPhoneProcedure DriveToFriend = new SmartPhoneProcedure() {
            @Override
            public void execute(SmartPhone p, String[] args) {
                p.sendMessage(args[0], "On my way");
                p.playMusic();
                p.navigate(p.getContact(args[0]).getAddress());
            }
        };

        Contact contact = new Contact("Mike Wazowski", 12899, "Monstropolis, A-133");
        SimplePPP simplePPP = new SimplePPP(contact);
        simplePPP.addProcedure("drive to friend", DriveToFriend);
        simplePPP.executeProcedure("drive to friend", new String[]{"Mike Wazowski"});
    }
}
