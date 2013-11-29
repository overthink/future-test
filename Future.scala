object Future {

  def scala293() {
    val max = 3000000000L
    var i = 0L
    while (i <= max) {
      // Scala 2.9.3 style future
      //scala.concurrent.ops.future {
      import scala.concurrent.TaskRunners.threadPoolRunner
      //println("queueing up %d".format(i))
      scala.concurrent.ops.future {
        println("running future %d".format(i))
        Thread.sleep(5000)
      }//(scala.concurrent.TaskRunners.threadPoolRunner)
      i += 1
    }
  }

  def scala2103() {
    val max = 3000000000L
    var i = 0L
    while (i <= max) {
      import scala.concurrent.ExecutionContext.Implicits.global
      if (i % 100000000 == 0) {
        println("queueing up %d".format(i))
      }
      scala.concurrent.future {
        println("in future %s".format(i))
        Thread.sleep(5000)
      }
      i += 1
    }
  }

  def main(argv: Array[String]) {
    println("starting")
    //scala293()
    scala2103()
    Thread.sleep(1000000000)
  }
}

