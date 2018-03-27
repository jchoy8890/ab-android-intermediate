# ab-android-intermediate

Android Bootcamp - Android Intermediate

## Lesson 5

  - Network Connection

## Tools

Vamos a utilizar algunas herramientas que nos permitan realizar pruebas de los servicios que vamos a consumir desde nuestra app.

- Postman
Esta herramienta nos permite conectarnos a cualquier API Rest
https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop

- Visores de Json
JsonEditor , nos permite ver de una manera más ordenada la tramas que recibimos de los servicios, que normalmente son JSON. http://jsonviewer.stack.hu/

## Configuración del proyecto

- Primer paso:

Para conectarnos a la nube , necesitamos habilitar el permiso de internet. Para esto nos vamos a AndroidManifest y agregarmos el permiso :

```
...
	<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <uses-permission android:name="android.permission.INTERNET"/>
    
    <application
	.
	.
	.
	>
...
```

- Segundo Paso :

Vamos a agregar la dependencias de algunas librerias que nos ayuden para la conexión y procesar los datos que nos llega de la nube.

Retrofit : Es un cliente http diseñado para consumir servicios RESTFul , usa anotaciones para declarar las llamadas POST, GET, PUT , etc y tambien cuenta con callbacks para las respuesta a las peticiones hechas al servicio.

Gson : Esta librería te permite procesar las tramas del respuesta de un servicio(JSON) y poder convertirlas en clases.

OkHtttp : Sobre esta librería se construyo retrofit y es una librería general para realizar cualquier tipo de conección con un servicio RestFul o SOAP. Tambíen cuenta con ciertos utilitarios para poder visualizar en consola las tramas de envío y de respuesta . 

En el file build.gradle de la app realizamos lo siguiente :
		
```
	//RETROFIT https://github.com/square/retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.4.0'

    //GSON https://github.com/google/gson
    implementation 'com.google.code.gson:gson:2.8.2'
    implementation "com.squareup.retrofit2:converter-gson:2.4.0"
    
    //OKHTTP
    implementation 'com.squareup.okhttp3:okhttp:3.10.0'


    //INTERCEPTOR
    implementation "com.squareup.okhttp3:logging-interceptor:3.10.0"
```


## Probando los servicios 
	
Antes de realizar las llamadas a los servicios desde la app , es saludable revisar que los servicios estén operativos y corroborar cuales son las tramas de envío ( request) y de respuesta (response).
Para esto, vamos a usar POSTMAN

- Rest API

En esta oportunidad se ha construido un API Rest usando node.js y mongo.db
La url base es :

```
	https://obscure-earth-55790.herokuapp.com/
```

- Login

	Método : POST
	Path : api/login
	Url : https://obscure-earth-55790.herokuapp.com/api/login
	Request :
```
	{
		"username":"admin@admin.com",
		"password": "123456"
	}
```
	Response :

```
	{
	    "msg": "success",
	    "status": 200,
	    "data": {
		"_id": "59e0540d429d3f501d6493de",
		"id": "59e0540d429d3f501d6493de",
		"username": "admin@admin.com",
		"password": "123456",
		"firstname": "Admin",
		"lastname": "Admin",
		"__v": 0
	    }
	}
```

- Registro :

	Método : POST
	Path : api/users/register
	Url : https://obscure-earth-55790.herokuapp.com/api/users/register

	Request :
```
{
	"username":"demo@admin.com",
	"password":"123456",
	"firstname": "Demo",
	"lastname": "Demo"
}
```
	Response :

```
	{
	    "__v": 0,
	    "id": "59ea8b0f3ad73212009b314b",
	    "username": "demo@admin.com",
	    "password": "123456",
	    "firstname": "Demo",
	    "lastname": "Demo",
	    "_id": "59ea8b0f3ad73212009b314b"
	}
```

- Usuarios :

	Método : GET
	Path : api/users/
	Url : https://obscure-earth-55790.herokuapp.com/api/users/

	Response :

```
	{
	    "msg": "success",
	    "status": 200,
	    "data": [
		{
		    "_id": "59e0540d429d3f501d6493de",
		    "id": "59e0540d429d3f501d6493de",
		    "username": "admin@admin.com",
		    "password": "123456",
		    "firstname": "Admin",
		    "lastname": "Admin",
		    "__v": 0
		},
		{
		    "_id": "59e17088225f6f7b12d14b07",
		    "id": "59e17088225f6f7b12d14b07",
		    "username": "demo@demo.com",
		    "password": "123456",
		    "firstname": "Demo",
		    "lastname": "Demo",
		    "__v": 0
		},
		{
		    "_id": "59ea8b0f3ad73212009b314b",
		    "id": "59ea8b0f3ad73212009b314b",
		    "username": "demo@admin.com",
		    "password": "123456",
		    "firstname": "Demo",
		    "lastname": "Demo",
		    "__v": 0
		}
	    ]
	}

```


