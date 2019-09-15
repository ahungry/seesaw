all: run

# export _JAVA_OPTIONS='-Dawt.useSystemAAFontSettings=lcd'
run: target/substance-1.0.0-SNAPSHOT-standalone.jar
	java -Dswing.aatext=true -Dawt.useSystemAAFontSettings=lcd -jar ./target/substance-1.0.0-SNAPSHOT-standalone.jar

target/substance-1.0.0-SNAPSHOT-standalone.jar:
	lein deps
	lein uberjar
