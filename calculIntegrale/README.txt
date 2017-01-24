calculIntegrale

FICHIERS:
- Integral.scala : Programme original
- script.sh : script permettant l'evalution du temps d'execution en fonction du nombre de worker

EXECUTION:
sbt package
spark-submit --class "Integral" --master local[4] target/scala-2.11/integral-project_2.11-1.0.jar
