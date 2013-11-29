Future.class: Future.scala
	scalac -deprecation Future.scala

run-scala: Future.class
	scala -J-Xmx256m -J-Xms256m -cp . Future

run-clojure:
	java -Xmx256m -Xms256m -cp .:/home/mark/.m2/repository/org/clojure/clojure/1.5.1/clojure-1.5.1.jar clojure.main -m future

.PHONY: clean

clean:
	rm -f *.class

