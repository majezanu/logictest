Los requerimientos del problema son los siguientes:
Según las especificaciones del problema, se tiene que contamos con una matriz de MxN
En la que partimos en la posición [0,0] y viendo hacia la derecha, de ahí se puede
mover una posición a la vez, no puedes ocupar un espacio que ya has ocupado antes,
si estás en esta situación debes doblar a la derecha. De igual forma debes doblar
a la derecha si te encuentras en el borde la matriz. Por lo tanto, el flujo de este
problema nos da como resultado que se recorrerá dicha matriz en forma de espiral
de acuerdo al sentido de las manecillas del reloj.

Para construir el proyecto, es necesario acceder a las propiedades de la mismo.

En la ventana de Propiedades, nos dirigimos a la sección "Packaging" o "Empaquetando".

Seleccionamos todas las casillas:
* Compress JAR File
*Build JAR after Compiling
*Copy Dependent Libraries

Después nos posicionamos sobre el proyecto de nuevo y seleccionamos "Clean and Build"

Una vez construido el proyecto, tendremos un archivo .JAR como el que se encuentra en la carpeta "Ejecutable", para asegurar que se ejecute; ejecutamos el archivo logic_test.cmd.

El programa al iniciar nos pide la cantidad de matrices a analizar o casos. Seguidamente, nos pide ingresar la cantidad de filas y columnas para cada matriz. Como último paso, el programa
despliega la ruta que se sigue según las especificaciones del programa y por último imprime
la orientación final de la ruta.

El algoritmo para crear este programa fue el siguiente:
Para la solución de éste problema pensé en una máquina de 4 estados. Donde el
primer estado es el viaje de izquierda a derecha (R), después el estado pasa a ser
el siguiente y entonces el viaje es de arriba a abajo (D), al terminar el viaje
pasa a ser de derecha a izquierda (L) y por último el viaje es de abajo a arriba
(U), repitiéndose esto hasta recorrer todos los elementos. De esta forma se puede
saber hacia donde terminó el viaje, esto conociendo el último estado de la máquina.
