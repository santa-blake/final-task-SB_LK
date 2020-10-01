import java.io.{File, FileNotFoundException}

  object Santas extends App{

    println(System.getProperty("user.dir"))

    def getListOfFiles(dir: String):List[File] = {
      val d = new File(dir)
      if (d.exists && d.isDirectory) {
        d.listFiles.filter(_.isFile).toList
      } else {
        List[File]()
      }
    }
    val f_list = getListOfFiles("./")
    f_list.foreach(println)
    getListOfFiles("./src").foreach(println)
    getListOfFiles("./src/resources").foreach(println)
    def getLineCount(fileName:String): Int = {
      var count = 0
      val bufferedSource = io.Source.fromFile(fileName)
      for (line <- bufferedSource.getLines) {
        count += 1
      }
      bufferedSource.close
      count
    }
    def getRowSplitSize(fileName:String): Int = {
      var count = 0
      val bufferedSource = io.Source.fromFile(fileName)
      for (line <- bufferedSource.getLines) {
        val splitLine = line.split(";")
        count += splitLine.size
      }
      bufferedSource.close
      count
    }

    def getLinesWithSplitSize(fileName:String, splitSize:Int): Int = {
      var count = 0
      val bufferedSource = io.Source.fromFile(fileName)
      for (line <- bufferedSource.getLines) {
        val splitLine = line.split(";")
        if (splitLine.size == splitSize) {
          println(line)
          count += 1
        }
      }
      bufferedSource.close
      count //return how many lines are there
    }

    def getLineSplits(fileName:String): Seq[Int] = {
      var myListBuf = scala.collection.mutable.ListBuffer[Int]()
      val bufferedSource = io.Source.fromFile(fileName)
      for (line <- bufferedSource.getLines) {
        val splitLine = line.split(";")
        myListBuf += splitLine.size
      }
      bufferedSource.close
      myListBuf.toSeq //return how many lines are there
    }
    def getParsedLines(fileName:String) = {
      var myListBuf = scala.collection.mutable.ListBuffer[Seq[String]]()
      val bufferedSource = io.Source.fromFile(fileName)
      for (line <- bufferedSource.getLines) {
        val splitLine = line.split(";")
        myListBuf += splitLine
      }
      bufferedSource.close
      myListBuf.toSeq //return how many lines are there
    }
    def getUpperLines(fileName:String) = {
      var myListBuf = scala.collection.mutable.ListBuffer[Seq[String]]()
      val bufferedSource = io.Source.fromFile(fileName)
      for (line <- bufferedSource.getLines) {
        val splitLine = line.split(";").filter(n => n == n.toUpperCase)
       // if (splitLine.startsWith(_)) {
//          println(line)
//        }
        myListBuf += splitLine
      }
      bufferedSource.close
      myListBuf.toSeq //return how many lines are there
    }

    val filePath = "./src/resources/final.work.txt"
    val lineCount = getLineCount(filePath)
    println(s"We got a file with $lineCount lines")
    val rowSplitCount = getRowSplitSize(filePath)
    println(s"We got a file with $rowSplitCount lines")
    val linesWith2 = getLinesWithSplitSize(filePath, 2)
    println(linesWith2)
    val linesWith3 = getLinesWithSplitSize(filePath, 3)
    println(linesWith3)
    val linesWith4 = getLinesWithSplitSize(filePath, 4)
    println(linesWith4)
    val linesWith5 = getLinesWithSplitSize(filePath, 5)
    println(linesWith5)

//    val myLineSplits = getLineSplits(filePath)
//    println(myLineSplits.max, myLineSplits.min)
//    val uniques = myLineSplits.toSet //with sets we can check for uniques
//    println(uniques)

val rawSplit = getParsedLines(filePath)
    println(rawSplit.size)
    println(rawSplit(6)) // !!!!!!! TODO te var ierakstīt rindas numuru, ko printēt (realais -1), Bus ArraySeq formata

    // splitLine.map(fields => (fields(0) + "/" + fields(2)))
//rawSplit(6, 52, 71, 78, 86, 95, 154, 194, 301, 356, 387, 440, 506, 511, 580, 652, 656, 664, 669, 673, 710, 716, 775, 877, 921, 974, 1004, 1011, 1083, 1089, 1146, 1158, 1163, 1171, 1223, 1227, 1235, 1542, 1705, 1741, 1786, 1791, 1878, 1884, 1976, 1989).foreach
// println(args.map(_.mkString(" "))
    //
    // println(rawSplit(6, 52, 71, 78, 86, 95, 154, 194, 301, 356, 387, 440, 506, 511, 580, 652, 656, 664, 669, 673, 710, 716, 775, 877, 921, 974, 1004, 1011, 1083, 1089, 1146, 1158, 1163, 1171, 1223, 1227, 1235, 1542, 1705, 1741, 1786, 1791, 1878, 1884, 1976, 1989)).foreach

//    val Upperlines = getUpperLines
//    println(getUpperLines)

//    val filteredResults = rawSplit.filter(_.size == 2)
//    println(filteredResults.size)
//    println(rawSplit(0))

    //PIEMERI, KA APSTRADAT BASIC SPLITUS!!!!!
// val ourPurchases = getPurchaseSeq(filteredResults.slice(1,filteredResults.size))
//    //  println(ourPurchases(0))
//    val sortedByPrice = ourPurchases.sortBy(_.price).reverse
//    //  sortedByPrice.slice(0,5).foreach(println)
//
//    val wordsplit = myText.flatMap(rec => rec.split(" "))
//    val recipe = wordsplit.filter(n => n == n.toUpperCase)
//
//    val linesWithUpperWords = myText.filter(_.contains(wordsplit.filter(n => n == n.toUpperCase)))
//    //val noEmptyrows = myText.filter(row => row != null && row.length > 0)
//
//    //Šeit velējos dabūt ārā rindas ar skaitļiem, lai pēc tam tās noņemtu no Upper rindām
//    //val lineswithNumbers = myText.filter(_.contains(...).foreach(println)
//
//    println(s" List of UpperWords: ${recipe}")
//    println(s" And here are my ${linesWithUpperWords}") // Printējas kā List (), bez uzskaitījuma - varbūt zini, kā dabūt atsevišķas rindas, foreach man nedarbojās :( ?
//
//   // linesWithUpperWords.foreach(println)

   // def getPrettyText(p: Purchase) :String = {
   //  s"Area: ${p.area} - Region: ${p.region} - Price: ${p.price}"
    // }

    // biggestProperties.foreach(prop => println(getPrettyText(prop)))
    // val propertyLines = biggestProperties.map(getPrettyText(_))

  //println(linesWithUpperWords) // ?
    //val y = myText.filter(_.size(take while > 6, drop while < 20))// cita komanda
}
