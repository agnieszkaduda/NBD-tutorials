package trait_task_2
trait Maybe[+A] {
  def applyFunction[R](f: A => R) = this match {
    case No() => No()
    case Yes(a) => Yes(f(a))
  }

  def getOrElse[R](parameter: => R) = this match {
    case No() => parameter
    case Yes(s) => s
  }

  def map[R](f: A => R) = this match {
    case No() => No()
    case Yes(a) => Yes(f(a))
  }

  def flatMap[R](f: A => Maybe[R]) = this.map(f).getOrElse(No())
}

case class No() extends Maybe[Nothing]
case class Yes[A](val a: A) extends Maybe[A]
