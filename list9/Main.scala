
object Main extends App {
  def task1(): Unit = {
    class Container[A](private val a: A) {
      def getContent: A = a
      def applyFunction[R](f: A => R): R = f(a)
    }

    val c = new Container[Int](1)
    println("Task 1")
    println("The content of my container: " + c.getContent)
    println("Applying function x => x*5: " + c.applyFunction(x => x*5))
    println()
  }
  task1()


  def task2(): Unit ={
    import trait_task_2._
    val yes = new Yes(1)
    val no = new No
    println("Task 2")
    println(no.isInstanceOf[Maybe[Nothing]])
    println(yes.isInstanceOf[Maybe[Int]])
    println()
  }
  task2()


  def task3(): Unit ={
    import trait_task_3._
    println("Task 3")
    val yes = Yes("Christmas")
    println("The content of Yes: " + yes.a)
    println("Applying function adding 'Merry' string: " + yes.applyFunction(x => "Merry " + x))
    println()
  }
  task3()


  def task4(): Unit = {
    import trait_task_4._

    val no = No()
    val yes = Yes(1)
    println("Task 4")
    println("getOrElse used with Yes(1): " + yes.getOrElse("Parameter"))
    println("getOrElse used with No: " + no.getOrElse("Parameter_string"))
    println()
  }
  task4()

}
