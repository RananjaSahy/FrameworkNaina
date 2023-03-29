javac -source 1.8 -target 1.8 Annotation/*.java
javac -source 1.8 -target 1.8 utilities/*.java
javac -source 1.8 -target 1.8 etu1855/framework/servlet/*.java
javac -source 1.8 -target 1.8 etu1855/framework/*.java

jar cvf frm.jar *
copy "./frm.jar" "../Test/WEB-INF/lib/frm.jar"
del frm.jar
cd ./../Test/WEB-INF/classes
javac -source 1.8 -target 1.8 -cp "../lib/frm.jar" Modele/*.java
cd ./../../
jar cvf projet_test.war *
copy "./projet_test.war" "./../"
del projet_test.war

