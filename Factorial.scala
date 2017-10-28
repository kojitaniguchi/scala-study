import scala.math.BigInt

// object Factorial extends App {
//   def factorial(i: BigInt): BigInt = if (i == 0) 1 else i * factorial(i - 1)
//   println(factorial(10000))
// }

// 末尾再帰最適化
object Factorial extends App {
  def factorial(i: BigInt, acc: BigInt): BigInt = if (i == 0) acc else factorial(i - 1, i * acc)
  println(factorial(10000, 1))
}
