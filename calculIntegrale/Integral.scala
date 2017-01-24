import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Integral {

        def main(args:Array[String]){
                val conf = new SparkConf().setAppName("Integral")
                val sc = new SparkContext(conf)
                print("Entrez le nombre de rectangle : ")
                var nbrectangle = readInt()
                print("Entrez le nombre de slices : ")
                var slices = readInt()
                val nbrep = 10
                var integrale:Double = 0.0
                nbrectangle = nbrectangle * 10
                var largeur = 9.0 / nbrectangle
                var start = System.nanoTime
                for(i <- 1 to nbrep){
                        integrale = sc.parallelize(0 to nbrectangle-1, slices).map(x => largeur/(1+x*largeur)).reduce(_ + _)
                }              
                var end = System.nanoTime
                var time = (end - start) /1000000000.0
                println("Resultat obtenu avec " + nbrectangle + " rectangles :  " + integrale)    
                println("time execution : " +  time/nbrep + " secondes"  )
                println("")	
        }
}



