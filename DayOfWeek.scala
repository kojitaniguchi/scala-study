sealed abstract class DayOfWeek
case object Sunday extends DayOfWeek
case object Monday extends DayOfWeek
case object Tuesday extends DayOfWeek
case object Wednesday extends DayOfWeek
case object Thursday extends DayOfWeek
case object Friday extends DayOfWeek
case object Saturday extends DayOfWeek
//
//object  DayOfWeek {
//
//  def toNum(day: DayOfWeek): Int = {
//    case Sunday => 1
//    case Monday => 2
//    case Tuesday => 3
//    case Wednesday => 4
//    case Thursday => 5
//    case Friday => 6
//  }
//}