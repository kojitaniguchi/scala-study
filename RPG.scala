import java.util.Random

object RPG extends App {
  val random = new Random
}

// 抽象クラス
abstract class Creature(var hitPoint: Int, var attackDamage: Int) {
  def isAlive(): Boolean = this.hitPoint > 0
}

class Hero(_hitPoint: Int, _attackDamage: Int) extends Creature(_hitPoint, _attackDamage) {

  def attack(monster: Monster): Unit = {
    monster.hitPoint = monster.hitPoint - this.attackDamage
    this.hitPoint = this.hitPoint - monster.attackDamage
  }

  def escape(monster: Monster): Boolean = {
    val isEscaped = RPG.random.nextInt(2) == 1
    if (!isEscaped) {
      this.hitPoint = this.hitPoint - monster.attackDamage
    } else {
      monster.isAwayFromHero = true
    }
    isEscaped
  }

  // override 継承元のメソッドの挙動を上書きする
  override def toString = s"Hero(体力:${hitPoint}, 攻撃力:${attackDamage})"

}

class Monster(_hitpoint: Int, _attackDamege: Int, var isAwayFromHero: Boolean)

  extends Creature(_hitpoint, _attackDamege) {

  override def toString = s"Monster(体力:${hitPoint}, 攻撃力:${attackDamage}, ヒーローから離れている:${isAwayFromHero})"

}


