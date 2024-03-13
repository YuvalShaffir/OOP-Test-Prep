public abstract class absClass {
    private final int field;

    // abstract class can have a constructor and fields
    public absClass(int field){
        this.field = field;
    }

    //abstract method - we NEED to declare it as 'abstract'
    //to be implemented by absClass subclasses
    abstract void method();

    //abstract class can have normal methods
    void normalMethod(){
        System.out.println("Using the normal method inside the absClass");
        this.privateMethod();
    }

    //abstract class can have private and public methods (with bodies only)
    public void publicMethod(){
        System.out.println("using the public method of the absClass");
    }

    private void privateMethod(){
        System.out.println("Using the private method inside the absClass");
    }

    // CANNOT HAVE A PRIVATE ABSTRACT CLASS!!!!!!
//    private abstract void privateAbstractMethod(){
//        COMPILATION ERROR!!!!
//    }


}
