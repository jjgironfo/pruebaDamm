# Propiedades

## Ejecución en un solo dispositivo

### Capabilities para la instancia del driver

-implicitWait = Tiempo implicito sobre el driver creado

-appium.hub = Url del Servidor de Appium - Hub Server

* Si la ejecución es en un solo dispositivo (real o virtual) se deberá indicar toda la URL con el siguiente formato:

```  
http://<ip-host>:<puerto>/wd/hub

-Ejemplo: http://127.0.0.1:4275/wd/hub
```

-app= Ruta de ubicación al aplicativo empaquetado que será instalado antes de la ejecución, los valores aceptados son:
.apk, .ipa, .app

-automationName= Motor de automatización

* Para Android el valor es: UiAutomator2
* Para IOS el valor es: XCUITest

-platformName= Nombre de la plataforma de ejecución

* Ejemplo: Android, iOS

-platformVersion= Versión de la plataforma de ejecución

* Ejemplo: 11, 6.0

-deviceName= Nombre del dispositivo

-udid= Identificador único del dispositvo

* Ejemplo: emulator-5554, de780a771e67

-noReset= Propiedad 'booleana' (true | false) que indica si la aplicación se reiniciará o no en cada ejecución.

#### Android

-appActivity= Actividad 'launcher' de la aplicación android

-appPackage= Nombre del paquete de la aplicación android

* Para conocer estos datos puede ejecutar el siguiente comando en el terminal.

```
adb shell dumpsys window | grep -E 'mCurrentFocus' 

Ejemplo: 
- appActivity=com.google.android.apps.youtube.app.watchwhile.SplashActivity
- appPackage=com.google.android.youtube
```

### Ejemplo de configuración Android

```
mobiledriver:
  implicitWaitOnSeconds: 30

capabilities:
  appiumHub: http://127.0.0.1:4723/wd/hub
  automationName: UiAutomator2
  platformName: Android
  platformVersion: 11
  deviceName: Xiaomi A11
  app:
  udid: de780a771e67
  android:
    appActivity: com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity
    appPackage: com.google.android.youtube
  noReset: false
```

#### IOS

-bundleId= Identificador del aplicativo instalado en el dispositivo

* Ejemplo: com.apple.calculator

### Ejemplo de configuración iOS

```
mobiledriver:
  implicitWaitOnSeconds: 30

capabilities:
  appiumHub: http://127.0.0.1:4723/wd/hub
    automationName: XCUITest
    platformName: iOS
    platformVersion: 15.1
    deviceName: iPhone de XXXXX
    app:
    udid: XXXXX
    ios:
      bundleId: pe.pichincha.mb.uat
      xcodeOrgId: XXXXX
      xcodeSigningId: Apple Development
  noReset: false
```

## Ejecuciónes en paralelo

### Capabilities para la instancia del driver

-implicitWait = Tiempo implicito sobre el driver creado

-appium.hub = Url del Servidor de Appium - Hub Server

* Si la ejecución es en varios dispositivos (real o virtual) solo se deberá indicar el ip del host con el siguiente formato:

```  
http://<ip-host>

-Ejemplo: http://127.0.0.1
```

-noReset= Propiedad 'booleana' (true | false) que indica si la aplicación se reiniciará o no en cada ejecución.

-app= Ruta de ubicación al aplicativo empaquetado que será instalado antes de la ejecución, los valores aceptados son:
.apk, .ipa, .app

* Si la ejecución consta de 2 plataformas distintas (Android - iOS) utilizar las siguientes capabilities para cada
  plataforma:

```
- app.android = ruta del aplicativo (.apk)
- app.ios = ruta del aplicativo (.app | .ipa)
```

#### Android

-appActivity= Actividad 'launcher' de la aplicación android

-appPackage= Nombre del paquete de la aplicación android

* Para conocer estos datos puede ejecutar el siguiente comando en el terminal.

```
adb shell dumpsys window | grep -E 'mCurrentFocus' 

Ejemplo: 
capabilities:
...
  android:
    appActivity: com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity
    appPackage: com.google.android.youtube
```

#### IOS

-bundleId= Identificador del aplicativo instalado en el dispositivo

* Ejemplo: com.apple.calculator

### Ejemplo de configuración

```
ios:
  bundleId: com.apple.calculator
  xcodeOrgId: XXXXX
  xcodeSigningId: Apple Development
```

# Configuración rápida de capabilities

Ahora es posible enviar un json/Map a través de la propiedad **'capabilities.config'** 
para los dos sistemas operativos

Ejemplo:

**Android**

```
capabilities:
  appiumHub: http://192.168.0.4:4443
  platformName: android
  #appiumHub: http://127.0.0.1:4723/wd/hub
  config: '{"automationName":"UiAutomator2",
            "app":"",
            "appium:udid":"79eff58d",
            "appPackage":"com.google.android.youtube",
            "appActivity":"com.google.android.apps.youtube.app.WatchWhileActivity"}'
```

**iOS**

```
capabilities:
  appiumHub: http://192.168.0.4:4443
  #appiumHub: http://127.0.0.1:4723/wd/hub
  platformName: iOS
  #  platformVersion: 15.4
  config: '{"automationName":"XCUITest",
            "app":"",
            "appium:udid":"00008101-000E69583E44001E",
            "deviceName":"iPhone de Percy",
            "bundleId":"com.google.ios.youtube"}'
```


# AppiumGrid con Selenium Grid 4

Para configurar esta opción, consultar por el manual **"Manual - Appium Grid con Selenium Grid 4"**

# Grabar video de la ejecución: Android - iOS

Agregar la propiedad en el archivo de propiedades 'application.yml'

```
mobiledriver:
  screenRecorder: on
```

*Solo para iOS, indispensable instalar el binario ffmpeg

- https://ffmpeg.org/download.html