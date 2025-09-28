# Escenario 1 — Personalizacion de Automóvil 

<h2>Identificación Patron de Diseño</h2>

<ul>
  <li><b>Tipo de patrón:</b> Creacional</li>
  <li><b>Patrón seleccionado:</b> Builder</li>
</ul>

<h3>Justificación</h3>

<p>
El problema describe un objeto complejo, un automovil con diversas configuraciones, las cuales son personalizadas por el cliente de manera opcional.
Asi mismo estas configuraciones son objetos complejos con sus propios estados y comportamientos por lo que la creacion de un automovil requiere una inicializacion ardua,
de sus multiples componentes manualmente. Para mejorar esta situacion el patron BUILDER nos permite crear un automovil paso a paso con valores opcionales.
</p>

---

<h2>Beneficios esperados</h2>

<div style="border-left:4px solid #3498db; padding:10px 15px; background:#ecf6fc; margin:20px 0;">
  <ul>
    <li><b>Legibilidad y claridad:</b> Facilita la creación de objetos complejos con muchos parámetros sin necesidad de múltiples constructores.</li>
    <li><b>Inmutabilidad:</b> Una vez creado el objeto, sus propiedades no se pueden modificar.</li>
    <li><b>Flexibilidad:</b> Permite omitir atributos opcionales sin necesidad de crear subclases.</li>
    <li><b>Separación de construcción y representación:</b> Separa la lógica de construcción del objeto, facilitando modificaciones futuras.</li>
  </ul>
</div>

---

# Diagrama Mermaid - Proyecto co.edu.unisabana.car

```mermaid
classDiagram
    %% Interfaz Builder
    class IBuilder~T~ {
        <<interface>>
        +build() T
    }

    %% Clase principal Car
    class Car {
        -ColorType color
        -String brand
        -String model
        -RoofType roofType
        -Tire tire
        -Engine engine
        -SoundSystem sound
        -GPS gpsNavigation
        #Car(CarBuilder builder)
        +getColor() ColorType
        +getBrand() String
        +getModel() String
        +getRoofType() RoofType
        +getTire() Tire
        +getEngine() Engine
        +getSound() SoundSystem
        +getGpsNavigation() GPS
        +equals(Object) boolean
        +hashCode() int
        +toString() String
    }

    %% Builder concreto
    class CarBuilder {
        #ColorType color
        #String brand
        #String model
        #RoofType roofType
        #Tire tire
        #Engine engine
        #SoundSystem sound
        #GPS GPS
        +builder(ColorType color)$ CarBuilder
        +build() Car
        -CarBuilder(ColorType color)
        +brand(String val) CarBuilder
        +model(String val) CarBuilder
        +roof(RoofType val) CarBuilder
        +tire(TiresType val) CarBuilder
        +engine(EngineType val) CarBuilder
        +sound(SoundSystemType val) CarBuilder
        +gpsNavigation(NavigationType val) CarBuilder
    }

    %% Componentes del Car
    class Engine {
        -String engineType
        -String fuelType
        -int horsePower
        -int torque
        -BigDecimal price
        +Engine(EngineType engineType)
        +getEngineType() String
        +getFuelType() String
        +getHorsePower() int
        +getTorque() int
        +getPrice() BigDecimal
        +toString() String
    }

    class Tire {
        -String rin
        -String tractionGrade
        -String temperatureGrade
        -int speedRating
        +Tire(TiresType type)
        +getRin() String
        +getTractionGrade() String
        +getTemperatureGrade() String
        +getSpeedRating() int
        +toString() String
    }

    class SoundSystem {
        -String brand
        -String model
        -boolean bluetoothEnabled
        -boolean touchScreenEnabled
        +SoundSystem(SoundSystemType soundSystemType)
        +getBrand() String
        +getModel() String
        +isBluetoothEnabled() boolean
        +isTouchScreenEnabled() boolean
        +toString() String
    }

    class GPS {
        -String brand
        -String model
        +GPS(NavigationType navigationType)
        +getBrand() String
        +getModel() String
        +toString() String
    }

    %% Enums
    class ColorType {
        <<enumeration>>
        ROJO
        NEGRO
        BLANCO
        AZUL
        GRIS
        PLATEADO
    }

    class RoofType {
        <<enumeration>>
        SIN_TECHO
        TECHO_SOLAR
        PANORAMICO
    }

    class EngineType {
        <<enumeration>>
        G_V6
        G_V8
        DIESEL
        HIBRIDO
        ELECTRICO
        -String engineType
        -String fuelType
        -int hosePower
        -int torque
        -BigDecimal price
        +getEngineType() String
        +getFuelType() String
        +getHosePower() int
        +getTorque() int
        +getPrice() BigDecimal
    }

    class TiresType {
        <<enumeration>>
        ESTANDAR_17
        DEPORTIVA_19
        OFFROAD_20
        -String rin
        -String tractionGrade
        -String temperatureGrade
        -int speedRating
        +getRin() String
        +getTractionGrade() String
        +getTemperatureGrade() String
        +getSpeedRating() int
    }

    class SoundSystemType {
        <<enumeration>>
        BASICO
        PREMIUM
        SURROUND
        -String brand
        -String model
        -boolean bluetoothEnabled
        -boolean touchScreenEnabled
        +getBrand() String
        +getModel() String
        +isBluetoothEnabled() boolean
        +isTouchScreenEnabled() boolean
    }

    class NavigationType {
        <<enumeration>>
        BASICO
        AVANZADO
        MULTIMEDIA
        -String brand
        -String model
        +getBrand() String
        +getModel() String
    }

    %% Relaciones
    IBuilder~T~ <|.. CarBuilder : implements
    CarBuilder --> Car : builds
    Car *-- Engine : composition
    Car *-- Tire : composition
    Car *-- SoundSystem : composition
    Car *-- GPS : composition
    Car --> ColorType : uses
    Car --> RoofType : uses
    Engine --> EngineType : uses
    Tire --> TiresType : uses
    SoundSystem --> SoundSystemType : uses
    GPS --> NavigationType : uses
```

