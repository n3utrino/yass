@echo off
set JAVA_HOME=C:\Program Files (x86)\Java\jdk1.7.0_51
set version=0.0
set /p version=Version [ MAJOR.MINOR or 'enter' for %version% ]?:
cmd /c C:\development\gradle-1.10\bin\gradle.bat -Pversion=%version%
pause
