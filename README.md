
# Marco de Trabajo para Sistema de gestión inmobiliaria: Documentación Completa
## Descripción del problema: 
Hoy en día, las agencias de finca raíz tienen muchos retos a la hora de organizar y manejar bien todas sus operaciones. Por ejemplo, deben gestionar muchas propiedades al mismo tiempo, llevar el control de la información de propietarios y clientes, y tener registrados todos los contratos de arriendo o venta. Además, necesitan ofrecer un servicio rápido, claro y cómodo tanto para los usuarios como para el personal de la agencia. Cuando no hay un sistema automatizado, todo esto se vuelve más complicado. Es difícil saber qué propiedades están disponibles, acceder a información actualizada, y los clientes no pueden buscar fácilmente lo que necesitan. También se pierde el control sobre los contratos, los pagos o cuándo se vencen. Por eso, proponemos desarrollar una aplicación que permita a la agencia tener un control completo de todo lo que maneja, haciendo que el trabajo interno sea más organizado y que la experiencia del usuario sea mucho mejor.

## Objetivo del proyecto: 

Desarrollar en un periodo de 3 semanas una aplicación orientada a objetos que permita gestionar propiedades, clientes y contratos en una agencia de finca raíz para mejorar la eficiencia y organización de la información.

## Objetivos principales:
* Diseñar e implementar las clases principales y las secundarias y modelar las relaciones y la multiplicidad en un Diagrama de UML.  SEMANA 1 - SEMANA 2
Permitir el registro, consulta, edición y eliminación de propiedades. SEMANA 1 - SEMANA 2
* Implementar la funcionalidad para gestionar la información de propietarios y clientes (registro, consulta y edición). SEMANA 2
* Desarrollar la creación y gestión de contratos de compraventa o arriendo, incluyendo estado y condiciones, en un plazo máximo de 3 semanas. SEMANA 2 A SEMANA 3 
* Aplicar los principios de encapsulamiento, herencia y polimorfismo en la estructura del código durante toda la fase de implementación.
* Diseñar una interfaz funcional y sencilla que permita interactuar con el sistema.

## Problemas a solucionar: 
El sistema de gestión inmobiliaria enfrenta varios desafíos que este marco de trabajo aborda: 
1. Desorganización en la gestión de propiedades: las agencias manejan muchas propiedades y sin un sistema, es difícil tener control sobre cuál está disponible, arrendada o vendida.
2. Dificultad para buscar propiedades adecuadas: los clientes tienen que revisar muchas opciones sin filtros adecuados.
3. Gestión manual de propietarios y clientes: las agencias suelen guardar datos en archivos sueltos o papel, lo que lleva a errores o pérdida de información.
4. Falta de trazabilidad de contratos: No hay seguimiento claro de contratos de arriendo o venta, sus fechas, duración o estados.
5. Ineficiencia en el proceso de atención al cliente: sin automatización, responder dudas o actualizar información toma más tiempo.

## REQUERIMIENTOS FUNCIONALES:

## GESTIÓN DE PROPIEDADES
RF1 - Registro de Propiedades
Permite registrar nuevas propiedades con datos como tipo, ubicación, precio, área, habitaciones, baños, disponibilidad y estado. Clave para tener un inventario completo desde el inicio.

RF2 - Consulta de Propiedades
Permite visualizar el detalle completo de una propiedad seleccionada. Útil para conocer la disponibilidad y características.

RF3 - Actualización de Propiedades
Permite modificar los datos de una propiedad ya registrada. Importante cuando cambia el estado o la información.

RF4 - Eliminación de Propiedades
Permite eliminar propiedades que ya no se gestionen en la agencia. Mantiene el sistema actualizado y limpio.

RF5 - Búsqueda de Propiedades
Permite filtrar propiedades por tipo, ubicación, precio y número de habitaciones. Ayuda a los clientes a encontrar justo lo que buscan.

## GESTIÓN DE PROPIETARIOS Y CLIENTES
RF6 - Registro de Propietarios y Clientes
Permite registrar sus datos personales como nombre, ID, contacto, dirección, presupuesto, etc. Esencial para relacionarlos con propiedades y contratos.

RF7 - Consulta de Propietarios y Clientes
Permite visualizar los datos completos de los propietarios y clientes. Facilita el acceso rápido a la información.

