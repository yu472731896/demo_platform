@echo off & setlocal enabledelayedexpansion
set LIB_JARS=""
cd  ../lib
set LIB_PATH=%cd%
for %%i in (*) do set LIB_JARS=!LIB_JARS!;..\lib\%%i
set LOAD_CLASS=""
cd ../conf
for /f "delims== tokens=1*" %%a in ('type spring.application.properties ^|findstr /i "main.class"') do set LOAD_CLASS=%%b
cd ..
set STDOUT_PATH=%cd%\logs
if exist %STDOUT_PATH% (
  echo "log path exist"
) else (
  md logs
)
set STDOUT_FILE=%STDOUT_PATH%\stdout.log

echo started ...
java -Xms512m -Xmx1024m -cp %LIB_PATH%\* %LOAD_CLASS% > %STDOUT_FILE% 2>&1 &

pause