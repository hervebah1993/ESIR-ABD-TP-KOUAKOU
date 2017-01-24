#!/bin/bash
for i in `seq 1 10`;
do
	echo "LE NOMBRE DE WORKERS EST $i ";
	spark-submit --class "Integral" --master local[$i] target/scala-2.11/integral-project_2.11-1.0.jar;
done

