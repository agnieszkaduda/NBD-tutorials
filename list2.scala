object list2 extends App {

  def task1(s: String): String = s match {
    case work if (List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday").foldRight(false)((x, y) => s.contains(x) || y)) => {println("work"); "work"}
    case weekend if (List("Saturday", "Sunday").foldRight(false)((x, y) => s.contains(x) || y)) => {println("weekend"); "weekend"}
    case _ => {println("No such day"); "No such day"}
  }
  println("task1")
  task1("thisisMonday")
  task1("1234Saturday09876")
  task1("this is not a day name")
  println()


  def task2() = {

    class BankAccount(private var _currentBalance: Double) {
      def this() = this(0)

      def deposit(add: Double): Double = {
        _currentBalance += add
        _currentBalance
      }

      def withdraw(take: Double): Double = {
        _currentBalance -= take
        _currentBalance
      }

      def currentBalance = _currentBalance
    }

    val account = new BankAccount()
    println(account.currentBalance) 
    val account2 = new BankAccount(5)
    println(account2.withdraw(3))
  }
  println("task2")
  task2()
  println()



  def task3() = {
    case class Person(val fname: String, val lname: String)

    def greeting(p: Person): String = p match {
      case k if (k.lname(0) >= 'A' && k.lname(0) <= 'L') => "Greetings, person with surname beginning from A to L"
      case w if (w.lname(0) <= 'X') => "Greetings, person with surname from M to X"
      case _ => "Greetings"
    }

    val p1 = Person("Jan", "Kowalski")
    val p2 = Person("Ela", "Nowak")
    val p3 = Person("Adam", "Zuda")

    for (i <- List(p1, p2, p3))
      println(greeting(i))
  }
  println("task3")
  task3()
  println()


  def task4(a: Int, f: Int => Int): Int = {
    val result = f(f(f(a)))
    println(result)
    result
  }
  println("task4")
  task4(5, _ + 1)
  task4(3, x => x * 4)
  println()

  
  def task5() = {
    
    class Person(val firstName: String, val lastName: String, val taxToPay: Double) {
      def this(firstName: String, lastName: String) = {
        this(firstName, lastName, 0)
      }
    }
    
    trait Employee extends Person {
      val _salary = 0
      def salary = _salary
      override def taxToPay: Double = salary * 0.2
      def this(firstName: String, lastName: String, _salary: Double) = {
        this(firstName, lastName)
        this.salary = _salary
      
      }
    }
    
    trait Student extends Person {
      override def taxToPay: Double = 0
    }
    
    trait Teacher extends Employee {
      override def taxToPay: Double = salary * 0.1
    }
    
    val employee = new Person("Agnieszka", "Duda", 100) with Employee
    val student = new Person("Jan", "Kowalski", 50) with Student
    val teacher = new Person("Adam", "Nowak", 10) with Teacher
    val studentEmployee = new Person("Jan", "Duda", 5) with Student with Employee
    val employeeStudent = new Person("Agnieszka", "Kowalska", 1) with Employee with Student

    println("Employee tax: " + employee.taxToPay)
    println("Student tax: " + student.taxToPay)
    println("Teacher tax: " + teacher.taxToPay)
    println("Student with employee tax: " + studentEmployee.taxToPay)
    println("Employee with student tax: " + employeeStudent.taxToPay)

    
    }
  
}
