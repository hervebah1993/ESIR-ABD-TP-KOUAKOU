FICHIERS
- Bigram : Programme original
- script.sh : Evaluation du temps d'execution en fonction du nombre de worker 

EXECUTION 
sbt package
spark-submit --class "Bigram" --master local[4] target/scala-2.11/bigram-project_2.11-1.0.jar

EXECUTION ON CLUSTER
 spark-submit --class "Bigram" --master spark://ESIR-ABD-tp-KOUAKOU:7077 target/scala-2.11/bigram-project_2.11-1.0.jar
