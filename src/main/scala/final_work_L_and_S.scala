import java.io.FileNotFoundException

import scala.collection.immutable.ListMap

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



  //Santas search 28.09.2020./
  val wordsplit = myText.flatMap(rec => rec.split(" "))
  val recipe: Seq[String] = wordsplit.filter(n => n == n.toUpperCase)

  val linesWithUpperWords: Seq[String] = myText.filter(_.contains(recipe))
  //val noEmptyrows = myText.filter(row => row != null && row.length > 0)

  //Šeit velējos dabūt ārā rindas ar skaitļiem, lai pēc tam tās noņemtu no Upper rindām
  //val lineswithNumbers = myText.filter(_.contains(...).sortBy(_.length).reverse.foreach(println)

  println(s" List of UpperWords: $recipe")
  println(s" And here are my $linesWithUpperWords") // Printējas kā List (), bez uzskaitījuma - varbūt zini, kā dabūt atsevišķas rindas, foreach man nedarbojās :( ?
  //linesWithUpperWords.toString // ?
  //println(linesWithUpperWords) // ?

}