RF8 - Actualización de Propietarios y Clientes
Permite editar información como presupuesto o número de propiedades. Importante para tener siempre datos actuales.

RF9 - Eliminación de Propietarios y Clientes
Permite borrar registros cuando ya no se usen o si deciden no continuar. Evita saturar el sistema con datos innecesarios.

## GESTIÓN DE CONTRATOS
RF10 - Creación de Contratos
Permite generar contratos entre propietario y cliente, incluyendo tipo, fechas, duración, monto, condiciones y estado. Formaliza el acuerdo entre las partes con trazabilidad.

## ARQUITECTURA Y DECISIONES DE DISEÑO 

## JERARQUÍA DE CLASES 

La arquitectura se basa en una jerarquía de clases cuidadosamente diseñada: 

Persona (clase base) -> Propiedad (clase abstracta) y Contratobase (clase abstracta). 
Persona (clase base) -> Propietario y Cliente (clases hijas). 
Propiedad (clase abstracta) -> Apartamento, Casa, Lote, Oficina (clases hijas). 
Contratobase (clase abstracta) -> ContratoCompra, Contratoventa, ContratoArriendo (clases hijas). 

## JUSTIFICACIÓN DE DISEÑO: 

## Clase Base Concreta (Persona)

Se definió como una clase base concreta porque tanto propietarios como clientes comparten atributos y comportamientos comunes, como identificación, nombre, teléfono y correo. Al hacerla concreta: Se evita duplicación de código, se permite instanciar personas genéricas si fuese necesario y facilita el uso de herencia para extender funcionalidad en clases específicas.

## Clases Concretas Derivadas (Propietario, Cliente)

Estas clases heredan de Persona y encapsulan comportamientos o atributos específicos.
- Propietario puede tener una lista de propiedades asociadas.
- Cliente puede tener un presupuesto y preferencias de búsqueda.
- Permite aplicar **polimorfismo** y tratamiento diferenciado según el rol de la persona.

## Clase Abstracta Intermedia (Propiedad)

Se diseñó como una clase abstracta ya que representa un concepto general de propiedad inmobiliaria, pero no se pretende crear instancias directamente.
- Encapsula atributos comunes como dirección, precio, área, número de habitaciones/baños y estado.
- Define métodos abstractos (por ejemplo, calcular impuestos o mostrar detalles).
- Obliga a las subclases (Apartamento, Casa, Lote, Oficina) a implementar comportamiento específico.
- 
## Clases Concretas Finales (Apartamento, Casa, Lote, Oficina)

Estas representan tipos reales de propiedades con atributos o reglas particulares (por ejemplo, administración en apartamentos, área construida en casas, etc.).
- Favorecen la extensibilidad si se agregan más tipos en el futuro.
- Permiten especializar comportamiento sin romper la jerarquía general.

## Clase Abstracta Intermedia (ContratoBase)

Define una estructura genérica para los contratos sin representar ningún contrato real.
- Contiene atributos comunes (ID, tipo, duración, monto, estado).
- Define métodos abstractos como validarContrato() o calcularMontoFinal().
- Establece una plantilla común obligando a las subclases a definir su comportamiento específico.

## Clases Concretas Finales (ContratoCompra, ContratoVenta, ContratoArriendo)

Estas clases concretas heredan de ContratoBase e implementan la lógica y atributos específicos de cada tipo de contrato.
- Cada tipo de contrato tiene reglas y datos distintos (por ejemplo, duración solo aplica a arriendo).
- Permite encapsular validaciones propias y controlar el estado de los contratos según su naturaleza.

Esta arquitectura favorece la reusabilidad, cohesión y el uso correcto de la herencia y el polimorfismo, haciendo el sistema escalable y mantenible.

## INTERFACES: 

El diseño incluye 4 interfaces principales: 

**ICliente:** Define el contrato para los objetos que representan el comportamiento esperado de un cliente dentro del sistema. Esta interfaz garantiza que cualquier clase que actúe como cliente implemente operaciones básicas relacionadas con su perfil.

- Acceso y modificación de información personal (nombre, contacto, identificación).
- Definición de métodos para gestionar preferencias de búsqueda (presupuesto, tipo de propiedad, ubicación).
- Métodos para interactuar con el sistema de búsqueda o contratación.
- Permite desacoplar el sistema de las implementaciones concretas de cliente, facilitando pruebas y cambios sin afectar el núcleo de la lógica.

