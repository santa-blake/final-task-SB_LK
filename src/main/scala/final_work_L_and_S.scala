import java.io.FileNotFoundException

import scala.collection.immutable.ListMap

object final_work_L_and_S extends App {

  val srcName = "c:/final.work.txt"
  val destName = "c:/final.work.results.txt"

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
  val DropallOtherChars = filteredBylength6plus.filterNot(_ contains("ML")).filterNot(_ contains(",")).filterNot(_ contains("/")).filterNot(_ contains("0")).filterNot(_ contains(")")).filterNot(_ contains("."))

  // OTHER solution versions - failed to get them working:
  // 1) val onlyCharWords = SplittedStringinWords.dropWhile(_......)
  // 2) val linesWithUpperWords = myText.filter(_.contains(recipe))
  // 3) val noEmptyrows = myText.filter(row => row != null && row.length > 0), maybe sliding; way of getting all lines after empty rows
  // 4) val FirstwordInLine = myText.takeWhile(_ = ' ') //filtering by first word and then cheking if word is UPPPER
  // 5) val lineswithNumbers = myText.filter(_.contains(...).foreach(println) // to filter them off

  //****************
  //RESULTS
  println("*********")
  DropallOtherChars.foreach(println)


  // LAURAS PART
  val longestLine = myText.sortBy(_.size).reverse(0)
  println(s"In the text the longest line = $longestLine")
  //the longest line in text

  val longestLineLength = longestLine.length
  println(s"In the text the longest line amount = $longestLineLength")
  //the longest line amount of symbol

  val splitLine = longestLine.split(" ") //to split the words(symbols as well) length
  val longestWord = splitLine.map(word => word -> word.length)
  //word length with amount

  println(longestWord.take(4: Int).mkString
  ("The first 4 words with amount of length  from longest line in the text = " + "(", ", ", ")"))
  //is returned only the first four words from longest line in the text


  val oneLiner = longestWord.groupBy(_.toString().length).mapValues(_.toSet).maxBy(_._1)
  println(s"The longest words from longest line = $oneLiner") //the longest words

  //26/09
  val shortestLine = myText.filter(_.size > 0).sortBy(_.size).reverse.reverse(0)
  //the shortest line with empty line
  println(s"The shortest line in the text is $shortestLine") //the shortest line in the text

  def countedWords: Unit = {
    val counter = scala.io.Source.fromFile(srcName)
      .getLines
      .flatMap(_.split("\\W+"))
      .foldLeft(Map.empty[String, Int]) {
        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
      }

    println(s"The most used words in the text with these total amount are" +
      s" = ${ListMap(counter.toSeq.sortWith(_._2 > _._2): _*).take(10)}")
  }

  val countedWordsMost = countedWords.toString
  //  1) the source
  //  2) get the lines
  //  3) using the split function get all words in put them in to a flatMap
  //  4) foldLeft : starting from the left (starting point) and go to end, and
  //     counted each word how many times it appears in this text file
  //  5) to sorted Map by value from high to low and return first 10 value


  val wordManufacturer = myText.filter(_.contains("Manufacturer")).sortBy(_.length).reverse
  //  1) filter word Manufacturer in the text
  //  2) sorted by length and done reverse (to get longest line first)


  val yearManufacture = wordManufacturer.toList.filter(_.contains("date"))
  //.foreach(println)
  //  1) filter word date, to get lines with date from Manufacture list


  val noStrength = yearManufacture.toString().replaceAll("""Strength(.*?),""", "")
  //println(noStrength)
  // 1) replaced 'fixed text' from line with empty - 'Strength(s)... until up to the first comma'
  // 2) (.*?) up to the first comma


  val noComma = noStrength.toString().replaceAll(""",""", ".").toSeq
  //println(noComma)
  // 1) replaced comma with dot


  val splitNoStrength = noComma.mkString.split("Manufacturer:").sortBy(_.length).reverse.toList
  //.foreach(println)
  // 1) split strings with first string "Manufacture:"
  // 2) sorted by line length

  for(element<-splitNoStrength) {
    {
      println(s"Manufacturer:$element")
    }
  }
  // 1) added back word 'Manufacture'  to lines


  val year = splitNoStrength.filter(_.contains ("2011.")).foreach(println)
  // 1) filter year 2012


  // This part I haven't done
  //I wanted to filter some years with > or <, but I didn't get correct data.

  /** create the case class */
   val splitForCase = noStrength.split("\\s").toList
  println(noStrength)
  // 1) split words from noStrength
  //



//  val mySeq = openSource(srcName)
//  val filteredSeq = processSeq(mySeq)
//  saveSeq(dstName,filteredSeq)

}
