@echo off
setlocal enabledelayedexpansion

REM Recursively find and compile Java files
for /r %%i in (*.java) do (
    javac -d . -encoding UTF-8 "%%i"
)

echo Compilation complete.
