//import java.io.FileWriter
//
//object drugs_S extends App {
//  val workingDir = System.getProperty("user.dir")
//  val srcName = s"$workingDir\\resources\\final.work.txt"
//  val dstName = s"$workingDir\\resources\\final.work.results.txt"
//
//  def openSource(fName: String) = {
//    println(s"Reading a file from source: $fName")
//    val filePointer = scala.io.Source.fromFile(fName, "UTF-8")
//    val myLines = filePointer.getLines.toSeq
//    filePointer.close()
//    myLines
//  }
//
//  def processSeq(mySeq:Seq[String]): Unit= {
//    val recipe: Seq[String] = mySeq.filter(n => n == n.toUpperCase)
//    val noEmptyrows = recipe.filter(row => row!= null && row.length>0)
//
////        val data = mySeq.
////          filter(rec => rec.split(",")(1) == rec.split(",")(1).toUpperCase())
////    data.foreach(println)
////
////    val lines = mySeq.
////      flatMap(rec => rec.split(" "))
////println(s" my lines are $lines")
//  }
//
//  def saveSeq(dstName: String, mySeq:Seq[String]) = {
//    println(s"Saving my Sequence to file $dstName")
//    mySeq.foreach(println)
//    val fw = new FileWriter(dstName)
//    mySeq.map(_ + "\n").foreach(fw.write)
//    fw.close()
//  }
//
//  val mySeq = openSource(srcName)
//  val filteredSeq = processSeq(mySeq)
//  saveSeq(dstName, filteredSeq)
//}