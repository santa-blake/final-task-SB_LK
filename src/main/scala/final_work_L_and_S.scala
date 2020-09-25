import java.io.FileNotFoundException

object final_work_L_and_S extends App {

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
  // myText.foreach(println) // šo noteikti ņemsim nost, es pagaidām uzliku lai skatītos tekstu


  val longestLine = myText.sortBy(_.size).reverse(0) //the longest line in text
  println(s"In the text the longest line is $longestLine")

  val longestLineLength = longestLine.length
  println(s"In the text the longest line amount is $longestLineLength") //the longest line amount of symbol

  val splitLine = longestLine.split(" ") //to split the words(symbols as well) length
  val longestWord = splitLine.map(word => word ->  word.length)

  println(longestWord.take(4: Int).mkString
  ("The first words with amount of length  from longest line in the text are " + "(", ", ", ")")) //is returned only the first four words from longest line in the text

  val oneLiner = longestWord.groupBy(_.toString().length).mapValues(_.toSet).maxBy(_._1)
  println(s"The longest words from longest line are $oneLiner") //the longest words


  // Sis bus beigas
  //  val mySeq = openSource(srcName)
  //  val filteredSeq = processSeq(mySeq)
  //  saveSeq(destName,filteredSeq)

}
