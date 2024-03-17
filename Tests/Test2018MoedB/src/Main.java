
//  ----------------- MY SOLUTION -------------------------
// import java.util.Random;
//
//abstract class Weapon{
//    private final String type;
//    private final int damage;
//    private final int quality;
//
//    public Weapon(String type, int damage, int quality){
//        this.type = type;
//        this.damage = damage;
//        this.quality = quality;
//    }
//
//    public String getType(){return type;}
//
//    // will make the weapon fire and return the damage
//    public int fire() {return damage;}
//
//    // will return the quality of the weapon
//    public int quality() {return quality;}
//
//    // will print the name of the class that made the object and its quality.
//    public void printQuality(){
//        System.out.println(type + "(" + quality + ")");
//    }
//}
//
//interface SpaceshipInterface{
//    void inflictDamage(int damage);
//    Spaceship isStrongerThan(Spaceship other);
//    void attack(SpaceshipDecorator other);
//}
//
//abstract class Spaceship implements SpaceshipInterface{
//    public static final int INIT_DAMAGE_POINTS = 100;
//    protected final Weapon weapon;
//    protected int damagePoints;
//    private boolean shipAlive;
//
//    public Spaceship(Weapon weapon){
//        this.weapon = weapon;
//        this.damagePoints = INIT_DAMAGE_POINTS;
//        this.shipAlive = true;
//    }
//
//    public Spaceship isStrongerThan(Spaceship other){
//        if(weapon.getType().equals(other.getShipWeaponType())){
//            if(weapon.quality() > other.getShipWeaponQuality()){
//                return this;
//            }else{
//                return other;
//            }
//        }
//        return null;
//    }
//
//    public void attack(SpaceshipDecorator other){
//        int damage = weapon.fire();
//        other.inflictDamage(damage);
//    }
//
//    public String getShipWeaponType(){
//        return weapon.getType();
//    }
//
//    public int getShipWeaponQuality(){
//        return weapon.quality();
//    }
//
//    public void removeDamage(int damage){
//        damagePoints -= damage;
//        if(damagePoints < 0) shipAlive = false;
//    }
//
//    public boolean isShipAlive(){
//        return shipAlive;
//    }
//}
//
//interface SpaceshipDecorator extends SpaceshipInterface{}
//
//class NormalSpaceship implements SpaceshipDecorator{
//
//    public static final int BOUND = 25;
//    private final Spaceship ship;
//
//    public NormalSpaceship(Spaceship ship){
//        this.ship = ship;
//    }
//
//    @Override
//    public Spaceship isStrongerThan(Spaceship other) {
//        return ship.isStrongerThan(other);
//    }
//
//    @Override
//    public void inflictDamage(int damage) {
//        ship.removeDamage(damage);
//    }
//
//    @Override
//    public void attack(SpaceshipDecorator other) {
//        ship.attack(other);
//    }
//}
//
//class ProtectedSpaceship implements SpaceshipDecorator{
//
//    public static final int BOUND = 25;
//    private final Spaceship ship;
//
//    public ProtectedSpaceship(Spaceship ship){
//        this.ship = ship;
//    }
//
//    @Override
//    public Spaceship isStrongerThan(Spaceship other) {
//        return ship.isStrongerThan(other);
//    }
//
//    @Override
//    public void inflictDamage(int damage) {
//        ship.removeDamage(damage - new Random().nextInt(BOUND));
//    }
//
//    @Override
//    public void attack(SpaceshipDecorator other) {
//        ship.attack(other);
//    }
//
//}
//
//class ComoflagedShip implements SpaceshipDecorator{
//
//    public static final int FOUR_BOUND = 4;
//    private final Spaceship ship;
//
//    public ComoflagedShip(Spaceship ship){
//        this.ship = ship;
//    }
//
//    @Override
//    public Spaceship isStrongerThan(Spaceship other) {
//        return ship.isStrongerThan(other);
//    }
//
//    @Override
//    public void inflictDamage(int damage) {
//        switch (new Random().nextInt(FOUR_BOUND)){
//            case 1:
//                ship.removeDamage(0); //25% change no damage
//                break;
//            default:
//                ship.removeDamage(damage); // 75% change the normal damage
//                break;
//        }
//    }
//
//    @Override
//    public void attack(SpaceshipDecorator other) {
//        ship.attack(other);
//    }
//}
//
//class Torpedo extends Weapon{
//
//    public static final int QUALITY = 10;
//    public static final int DAMAGE = 12;
//    public static final String TYPE = "torpedo";
//
//    public Torpedo() {
//        super(TYPE, DAMAGE, QUALITY);
//    }
//
//}
//
//class ShipFactory{
//    public static SpaceshipInterface select(String type, Spaceship ship){
//        switch (type){
//            case "R": return new NormalSpaceship(ship);
//            case "S": return new ProtectedSpaceship(ship);
//            case "C": return new ComoflagedShip(ship);
//            case "CS": return new ComoflagedShip(new ProtectedSpaceship(ship));
//        }
//    }
//}
//
//class Shipyard{
//    public void add(String type, Torpedo t){
//
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/** Their solution */

