object list1 extends App {

  val week = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

  def task1a(l: List[String]): String = {
    var acc = ""
    for (i <- l)
      acc = acc + i + "."

    println(acc.init)
    acc.init
  }
  println("task1a:")
  task1a(week)
  println()


  def task1b(l: List[String]): String = {
    var acc = ""
    for (i <- l if (i.startsWith("S")))
      acc = acc + i + "."

    println(acc.init)
    acc.init
  }
  println("task1b:")
  task1b(week)
  println()


  def task1c(l: List[String]): String = {
    var lv = l
    var acc = ""
    while (!lv.isEmpty) {
      acc = acc + lv.head + "."
      lv = lv.tail
    }
    println(acc.init)
    acc.init
  }
  println("task1c")
  task1c(week)
  println()


  def task2a(l: List[String]): String = {
    def go(l2: List[String]): String = {
      if (l2.size == 1) l2.head
      else l2.head + "." + go(l2.tail)
    }

    val result = go(l)
    println(result)
    result
  }
  println("task2a:")
  task2a(week)
  println()


  def task2b(l: List[String]): String = {
    def go(l2: List[String]): String = {
      if (l2.size == 1) l2.last
      else l2.last + "." + go(l2.init)
    }

    val result = go(l)
    println(result)
    result
  }
  println("task2b:")
  task2b(week)
  println()


  def task3(l: List[String]): String = {
    def go(acc: String, l1: List[String]): String  = {
      if (l1.size == 1) {println(acc + l1.head); acc + l1.head}
      else go(acc + l1.head + ".", l1.tail)
    }
    go("", l)
  }
  println("task3:")
  task3(week)
  println()
  
  
  def task4a(l: List[String]): String = {

    val result = l.foldLeft("")((a, b) => {if (a.isEmpty) b else a + "." + b})
    println(result)
    result
  }
  
  println("task4a")
  task4a(week)
  println()


  def task4b(l: List[String]): String = {
    val result = l.foldRight("")((a, b) => {if (b.isEmpty) a else a + "." + b})
    println(result)
    result
  }

  println("task4b")
  task4b(week)
  println()


  def task5() = {
    val m = Map("bread" -> 2, "milk" -> 5, "apple" -> 1, "butter" -> 10)
    val result = m.view.mapValues(x => x*0.9).toMap
    println(result)
    result
  }
  println("task5")
  task5()
  println()


  def task6(l: List[Int]): List[Int] = {
    val result = l.map(x => x + 1)
    println(result)
    result
  }
  
  println("task6")
  task6(List(1,2,3))
  println()


  def task7(l: List[Int]): List[Int] = {
    val result = l.filter(x => x >= -5 && x <= 12 ).map(x => x.abs)
    println(result)
    result
    
  }
  println("task7")
  task7(List.range(-20, 20))

  
  def task8(t: (String, Int, Char)) = { 
    println(t)
    t
  }

  println("task8")
  task8(("Ala", 3, 'c'))
  println()


  def task9(l: List[Any]) = {
    val result = l.filter(x => x != 0)
    println(result)
    result
  }
  println("task9")
  task9(List("Ala", 'c', 15, 20, 0, 3.5, 0))
  println()

  
  def task10(l: List[Int]): Option[Int] = { 
    val opt =
      try {
        Some(l(5))
      } catch {
        case e: Exception => None
      }
    println(opt)
    opt
  }
  println("Too short list")
  task10(List(1,2,3))
  println()

  println("Proper size list")
  task10(List.range(-20, 20))
  println()
}

