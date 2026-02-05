# NiceStrat

Aplicación Android desarrollada en *Java* con *Android Studio* como parte de un proyecto académico.  
El objetivo principal es practicar el flujo de autenticación de un usuario (login / registro), la navegación entre pantallas y la implementación de funcionalidades modernas como el *modo noche* y una *barra de navegación inferior (Bottom Bar)*.

---

## 📸 Capturas de Pantalla

A continuación, se presentan algunas capturas de pantalla de como se verían las pantallas principales de la aplicación:

### Registro
Pantalla de registro de nuevos usuarios  
![Registrar](img/foto1.png)

### Inicio de Sesión
Pantalla de inicio de sesión de la aplicación  
![Login](img/foto2.png)

### Vista Principal
Pantalla principal de la aplicación tras iniciar sesión  
![Main](img/foto3.png)

### Pantalla de Carga
Pantalla de carga mostrada al iniciar la aplicación  
![Splash](img/foto4.png)

---

## 📱 Funcionalidades

### 🔐 Autenticación

- *Pantalla de inicio de sesión (Login)*
    - Campos de usuario y contraseña.
    - Botón para iniciar sesión.
    - Acceso directo a la pantalla de registro.

- *Pantalla de registro (Sign Up)*
    - Campos de usuario, email, contraseña y confirmación de contraseña.
    - Botón para crear una nueva cuenta.
    - Opción para cancelar y volver al login.

---

### 🧭 Navegación principal (Bottom Bar)

- Implementación de una *barra de navegación inferior (Bottom Bar)*.
- Permite cambiar entre las distintas secciones principales de la aplicación de forma rápida e intuitiva.
- La Bottom Bar se mantiene visible en la pantalla principal para mejorar la experiencia de usuario y la navegación.

---

### 🌙 Modo Noche (Dark Mode)

- Implementación de *modo noche* utilizando el sistema de temas Day/Night de Android.
- Posibilidad de activar o desactivar el modo noche desde la aplicación.
- La preferencia del usuario se guarda y se mantiene incluso al cerrar y volver a abrir la app.
- Mejora la accesibilidad y la comodidad visual en entornos con poca luz.

---

## 🛠 Tecnologías utilizadas

- *Lenguaje:* Java
- *Entorno de desarrollo:* Android Studio
- *SDK:* Android SDK
- *Sistema de construcción:* Gradle
- *Diseño UI:* XML
- *Componentes:* Material Design (Bottom Navigation, temas Day/Night)

---

## ✅ Requisitos del programa

Para compilar y ejecutar el proyecto es necesario:

- *JDK 11 o superior*
- *Android Studio*
- Emulador de Android o dispositivo físico compatible

---

## 📂 Estructura del proyecto

La estructura principal del proyecto es la siguiente:

- app/src/main/java/
    - Login.java – Lógica de la pantalla de inicio de sesión.
    - SingUp.java – Lógica de la pantalla de registro.
    - MainActivity.java – Pantalla principal con Bottom Bar.
    - (Clases adicionales para gestión de tema y navegación)

- app/src/main/res/layout/
    - activity_login.xml – Diseño de la pantalla de login.
    - activity_sing_up.xml – Diseño de la pantalla de registro.
    - activity_main.xml – Diseño de la pantalla principal con Bottom Bar.

- app/src/main/res/menu/
    - Menú de navegación inferior (Bottom Bar).

- app/src/main/res/values/
    - Archivos de colores y temas (modo claro).

- app/src/main/res/values-night/
    - Archivos de temas para modo noche.

- app/src/main/AndroidManifest.xml – Configuración de actividades y permisos.

- img/
    - Capturas de pantalla de la aplicación.

---