- Notas 

Método : GET

Path : api/notes/

Url : https://obscure-earth-55790.herokuapp.com/api/notes/
	
```
{"msg":"success","status":200,"data":[{"_id":"59f3c5f5145d3812006ab70d","id":"59f3c5f5145d3812006ab70d","name":"My nota","description":"Esta es un nota del server","path":"","userId":"59e0540d429d3f501d6493de","__v":0},{"_id":"59f3cc7df3474b1200ef4749","id":"59f3cc7df3474b1200ef4749","name":"Aviso","description":"Tomar UA3","path":"","userId":"59e0540d429d3f501d6493de","__v":0},{"_id":"59f3d417f3474b1200ef476a","id":"59f3d417f3474b1200ef476a","name":"My nota2","description":"Test Note4","path":"","userId":"59e0540d429d3f501d6493de","__v":0},{"_id":"59f3d459f3474b1200ef476b","id":"59f3d459f3474b1200ef476b","name":"Aviso","description":"Get ready for UA3","path":"","userId":"59e0540d429d3f501d6493de","__v":0},{"_id":"59f3d4def3474b1200ef476c","id":"59f3d4def3474b1200ef476c","name":"Recordatorio","description":"Entregable 2 del proyecto android","path":"","userId":"59e0540d429d3f501d6493de","__v":0},{"_id":"59f3d926f3474b1200ef476d","id":"59f3d926f3474b1200ef476d","name":"Recordatorio","description":"Entregable 2 del proyecto android","path":"","userId":"59e0540d429d3f501d6493de","__v":0},{"_id":"59f3df96f3474b1200ef476e","id":"59f3df96f3474b1200ef476e","description":"Nota de la app","name":"nota desde la app","userId":"59e0540d429d3f501d6493de","__v":0},{"_id":"59f48504e863f612000bc670","id":"59f48504e863f612000bc670","name":"Nota demo 1","description":"Nota de usuario demo 1","path":"","userId":"59e17088225f6f7b12d14b07","__v":0},{"_id":"59f48513e863f612000bc671","id":"59f48513e863f612000bc671","name":"Nota demo 2","description":"Nota de usuario demo 2","path":"","userId":"59e17088225f6f7b12d14b07","__v":0},{"_id":"59f4851be863f612000bc672","id":"59f4851be863f612000bc672","name":"Nota demo 3 Update 1","description":"Nota de usuario demo 3","path":"","userId":"59e17088225f6f7b12d14b07","__v":0},{"_id":"59f498c6502b052218b25479","id":"59f498c6502b052218b25479","name":"My nota 00","description":"Esta es un nota 00","path":"","userId":"59e0540d429d3f501d6493de","__v":0},{"_id":"59f4999d2e554e9918fe21a9","id":"59f4999d2e554e9918fe21a9","name":"My nota 02","description":"Esta es un nota 02","path":"","userId":"59e0540d429d3f501d6493de","__v":0},{"_id":"59f49a0e2e554e9918fe21aa","id":"59f49a0e2e554e9918fe21aa","name":"My nota 02","description":"Esta es un nota 02","path":"","userId":"59e0540d429d3f501d6493de","__v":0}]}

```

- Agregar Notas

Método : POST

Path : api/notes/register

Url : https://obscure-earth-55790.herokuapp.com/api/notes/register


- Actualizar Notas

Método : PUT

Path : api/notes/{id}

Url : https://obscure-earth-55790.herokuapp.com/api/notes/59f498c6502b052218b25479

- Borrar Notas

Método : DELETE

Path : api/notes/{id}

Url : https://obscure-earth-55790.herokuapp.com/api/notes/59f498c6502b052218b25479


-    
## References 

- Connecting to the Network https://developer.android.com/training/basics/network-ops/connecting.html

- Transmitting Network Data Using Volley https://developer.android.com/training/volley/index.html

- Retrofit http://square.github.io/retrofit/

- Retrofit 2 tutoriales https://futurestud.io/

