@echo off
javac -d aeropuerto\exe deque\*.java listas\*.java estructuras\*.java aeropuerto\*.java
cd aeropuerto
cd exe
java aeropuerto.Vuelos
pause
