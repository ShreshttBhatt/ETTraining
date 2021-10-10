# ET Training

Apache ANT - https://ant.apache.org/

Apache Maven - https://maven.apache.org/

JUnit 5 - https://junit.org/junit5/docs/current/user-guide/



## Cheat Sheet

### ANT

```
ant -version
ant -f build2.xml OR ant -buildfile build2.xml
ant -v OR ant -verbose
ant [target] -D[name]=[value]
ant -debug
ant -quiet
ant -keep-going
ant -p OR ant -projecthelp
ant -help / ant -h
```

### MAVEN

```
mvn -v OR mvn --version
mvn clean install
mvn clean package
mvn help:effective-pom
mvn -h
mvn -f pom2.xml clean
mvn dependency:tree
mvn dependency:analyze
mvn dependency:tree -Dverbose=true
mvn clean package -DskipTests
maven clean package -Dmaven.test.skip=true
mvn clean package -o OR mvn clean package --offline
mvn -q package
mvn -X package
mvn -T 4 package
```
