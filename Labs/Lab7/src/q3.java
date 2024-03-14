class Person {
    public String greet(String name) throws IllegalNameException, NullPointerException{
        /* implement this method */
        if(name == null) throw new NullPointerException("Reference was null, please enter a valid name");
        if(name.equals("")) throw new IllegalNameException("The name was empty, please enter a valid name");
        return "Hello, " + name + "!";
    }

    public void sayHello(String name){
        /* implement this method */
        try{
            System.out.println(greet(name));
        }catch(NullPointerException NullError){
            System.out.println(NullError.getMessage());
        }catch(IllegalNameException illigalError){
            System.out.println(illigalError.getMessage());
        }

    }
}

/* implement this class so it becomes a real exception */
class IllegalNameException extends Exception {
    public IllegalNameException(String msg){
        super(msg);
    }
}