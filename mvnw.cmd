@echo off
setlocal
set "DIR=%~dp0"
set "MAVEN_WRAPPER_JAR=%DIR%.mvn\wrapper\maven-wrapper.jar"
if not exist "%MAVEN_WRAPPER_JAR%" (
  echo Maven Wrapper JAR not found, downloading...\r
  powershell -Command "Invoke-WebRequest -Uri https://repo.maven.apache.org/maven2/io/takari/maven-wrapper/0.5.6/maven-wrapper-0.5.6.jar -OutFile \"%MAVEN_WRAPPER_JAR%\""
)
java -jar "%MAVEN_WRAPPER_JAR%" %*
endlocal
