abstract class Parodymon{
    private int healthPoints;
    private final int maxEnergyPoints;
    private int energyPoints;
    private final int maxHealthPoints;
    private final String name;
    private Action[] actions = new Action[4]; //todo: they added a constant in the solution

    public Parodymon(int maxHealthPoints, int maxEnergyPoints, String name){
        this.maxEnergyPoints = maxEnergyPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.name = name;
        this.energyPoints = maxEnergyPoints;
        this.healthPoints = maxHealthPoints;
    }

    public void adjustHealthPoints(int value){
        if(value > 0) healthPoints = Math.min(value + healthPoints, maxHealthPoints);
        else if(value + healthPoints < 0) healthPoints = 0;
        else healthPoints = value + healthPoints;
    }

    public void adjustEnergyPoints(int value){
        if(value > 0) energyPoints = Math.min(value + energyPoints, maxEnergyPoints);
        else if(value + energyPoints < 0) energyPoints = 0;
        else energyPoints = value + energyPoints;
    }

    public int getHealthPoints(){return healthPoints;}

    public int getEnergyPoints(){return energyPoints;}

    //todo: The exception is not excely index out of bounds, because they told us that the index
    // is in bounds. It should be something we create using inheritance.
    public void useAction(int index, Parodymon target) throws IndexOutOfBoundsException{
        //todo: they added a constant for the message in their solution.
        if(actions[index] == null) throw new IndexOutOfBoundsException("No action in the given index.");

        Action action = actions[index];
        // there is enough energy in the traget to make the action
        // todo: WRONG! they check if the energy of this Parodymon is bigger than the cost of the current
        //  action. If so, it will make the action on the target (opponent) Parodymon
        if(target.getEnergyPoints() - action.getCost() > 0){
            target.adjustEnergyPoints(-action.getCost()); //todo: No need to place a minus.
            target.adjustHealthPoints(action.getAdjustment());
            action.specialEffect(target);
        }
    }

    public void learnAction(String name, int index){
        actions[index] = ActionFactory.select(name); // todo: EXCELLENT!
    }
}

abstract class Action {
    private int cost;
    private int adjustment;

    public abstract void specialEffect(Parodymon parodymon);

    public Action(int cost, int adjustment){
        this.cost = cost;
        this.adjustment = adjustment;
    }

    public int getCost(){return cost;}

    public int getAdjustment(){return adjustment;}
}

class ActionFactory{
    public static Action select(String input){
        //todo: GOOD JOB, they actually created new subclasses of Action, probably for future improvement.
        switch(input){
            case "fireball":
                return new Action(50, -50){
                    @Override
                    public void specialEffect(Parodymon parodymon){
                        int currentHealthPoints = parodymon.getHealthPoints();
                        parodymon.adjustHealthPoints((int) (-currentHealthPoints * 0.1f));
                    }
                };
            case "heal":
                return new Action(25, 100){
                    @Override
                    public void specialEffect(Parodymon parodymon){
                        int currentHealthPoints = parodymon.getHealthPoints();
                        parodymon.adjustHealthPoints((int) (currentHealthPoints * 0.1f));
                    }
                };
            default:
                return null;
        }
    }
}




