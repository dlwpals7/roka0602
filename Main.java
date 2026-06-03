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
        // 맞은 횟수 = 맞을 확률 * 공격 횟수 
    int hitChance(Unit attacker, Unit defender, int distance) {
            // 맞은 횟수 value
        int value = 0;    
            // 맞을 확률 hitRate = e^(-d/a) : 자연상수 e, 공격자-방어자 간 거리 d, 공격자 명중률 a
        double hitRate = Math.pow(Math.E, (-1)*distance/attacker.accuracy); 
            // 공격 횟수 = 공격자의 현재원 / 공격 성공 = 난수 < 맞을 확률
        for (int i = 0; i < attacker.currentHp; i++) {    
            if (Math.random() < hitRate) {
                value++;
            }
        }
        
        return value;
    }
    // 유효타 = 방어 확률 * 맞은 횟수
    int actualDamage(Unit attacker, Unit defender, int distance) {
            // 맞은 횟수 hitTimes
        int hitTimes = hitChance(attacker, defender, distance);
            // 실제 피해량 decadedDamage = 기본 피해량 * e^(-n*d) : 자연상수 e, 감쇠변수 n, 공격자-방어자 간 거리 d
        double decadedDamage = Math.pow(Math.E, (-1)*(0.008)*(distance));
            // 방어 확률 = 
        
        return ;
    }


    int damageCalculator(Unit attacker, Unit defender, int distance) {
            // 피해량 damage = 유효타를 날린 횟수
        int damage = 0,
        attack = distance == 0 ? attacker.meleeAttack : attacker.rangedAttack;
            // 실제 피해량 = 기본 피해량 * e^(-n*d) : 자연상수 e, 감쇠변수 n, 공격자-방어자 간 거리 d
        boolean isPenetrated = attack * Math.pow(Math.E, (-1)*(0.008)*(distance)) > defender.armour;
        // 유효타 = 공격 성공 * 방어 실패
            // 명중률 hitRate = e^(-d/a) : 자연상수 e, 공격자-방어자 간 거리 d, 공격자 정확도 a
        double hitRate = Math.pow(Math.E, (-1)*distance/attacker.accuracy); 
            // 공격 횟수 = 공격자의 현재원 / 공격 성공 = 난수 < 맞을 확률
        for (int i = 0; i < attacker.currentHp; i++) {    
            if (Math.random() < hitRate) {
                damage++;
            }
        }
        damage = isPenetrated ? (int)((1 - 0.002 * defender.armour) * damage) : (int)(0.002 * (100 - defender.armour) * damage);
        
        return damage;
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
