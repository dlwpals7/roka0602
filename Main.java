import java.util.*;

abstract class Unit {
  int maxHp, currentHp, maxMoral, currentMoral, armour, meleeAttack, rangedAttack, supply;
  Unit(int maxHp, int maxMoral, int armour, int meleeAttack, int rangedAttack, int supply) {
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.maxMoral = maxMoral;
    this.currentMoral = maxMoral;
    this.armour = armour;
    this.meleeAttack = meleeAttack;
    this.rangedAttack = rangedAttack;
    this.supply = supply;
  }

  void unitDmaged(int damage);
}

class MoveManager {
  
}

class BattleManager {
  
}

class Map {
  
}

public class Main {
  public static void main(String[] args) {

    
  }

}