interface Weapon{
    int fire();

    int quality();

    default void printQuality(){
        System.out.println(getClass() + "(" + quality() + ")");
    }
}

class Ship<W extends Weapon> implements Comparable<Ship<W>>{
    public static final int INIT_DAMAGE_POINTS = 100;
    protected final W _weapon;
    protected int _damagePoints;

    public Ship(W weapon){
        this._weapon = weapon;
        this._damagePoints = INIT_DAMAGE_POINTS;
    }

    public Ship(Ship<W> other){
        this(other._weapon);
    }

    public void attack(Ship<W> other){
        other.takeHit(_weapon.fire());
    }

    @Override
    public int compareTo(Ship<W> other) {
        if(this._weapon.quality() > other._weapon.quality()) return 1;
        if(this._weapon.quality() < other._weapon.quality()) return -1;
        return 0;
    }

    protected void takeHit(int damage){
        _damagePoints -= damage;
    }
}

class ShieldedShip<W extends Weapon> extends Ship<W>{

    public ShieldedShip(Ship<W> ship) {
        super(ship);
    }

    @Override
    protected void takeHit(int damage){
        Random rand = new Random();
        _damagePoints -= Math.max(0, damage - rand.nextInt(25));
    }
}

class CamoflagedShip<W extends Weapon> extends Ship<W>{

    public CamoflagedShip(Ship<W> other) {
        super(other);
    }

    @Override
    protected void takeHit(int damage){
        Random rand = new Random();
        if (rand.nextInt(4) != 1) {
            _damagePoints -= damage;
        }
    }
}



class Torpedo implements Weapon{

    @Override
    public int fire() {
        return 3;
    }

    @Override
    public int quality() {
        return 4;
    }
}

class Shipyard{
    private ArrayList<Ship<Torpedo>> ships;

    public Shipyard(){
        this.ships = new ArrayList<>();
    }

    public void addShip(String type, Torpedo w){
        ships.add(select(type, w));
    }

    public ArrayList<Ship<Torpedo>> sort(String order){
        if(order.equals("lth")){
            Collections.sort(ships, (s1, s2) -> s2.compareTo(s1));
        }
        else if(order.equals("htl")){
            Collections.sort(ships);
        }
        return ships;
    }

    public Ship<Torpedo> select(String type, Torpedo weapon){
        switch (type){
            case "R": return new Ship<>(weapon);
            case "C": return new CamoflagedShip<>(new Ship<>(weapon));
            case "S": return new ShieldedShip<>(new Ship<>(weapon));
            case "CS": return new CamoflagedShip<>(new ShieldedShip<>(new Ship<>(weapon)));
            default: return null;
        }
    }

}