**IContrato:** Establece el contrato que deben cumplir todos los tipos de contrato (compra, venta, arriendo). Esta interfaz permite garantizar consistencia en el tratamiento de contratos, independientemente de su tipo.

- Métodos para establecer y consultar fechas, montos, duración y estado.
- Funcionalidad para validar los términos del contrato.
- Posibilidad de calcular valores derivados (como el monto final).
- Estado del contrato (activo, finalizado, cancelado).
- Permite tratar contratos de forma polimórfica, facilitando operaciones genéricas sobre ellos.

**IDAO (Data Access Object)**: Define un conjunto de operaciones genéricas para acceder y manipular datos en la base (CRUD). Esta interfaz es clave para separar la lógica de negocio del acceso a datos.

- Métodos para crear, leer, actualizar y eliminar entidades del sistema.
- Posibilidad de buscar por criterios específicos.
- Mejora la mantenibilidad y permite cambiar la tecnología de persistencia sin afectar la lógica del sistema.

**IRepositorio**: Define operaciones más especializadas y de más alto nivel sobre conjuntos de entidades. Funciona como una capa adicional sobre los DAOs que encapsula reglas de negocio específicas.

- Métodos para obtener entidades filtradas según criterios del negocio.
- Gestión de asociaciones entre entidades (por ejemplo, clientes y propiedades favoritas).
- Métodos personalizados que no encajan en el CRUD básico.
- Mejora la organización del acceso a datos y la cohesión del sistema al separar la persistencia genérica de las consultas orientadas al dominio.

## RELACIONES ENTRE OBJETOS: 
El diseño del sistema implementa diversos tipos de relaciones orientadas a objetos, lo que permite una arquitectura flexible, modular y coherente con los principios de diseño orientado a objetos:

**Herencia** Relación "es un" establecida entre las clases base y sus respectivas subclases:
- Persona → Cliente y Propietario: Ambos heredan atributos y métodos comunes como nombre, identificación, contacto, etc.
- Propiedad (abstracta) → Casa, Apartamento, Lote, Oficina: Representa distintas categorías de inmuebles, todos con características en común.
- ContratoBase (abstracta) → ContratoCompra, ContratoVenta, ContratoArriendo: Permite tratar distintos contratos bajo un mismo marco común.
Esta relación permite reutilizar código común, establecer polimorfismo y mantener cohesión entre entidades del mismo tipo.

**Implementación**: Relación entre clases concretas e interfaces que definen contratos funcionales:

- Cliente implementa ICliente
- ContratoCompra, ContratoVenta, ContratoArriendo implementan IContrato
- Clases DAO concretas implementan IDAO
- Clases de acceso de negocio implementan IRepositorio
Estas relaciones garantizan que las clases cumplan con ciertos comportamientos definidos.

**Asociación**: Relación entre objetos que colaboran entre sí pero pueden existir de forma independiente:

- Propietario ↔ Propiedad: Un propietario puede tener varias propiedades, y una propiedad pertenece a un propietario. Sin embargo, ambos pueden existir por separado.
- Cliente ↔ ContratoBase: Un cliente puede participar en varios contratos, y un contrato está asociado a un cliente.
Estas relaciones reflejan interacciones del mundo real y permiten el mantenimiento independiente de los objetos.

**Agregación**:  Relación entre clases donde una clase contiene referencias a otra, pero las instancias pueden existir de manera independiente:

- Propiedad ◇─ ContratoBase: Una propiedad puede estar asociada a múltiples contratos a lo largo del tiempo (venta, arriendo), pero los contratos no dependen vitalmente de la propiedad.
- Propietario ◇─ Propiedad: Aunque un propietario puede ser dueño de varias propiedades, estas pueden ser reasignadas o continuar existiendo sin ese propietario.
La agregación ayuda a modelar relaciones de "tiene un" sin dependencia de ciclo de vida.

**Composición**: Relación fuerte de dependencia entre objetos, donde el ciclo de vida de uno depende del otro:
- Propiedad ▣─ ContratoBase: Cada contrato (compra, venta o arriendo) está completamente ligado a una propiedad específica. Si una propiedad se elimina del sistema, sus contratos asociados también dejan de existir.
Esta relación modela que los contratos no tienen sentido por sí solos, sino únicamente como parte de la gestión de una propiedad.









































