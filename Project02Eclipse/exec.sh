
JAVA_FILES=sources.txt

find ./ -name "*.java" > $JAVA_FILES
javac @$JAVA_FILES
java -cp "src" com.hemebiotech.analytics.Main

rm $JAVA_FILES