import java.util.*;

class Unit {
    int maxHp, currentHp, 
    maxMorale, currentMorale, 
    armour, meleeAttack, rangedAttack, maxRange, accuracy, supply;

    // 생성자 (필드명과 매개변수 명칭 통일)
    Unit(int maxHp, int maxMorale, int armour, int meleeAttack, int rangedAttack, int maxRange, int accuracy, int supply) {
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.maxMorale = maxMorale;
        this.currentMorale = maxMorale;
        this.armour = armour;
        this.meleeAttack = meleeAttack;
        this.rangedAttack = rangedAttack;
        this.maxRange = maxRange;
        this.accuracy = accuracy;
        this.supply = supply;
    }

    void modifyHp(int value) {
        this.currentHp += value;
        this.currentHp = Math.max(0, Math.min(this.currentHp, this.maxHp));
    }
    void modifyMorale(int value) {
        this.currentMorale += value;
        this.currentMorale = Math.max(0, Math.min(this.currentMorale, this.maxMorale));
    }
}

class UnitRegistry {
    // maxHp, maxMorale, armour, meleeAttack, rangedAttack, maxRange, accuracy, supply
    public static final Unit CUIRASSIER = new Unit(100, 100, 100);
}

class MoveManager {
  
}

class BattleManager {
    int hitChance(Unit attacker, Unit defender, int distance) {
        int value = 0;
        double hitRate = Math.pow(Math.E, (-1)*distance/attacker.accuracy);
        for (int i = 0; i < attacker.currentHp; i++) {
            if (Math.random() < hitRate) {
                value++;
            }
        }
        
        return value;
    }
    int actualDamage(Unit attacker, Unit defender, int distance) {
        return Math.pow(Math.E, (-1)*(0.008)*(distance));
    }
    void combat(Unit attacker, Unit defender, int distance) {
        int damage = distance == 0 ? attacker.meleeAttack : attacker.rangedAttack;
        damage *= Math.pow(Math.E, (-1)*(0.008)*(distance));
       
        defender.modifyHp(damage);
        defender.modifyMorale(damage);
    }
}

class Map {
  
}

public class Main {
  public static void main(String[] args) {

    
  }

}
