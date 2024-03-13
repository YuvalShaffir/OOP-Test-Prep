public class SubClass extends absClass{

    public SubClass(int field) {
        super(field);
    }

    @Override
    void method() {
        System.out.println("this is the SubClass overriden method");
        this.normalMethod(); // I can call the normal method of the abstract class through the object
        this.publicMethod(); // I can call the public method of the abstract class through the object
//        this.privateMethod(); // I CANNOT call the private method the of absClass from the object of the
        // subClass.
    }
}
