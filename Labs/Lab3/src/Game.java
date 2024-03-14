interface GameCharacter {
    String getDescription();
    int getAttackForce();
    int getDefenseForce();
}

class Person implements GameCharacter {

    public static final int ATTACK_FORCE = 15;
    public static final int DEFENSE_FORCE = 10;

    @Override
    public String getDescription() {
        return "I am a person";
    }

    @Override
    public int getAttackForce() {
        return ATTACK_FORCE;
    }

    @Override
    public int getDefenseForce() {
        return DEFENSE_FORCE;
    }
}

class Dragon implements GameCharacter {

    public static final int ATTACK_FORCE = 20;
    public static final int DEFENSE_FORCE = 15;

    @Override
    public String getDescription() {
        return "I am a dragon";
    }

    @Override
    public int getAttackForce() {
        return ATTACK_FORCE;
    }

    @Override
    public int getDefenseForce() {
        return DEFENSE_FORCE;
    }
}

interface CharacterDecorator extends GameCharacter {}

/*add CharacterSword, CharacterHelmet and CharacterInvisibleShield decorators HERE!!!*/

/**  a character with a sword adds the sword to the description,
 and the attack force of the character is multiplied by 2. */
class CharacterSword implements CharacterDecorator{
    private GameCharacter character;

    /** ctor */
    public CharacterSword(GameCharacter character){
        this.character = character;
    }

    @Override
    public String getDescription() {
        return character.getDescription() + " with a sword";
    }

    @Override
    public int getAttackForce() {
        return 2 * character.getAttackForce();
    }

    @Override
    public int getDefenseForce() {
        return character.getDefenseForce();
    }
}

/** a character with a helmet adds the helmet to the description,
 and the defense force of the character is increased by 10. */
class CharacterHelmet implements CharacterDecorator{
    private GameCharacter character;

    /** ctor */
    public CharacterHelmet(GameCharacter character){
        this.character = character;
    }

    @Override
    public String getDescription() {
        return character.getDescription() + " with a helmet";
    }

    @Override
    public int getAttackForce() {
        return character.getAttackForce();
    }

    @Override
    public int getDefenseForce() {
        return character.getDefenseForce() + 10;
    }
}

/** a character with an invisible shield does not change its description but
 the defense force of the character is increased by 10. */
class CharacterInvisibleShield implements CharacterDecorator{
    private GameCharacter character;

    /** ctor */
    public CharacterInvisibleShield(GameCharacter character){
        this.character = character;
    }

    @Override
    public String getDescription() {
        return character.getDescription();
    }

    @Override
    public int getAttackForce() {
        return character.getAttackForce();
    }

    @Override
    public int getDefenseForce() {
        return character.getDefenseForce() + 10;
    }
}


public class Game {
    public static boolean attack(GameCharacter attacker, GameCharacter defender){
        return attacker.getAttackForce()-defender.getDefenseForce()>0;
    }

    public static void main(String[] args) {
        //Initialize hero with two swords and a helmet!
        GameCharacter hero=new Person();
        hero = new CharacterHelmet(new CharacterSword(new CharacterSword(hero)));
        //Initialize evilDragon with an invisible shield!
        GameCharacter evilDragon=new Dragon();
        evilDragon = new CharacterInvisibleShield(evilDragon);

        System.out.println(hero.getDescription());
        System.out.println(evilDragon.getDescription());

        if(attack(hero,evilDragon)){
            System.out.println("The hero defeated the evil dragon");
        }
    }
}


