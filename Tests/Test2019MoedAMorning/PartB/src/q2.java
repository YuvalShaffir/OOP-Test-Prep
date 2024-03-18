//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//interface CommServer{
//    boolean addConnection(CommDevice d1, CommDevice d2);
//    void removeConnection(CommDevice d1, CommDevice d2);
//    boolean sendMessage(CommDevice d, String msg);
//}
//
//interface CommunicationDeviceInterface{
//    boolean connect(CommDevice d);
//    void removeConnection();
//    boolean acceptConnection(CommDevice d);
//    void receiveMessage(String msg);
//    boolean sendMessage(String msg);
//    void printMessage();
//
//    default Boolean sendKey(CommunicationDeviceInterface other){
//        if(other instanceof EncoderDevice) {
//            return other.receiveKey(());
//        }
//    }
//
//    default Boolean receiveKey(String key){
//        return getRecieveKey().equals(key);
//    }
//}
//
//class CommDevice implements CommunicationDeviceInterface{
//
//    private final CommServer server;
//    private CommDevice connectedDevice;
//    private String currMsg;
//
//    public CommDevice(CommServer server){
//        this.server = server;
//        this.connectedDevice = null;
//        this.currMsg = "";
//    }
//
//    @Override
//    public boolean connect(CommDevice d) {
//        if(server.addConnection(this, d)){
//            connectedDevice = d;
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void removeConnection() {
//        if(connectedDevice != null) server.removeConnection(this, connectedDevice);
//    }
//
//    @Override
//    public boolean acceptConnection(CommDevice d) {
//        if(connectedDevice == null) {
//            connectedDevice = d;
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void receiveMessage(String msg) {
//        currMsg = msg;
//    }
//
//    @Override
//    public boolean sendMessage(String msg) {
//        if(connectedDevice != null) return server.sendMessage(connectedDevice, msg);
//        return false;
//    }
//
//    @Override
//    public void printMessage() {
//        System.out.println(currMsg);
//    }
//}
//
//
//
//class EncoderDevice implements CommunicationDeviceInterface{
//
//
//    private final HashMap<Character, Character> decoder;
//    private final HashMap<Character, Character> encoder;
//    private final CommDevice device;
//
//    public EncoderDevice(CommDevice d, HashMap<Character, Character> encoder,
//                         HashMap<Character, Character> decoder) {
//        this.device = d;
//        this.encoder = encoder;
//        this.decoder = decoder;
//    }
//
//
//    @Override
//    public boolean connect(CommDevice d) {
//        return device.connect(d);
//    }
//
//    @Override
//    public void removeConnection() {
//        device.removeConnection();
//    }
//
//    @Override
//    public boolean acceptConnection(CommDevice d) {
//        return device.acceptConnection(d);
//    }
//
//    @Override
//    public void receiveMessage(String msg) {
//        String translatedMsg = "";
//        for(char c: msg.toCharArray()){
//            translatedMsg = translatedMsg + decoder.get(c);
//        }
//        device.receiveMessage(translatedMsg);
//    }
//
//    @Override
//    public boolean sendMessage(String msg) {
//        String translatedMsg = "";
//        for(char c: msg.toCharArray()){
//            translatedMsg = translatedMsg + encoder.get(c);
//        }
//        return device.sendMessage(translatedMsg);
//    }
//
//    @Override
//    public void printMessage() {
//        device.printMessage();
//    }
//}
//
//class AuthenticatorDevice implements CommunicationDeviceInterface{
//
//
//    private final CommDevice device;
//    private final String sendKey;
//    private final String receiveKey;
//
//    public AuthenticatorDevice(CommDevice d, String sendKey, String receiveKey) {
//        this.device = d;
//        this.sendKey = sendKey;
//        this.receiveKey = receiveKey;
//    }
//
//    @Override
//    public boolean connect(CommDevice d) {
//        return false;
//    }
//
//    @Override
//    public void removeConnection() {
//
//    }
//
//    @Override
//    public boolean acceptConnection(CommDevice d) {
//        return false;
//    }
//
//    @Override
//    public void receiveMessage(String msg) {
//
//    }
//
//    @Override
//    public boolean sendMessage(String msg) {
//        return false;
//    }
//
//    @Override
//    public void printMessage() {
//
//    }
//}