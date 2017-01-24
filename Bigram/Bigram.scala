import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Bigram {

	def main(args:Array[String]){

		val conf = new SparkConf().setAppName("Bigram ")
		val sc = new SparkContext(conf)
		var nbrep = 10
		val rdd =sc.textFile("/home/herve/tpSpark/texte.txt")
		var start = System.nanoTime
		for(i <- 1 to nbrep){

			val bah = rdd.map{
				_.split('.').map{ substrings =>
					substrings.trim.split(' ').
					map{_.replaceAll("""[\p{Punct}]""", "").toLowerCase()}.
					sliding(2)
					}.flatMap{identity}.map{_.mkString(" ")}.
					groupBy{identity}.mapValues{_.size}
					}.
					flatMap{identity}.reduceByKey(_+_).sortBy(_._2).collect()
					
		}

		var end = System.nanoTime
		var time = (end - start) /1000000000.0
		println("time execution : " +  time/nbrep + " secondes"  )	
		bah.foreach{x=> println(x._1 + " => " + x._2)}	
	}

}
