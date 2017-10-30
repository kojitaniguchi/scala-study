// クラスを継承したオブジェクト
// newを使ったクラスのインスタンス化
// val taro = new Dog("タロウ")
// taro.greet

class Dog(private val name: String) {

  def greet(): Unit = println(s"${name}だワン")

}

// コンパニオンオブジェクト(クラスと同名のオブジェクト)

// ファクトリメソッド
// メソッドによるクラスのインスタンス化
// val jiro = Dog("ジロウ")
// jiro.greet

object Dog {

  //　オブジェクト名(applyメソッドの引数)で呼び出し可能
  def apply(name: String) = new Dog(name)

  def apply(id: Int) = new Dog(s"番号付き犬${id}番")

  def printName(dog: Dog): Unit = println(dog.name)

}