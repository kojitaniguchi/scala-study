package kojitaniguchi.marubatsu.game

sealed  abstract class Winner
case object NoWinner extends Winner
case object Maru extends Winner
case object Batsu extends Winner

class Winner {

}
