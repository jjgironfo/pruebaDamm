# DAMM


## Principales tecnologías

Java + SpringBoot + Appium + Cucumber + TestNG + Maven

## Credenciales

He apuntado correos y usuarios de la app en un archivo:

`everis-app-mobile-appium-java-master/credenciales.md`


## Estructura maven

El proyecto se compone de dos módulos maven:

* everis-app-mobile-appium-java-master
* everis-lib-mobile-appium-java-master

### everis-app-mobile-appium-java-master

Contiene el código específico para el testing de la app DAMM. Una de sus dependencias maven es la compilación del otro módulo.

### everis-lib-mobile-appium-java-master

Proyecto genérico para utilizar como dependencia en proyectos de automatización mobile.


## Configuración para ejecuciones

Hay cuatro archivos principales de configuración dentro del módulo `everis-app-mobile-appium-java-master`:

### src/test/resources/application.properties

Capabilities y datos de la aplicación.

### src/test/java/com/everis/ct/mobile/runner/*.java

Features a ejecutar y número de intentos.

### parallelExecution.xml

Móvil que realizará la ejecución y su Runner.java

### pom.xml

En el plugin surefire se indica que queremos ejecutar la suite parallelExecution.xml


## Allure report

Se pueden encontrar los archivos de Allure en la ruta: `everis-app-mobile-appium-java-master/target/allure-results`

Esta configurado con un plugin que descarga e inicia el servidor local de Allure para visualizar el reporte.
Simplemente, desde la carpeta `everis-app-mobile-appium-java-master` hay que ejecutar el comando:

``` shell
mvn allure:serve
```

O, desde el proyecto padre:

``` shell
mvn -f everis-app-mobile-appium-java-master allure:serve
```

Este otro comando genera una carpeta con archivos HTML y CSS, entre otros, para poder visualizarlo sin el servidor activo:

``` shell
mvn allure:report
```

