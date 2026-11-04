# A2.1 · Análisis de una app de código abierto

## Objetivo: identificar en un proyecto real los componentes y clases que se han presentado en este tema.

### Cuántas Activities tiene y qué destinos de navegación (pantallas) contiene, siguiendo el enfoque moderno visto en clase.
Tabla 1: Activities

| Activity           | Fichero              |
|--------------------|----------------------|
| `.ui.MainActivity` | `ui/MainActivity.kt` |

Tabla 2: Destinos de navegación

| Destino   | Función que lo registra | Paquete        | 
|-----------|-------------------------|----------------|
| Home      | `homeEntry()`           | `ui.home`      |
| Post      | `postEntry()`           | `ui.post`      |
| Interests | `interestsEntry()`      | `ui.interests` |

### Si usa Services, Broadcast Receivers o Content Providers, y para qué.

| Componente         | ¿Lo usa? | Para qué                                                                   |
|--------------------|----------|----------------------------------------------------------------------------|
| Service            | No       | -                                                                          |
| Broadcast Receiver | Sí       | Recibe `APPWIDGET_UPDATE` para actualizar el widget de pantalla de inicio  |
| Content Provider   | No       | -                                                                          |

### Qué contiene su AndroidManifest.xml: componentes declarados, permisos solicitados, cuál es la actividad de arranque.
| Componentes declarados | 
|------------------------|
| Application            |
| Activity               | 
| Broadcast Receiver     | 

Permisos solicitados: Ninguno, no hay ninguna etiqueta uses-permission

| Actividad de arranque |
|-----------------------|
| `.ui.MainActivity`    |

### Cómo está organizada la estructura de paquetes. 
app/src/main/java/com/example/jetnews/
├── JetnewsApplication.kt   ← clase Application (declarada en el manifest)
├── data/                   ← capa de datos
│   ├── posts/              ← datos de los artículos
│   ├── interests/          ← datos de los intereses
│   ├── AppContainerImpl.kt ← contenedor que proporciona los repositorios
│   └── Result.kt           ← envoltorio para resultados (éxito/error)
├── model/                  ← modelos de dominio (Post, PostsFeed)
├── ui/                     ← capa de interfaz (Compose)
│   ├── MainActivity.kt     ← única Activity
│   ├── JetnewsApp.kt       ← composable raíz de la app
│   ├── JetnewsNavDisplay.kt← registro de destinos de navegación
│   ├── AppDrawer.kt        ← menú lateral
│   ├── home/               ← pantalla Home
│   ├── post/               ← pantalla Post (detalle)
│   ├── interests/          ← pantalla Interests
│   ├── navigation/         ← clases de navegación
│   ├── components/         ← composables reutilizables
│   ├── modifiers/          ← modificadores personalizados
│   ├── theme/              ← tema (colores, tipografía, formas)
│   └── utils/              ← utilidades de la UI
├── glance/                 ← widget de pantalla de inicio
├── deeplink/               ← gestión de enlaces profundos
└── utils/                  ← utilidades generales

El proyecto se organiza por capas (data, model, ui), y dentro de ui por funcionalidad, con un paquete
por pantalla (home, post, interests) y paquetes comunes para navegación, componentes y tema. 
Los widgets (glance) y los enlaces profundos (deeplink) tienen paquetes propios.
