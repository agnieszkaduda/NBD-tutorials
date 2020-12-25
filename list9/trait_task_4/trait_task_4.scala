package trait_task_4

trait Maybe[+A] {
  def applyFunction[R](f: A => R) = this match {
    case No() => No()
    case Yes(a) => Yes(f(a))
  }

  def getOrElse[R](parameter: => R) = this match {
    case No() => parameter
    case Yes(s) => s
  }
}
case class No() extends Maybe[Nothing]
case class Yes[A](val a: A) extends Maybe[A]

