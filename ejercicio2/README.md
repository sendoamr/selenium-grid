##### 1 Levantar selenium grid con una instancia de chrome
##### 2 Lanzar la prueba con un unico navegador
```
mvn compile
mvn exec:java -Dexec.mainClass="com.bbva.selenium.Main" 
```
Obtener el tiempo total d la prueba

##### 3 Escalamos el numero de chromes a 2 y lanzamos la prueba de nuevo
Observamos que el lanzamiento no es secuencial y que se obtienen los 3 drivers en paralelo y comienzan las ejecuciones a la vez.