# Escenario 3 — Chat Room

<h2>Identificación Patron de Diseño</h2>

<ul>
  <li><b>Tipo de patrón:</b> Comportamiento</li>
  <li><b>Patrón seleccionado:</b> Mediator</li>
</ul>

<h3>Justificación</h3>

<p>
El problema describe una comunicacion e interaccion entre multiples componentes, sin embargo sin un mediador cada usuario debera conocer las demas referencias de los participantes en un chat para poder
comunicarse con ellos, lo que genera un alto acoplamiento, sin embargo al usar el patron mediador permite centralizar toda la logica de comuniacion y permte agregar o remover usuarios facilmente.
</p>

---

<h2>Beneficios esperados</h2>

<div style="border-left:4px solid #3498db; padding:10px 15px; background:#ecf6fc; margin:20px 0;">
  <ul>
    <li><b>Facilita el mantenimiento:</b> Agregar o eliminar usuarios no debe requerir modificar los demás.</li>
    <li><b>Mejor organización:</b> Una vez creado el objeto, sus propiedades no se pueden modificar.</li>
    <li><b>Flexibilidad:</b> La lógica de comunicación debe estar centralizada, no dispersa en muchos objetos.</li>
    <li><b>Reduce la complejidad:</b> Evitar una red enmarañada de interacciones punto a punto.</li>
  </ul>
</div>

---

# Diagrama Mermaid - Proyecto co.edu.unisabana.chatRoom

```mermaid
classDiagram
    %% Interfaz Mediator
    class IMessageHandler {
        <<interface>>
        +sendMessageToUser(String sender, String receiver, String message)
        +sendMessageToAll(String sender, String message)
        +addUser(ICommunicator user)
        +removeUser(String userName)
    }

    %% Interfaz Colleague
    class ICommunicator {
        <<interface>>
        +receiveMessage(String sender, String message)
        +getName() String
    }

    %% Mediator concreto
    class ChatRoomHandler {
        -Map~String, ICommunicator~ users
        +sendMessageToUser(String sender, String receiver, String message)
        +sendMessageToAll(String sender, String message)
        +addUser(ICommunicator user)
        +removeUser(String userName)
    }

    %% Colleague concreto
    class User {
        -String name
        -IMessageHandler chatRoom
        +User(String name, IMessageHandler chatRoom)
        +receiveMessage(String sender, String message)
        +sendMessageToAll(String message)
        +sendMessageToUser(String receiver, String message)
        +getName() String
    }

    %% Relaciones del patrón Mediator
    IMessageHandler <|.. ChatRoomHandler : implements
    ICommunicator <|.. User : implements
    User --> IMessageHandler : uses
    ChatRoomHandler --> ICommunicator : manages
    
    %% Notas del patrón
    note for ChatRoomHandler "Mediator concreto:\nCentraliza la comunicación\nentre usuarios"
    note for User "Colleague concreto:\nSe comunica a través\ndel mediator"
```