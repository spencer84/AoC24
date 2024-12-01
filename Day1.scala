object Day1{
    def main(args: Array[String]): Unit = {
        // Read in input data
        val lines = scala.io.Source.fromFile("Day1InputTest.txt").getLines().toSeq

        val leftData = lines.map(_.toString().substring(0,5)).toList.sorted
        val rightData = lines.map(_.toString().substring(8,13)).toList.sorted

        // Part 1 -- Difference Scores

        val tupleList = leftData zip rightData
        val result = tupleList.map((a: String, b: String) => (a.toInt-b.toInt).abs).reduce(additionReduce)
        println(result)

        // Part 2 -- Similarity Scores

        val similarity = leftData.map(findSimilarity(_,rightData))

        val resultTwo = similarity.reduce(additionReduce)

        println(resultTwo)
    }

    def additionReduce(num1: Int, num2: Int): Int = {
        num1 + num2
    }

    def findSimilarity(string: String, list: List[String]): Int = {
        val frequency = list.count(_ == string)
        string.toInt * frequency
    }

    // def addToList(string: String, arr: Array[String]): Array[String] = {

    // }
}   