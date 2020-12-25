package trait_task_3

trait Maybe[+A] {
  def applyFunction[R](f: A => R) = this match {
    case No() => No()
    case Yes(s) => Yes(f(s))
  }
}
case class No() extends Maybe[Nothing]
case class Yes[A](val a: A) extends Maybe[A]
