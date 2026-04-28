@ECHO OFF
SET MAVEN_PROJECTBASEDIR=%~dp0
SET MAVEN_HOME=%MAVEN_PROJECTBASEDIR%\.mvn
powershell -Command "Invoke-WebRequest https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.6/apache-maven-3.9.6-bin.zip -OutFile maven.zip"
powershell -Command "Expand-Archive maven.zip -DestinationPath .mvn"
CALL .mvn\apache-maven-3.9.6\bin\mvn.cmd %*