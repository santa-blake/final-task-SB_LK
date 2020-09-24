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
  // šo noteikti ņemsim nost, es pagaidām uzliku lai skatītos tekstu

  val longestLine = myText.sortBy(_.size).reverse(0) //the longest line in text
  println(s"In the text the longest line is $longestLine")

  val longestLineLength = longestLine.length
  println(s"In the text the longest line amount is $longestLineLength") //the longest line amount of symbol


  val splitLine = longestLine.split(" ") //to split the words(symbols as well) length
  val longestWord = splitLine.map(word => word ->  word.length) //sim smuki sanak visi vardi ar garuma skaitu no
  longestWord.foreach(println)                                  //tikai vel nekadi nevaru atrast pareizo formulejumu
                                                                // max un min, bet gan to atkodisu :-)

  println(longestWord.max, longestWord.min) //īsti nav pareizs!!!


  //println(longestWord.max, longestWord.min) // japārbauda ! // izskatās, ka pagaidām neuzrādās īsākais vārds - rezultātos tukšums
  // /arī garākais vārds izskatās, ka sastāv no 2 vārdiem.
  // TODO Mēģināsim atrisināt šo "longestWord" ...


}