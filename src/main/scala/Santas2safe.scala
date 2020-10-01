import java.io.FileNotFoundException

import scala.collection.immutable.ListMap

object Santas2safe extends App {

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

  val shortestLine = myText.filter(_.size > 0).sortBy(_.size).reverse.reverse(0) //vismaza līnija, ir tukša linija (emty line)
  println(s"The shortest line in the text is $shortestLine") //the shortest line in the text

  def countedWords: Unit = {
    val counter = scala.io.Source.fromFile(srcName)
      .getLines
      .flatMap(_.split("\\W+"))
      .foldLeft(Map.empty[String, Int]) {
        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
      }
    println(ListMap(counter.toSeq.sortWith(_._2 > _._2): _*).take(10))
  }

  val countedWordsMost = countedWords
  //  1) the source
  //  2) get the lines
  //  3) using the split function get all words in put them in to a flatMap
  //  4) foldLeft : starting from the left (starting point) and go to end, and
  //     counted each word how many times it appears in this text file
  //  5) to sorted Map by value from high to low and return first 10 value

  println(s"The most used words in the text with these total amount are $countedWordsMost.")

  //TODO countedWords lai vai pielikt txt $
  //

  val wordManufacturer = myText.filter(_.contains("Manufacturer")).sortBy(_.length).reverse.foreach(println)
  //
  //val yearManufacture = wordManufacturer.toString TODO?


//SANTAS PART - Getting all mentioned DRUG NAMES

  //0taking only lines without particular strings
  val MinusSomeLines = myText
    .filterNot(_.contains("Manufacturer"))
    .filterNot(_.contains("Patent"))
    .filterNot(_.contains("January"))
    .filterNot(_.contains("STRESS"))
    .filterNot(_.contains("INSERTER"))
    .filterNot(_.contains("SEPTEMBER"))
    .filterNot(_.contains("CONCENTRATIONS"))
    .filterNot(_.contains("INCLUDING"))

  //1splitting lines in substrings = words
  val wordsplit = MinusSomeLines.flatMap(rec => rec.split(" "))
  //2taking only UPPER words
  val recipe = wordsplit.filter(n => n == n.toUpperCase)
  //3turning List of strings/String to particular strings
  val wordsAsStrings = recipe.mkString(" ")
  //4plitting Strings using regex
  val SplittedStringinWords = wordsAsStrings.split("\\s+")
  //5taking only lines containing 6 strings +
  val filteredBylength6plus = SplittedStringinWords.filter(_.length >= 6)
  //6filtering off other elements(mainly numbers, reduced signs and specific chars
  val DropallOtherChars = filteredBylength6plus.filterNot(_.contains("ML")).filterNot(_.contains(",")).filterNot(_.contains("/")).filterNot(_.contains("0")).filterNot(_.contains(")")).filterNot(_.contains("."))

  // OTHER solution versions - failed to get them working:
  // 1) val onlyCharWords = SplittedStringinWords.dropWhile(_......)
  // 2) val linesWithUpperWords = myText.filter(_.contains(recipe))
  // 3) val noEmptyrows = myText.filter(row => row != null && row.length > 0), maybe sliding; way of getting all lines after empty rows
  // 4) val FirstwordInLine = myText.takeWhile(_ = ' ') //filtering by first word and then cheking if word is UPPPER
  // 5) val lineswithNumbers = myText.filter(_.contains(...).foreach(println) // to filter them off

  //**********************************************
  //RESULTS
  println("***************************")
  DropallOtherChars.foreach(println)

}
