object CubeCalculator extends App {

  def task1(): Unit = {
    val r = for (i <- (1 to 10000000).iterator) yield (i, (if (i % 2 == 0) 2 else 1))

    println("Task 1")
    println()
    r.take(20).foreach(println)
    println()
  }
  task1()

  def task2(): Unit = {

    import trait_task_2._
    println("Task 2")
    val yes = Yes(5)
    println("Yes(5) mapped with function x => x + 2: " + yes.map(_ + 2))
    println("Yes(5) flatmapped with function x => Yes(x + 2): " + yes.flatMap(x => Yes(x + 2)))
    println()
  }
  task2()
}


