import java.io.FileNotFoundException

object final_work_1 extends App {

  val srcName = "c:/poem/final.work.txt"
  val destName = "c:/poem/final.work.results.txt"

  var myText = Seq[String]()
  try {
    val filePointer = scala.io.Source.fromFile(srcName)
    val myLines = filePointer.getLines
    myText = myLines.toSeq
    filePointer.close()
  } catch {
    case ex: FileNotFoundException =>
      println(s"file not found $ex")

  }
  //myText.foreach(println) // pagaidām varbūt neprintējam visu tekstu, lai vieglāk redzēt izdarītos/atlasītos (?)
  val longestLine = myText.sortBy(_.size).reverse(0) //the longest line in text
  println(s"In the text the longest line is $longestLine")

  val longestLineSize = longestLine.size
  println(s"In the text the longest line amount is $longestLineSize") //the longest line amount of letter

  val longestWord = myText.map(word => word -> word.length)
  println(longestWord.max, longestWord.min) // japārbauda ! // izskatās, ka pagaidām neuzrādās īsākais vārds - rezultātos tukšums
  // /arī garākais vārds izskatās, ka sastāv no 2 vārdiem.
  // TODO Mēģināsim atrisināt šo "longestWord" ...

  //println(myLineSplits.max, myLineSplits.min)
  //val longestLineSum = myText.map (txt => txt(longestLine.length)).toSeq //longest line letters sum
  //println(longestLineSum)


  //  myLines.split("\\D+").filter(_.nonEmpty).toList
  //  print(("""\d+""".r findAllIn myText).toList)

  //  myText.split(" ").filter(_.exists(num))
  //  (" ").filter(_.Null).toList


  //  def saveSeq(destName:String, mySeq:Seq[String]) = {
  //    println(s"Saving my Sequence to file $destName")
  //  }
  //  val mySeq = srcName
  //  //val filteredSeq = processSeq(mySeq)
  //  saveSeq(dstName)
}