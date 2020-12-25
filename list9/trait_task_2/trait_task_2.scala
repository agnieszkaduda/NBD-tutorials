package trait_task_2

trait Maybe[A]
class No extends Maybe[Nothing]
class Yes[A](val a: A) extends Maybe[A]
