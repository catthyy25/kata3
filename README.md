# Objetivo de la entrega
El objetivo de esta entrega es practicar el uso de un WebService desde Java: realizar una petición HTTP a una API (RandomUser) con el `HttpClient` del JDK, obtener la respuesta en formato JSON y deserializarla 
con Gson a entidades de dominio propias. Además, se aplica una arquitectura hexagonal sencilla (modelo, puertos y adaptadores) para que la aplicación no dependa del formato concreto de la API, separando la lógica 
del programa de los orígenes de datos.

# Cómo compilar y ejecutar
El proyecto se gestiona con Maven. Para compilarlo y ejecutarlo basta con abrirlo en IntelliJ IDEA, dejar que Maven descargue las dependencias (Gson) y usar la opción Run sobre la clase principal `Main`. 
Es necesaria una conexión a Internet, ya que los datos se piden en `https://randomuser.me/api?results=10`.

# Dependencias y versiones de JDK
- **Gestor de dependencias:** Maven.
- **JDK:** 26.
- **Librerías:** Gson 2.14.0 (`com.google.code.gson:gson`), usada para deserializar el JSON de la API.
- **Cliente HTTP:** `java.net.http.HttpClient` (incluido en el JDK).

## Estructura de la entrega y clases principales
```
kata3/
├── pom.xml
├── .gitignore
├── README.md
└── src/
    └── main/
        └── java/
            └── software/
                └── ulpgc/
                    └── katas/
                        ├── Main.java                          # Código principal: petición HTTP, deserialización e impresión de usuarios
                        ├── adapters/
                        │   ├── JsonRandomUserDeserializer.java # Adaptador: implementa el puerto y convierte el JSON de RandomUser en User con Gson
                        │   └── dtos/
                        │       └── UserDto.java                # DTO que replica la estructura del JSON de RandomUser
                        ├── model/
                        │   ├── User.java                       # Record con nombre, género y fecha de nacimiento
                        │   └── Gender.java                     # Enumerado de género (male, female)
                        └── ports/
                            └── UserDeserializer.java           # Puerto: contrato "texto -> lista de User"
```

## Descripción de la arquitectura
- **model:** clases que representan la realidad de mi aplicación (`User`, `Gender`). No conocen la API.
- **ports:** lo que necesita mi aplicación. `UserDeserializer` define que, dado un texto, se devuelve una lista de `User`, sin decir cómo.
- **adapters:** implementaciones que hablan con el exterior. `JsonRandomUserDeserializer` es el único que sabe que los datos vienen de RandomUser en JSON y que usa Gson. Si la API cambia, solo hay que modificar esta capa.
- **dtos:** `UserDto` es un objeto pensado para ser deserializado; copia el formato de la API y se transforma después al modelo propio.

## Flujo de Git usado
El flujo de trabajo seguido en el repositorio incluye:
1. Creación del proyecto y configuración inicial (`pom.xml` con groupId `software.ulpgc`, `.gitignore`).
2. Creación de la rama **develop** para desarrollar la kata paso a paso mediante commits.
3. **Merge** de `develop` a `master` una vez terminada la kata.
4. Creación del `README.md` sobre `master`.
5. **Push** de todos los commits y ramas al repositorio remoto en GitHub.

# Commits principales en `develop`:
1. `Project created.`
2. `HttpClient and request created.`
3. `HttpResponse to get body created.`
4. `Dependencies added.`
5. `Gson parsing created to get first gender.`
6. `UserDto class with full JSON structure created.`
7. `Loop to read results with Gson created.`
8. `User record class and Gender enum class created.`
9. `UserDeserializer interface created.`
10. `JsonRandomUserDeserializer class created.`

# Ramas del repositorio:
- `master`: versión final integrada de la kata.
- `develop`: desarrollo paso a paso de la kata.
- `develop1 y develop2`: repeticiones de la kata.

## Cómo clonar y comprobar que compila
Para comprobar que el proyecto compila y funciona fuera de la carpeta original:
1. Abrir IntelliJ IDEA.
2. En la pantalla de inicio, seleccionar **Clone Repository**.
3. Pegar la URL del repositorio (`https://github.com/catthyy25/kata3`) y cambiar la carpeta de destino.
4. Una vez clonado, esperar a que Maven descargue Gson, ejecutar `Main` con **Run** y comprobar que compila sin errores y produce una salida equivalente a la de la versión original (los usuarios cambian en cada ejecución porque son aleatorios).

## Evidencias de verificación y pruebas
- Se comprobó que el proyecto compila correctamente con Maven sin errores y que la dependencia de Gson se descarga al recargar el proyecto.
- Se ejecutó `Main` tras cada paso: primero imprimiendo el JSON completo recibido, después leyendo el género del primer usuario y finalmente recorriendo los diez resultados.
- Se verificó que el `UserDto` refleja la estructura del JSON de RandomUser y que la deserialización con Gson funciona para los diez usuarios.
- Se comprobó que `JsonRandomUserDeserializer` transforma correctamente cada `UserDto` en un `User` del modelo propio (nombre completo, género y fecha de nacimiento).
- Se clonó el repositorio en una carpeta distinta a la original y se repitieron la compilación y la ejecución, confirmando que el resultado es equivalente.
- Se revisó el historial de commits en GitHub para confirmar que las ramas (`master`, `develop`) están correctamente subidas al remoto.

A continuación se muestra la consola tras ejecutar `Main`, confirmando que el programa finaliza correctamente (exit code 0) y que se imprimen los diez usuarios obtenidos de la API con el formato del modelo propio:

<img width="350" height="133" alt="image" src="https://github.com/user-attachments/assets/2b7f9f4e-43d5-4cdf-a149-7189a5f83303" />

## Atajos de teclado utilizados
Durante el desarrollo de la kata se utilizaron los siguientes atajos de IntelliJ IDEA:

| Atajo | Uso |
|---|---|
| `Alt + Enter` | Mostrar acciones rápidas del IDE: importar clases, añadir excepciones a la firma del método (`throws`), introducir variables locales y crear automáticamente métodos o clases a partir de su uso. |
| `Alt + Ins` | Crear un nuevo *package*, una nueva clase Java o un nuevo archivo (p. ej. `README.md`). |
| `Tab` | Ajustar el nombre de los parámetros al crear un método con `Alt + Enter`. |
| `Control + K` | Abrir la ventana de commit para escribir el mensaje del commit. |
| `Control + Enter` | Confirmar y realizar el commit. |
| `Alt + 9` | Abrir la ventana de Git para ver ramas y commits. |

## Vídeo explicativo
- **Enlace en YouTube:** (añadir enlace)
- **Enlace en Drive:** (añadir enlace)
