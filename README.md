# ProyectoFinalPOO
# Sistema de gestión inmobiliaría
## Descripción del problema: 
Hoy en día, las agencias de finca raíz tienen muchos retos a la hora de organizar y manejar bien todas sus operaciones. Por ejemplo, deben gestionar muchas propiedades al mismo tiempo, llevar el control de la información de propietarios y clientes, y tener registrados todos los contratos de arriendo o venta. Además, necesitan ofrecer un servicio rápido, claro y cómodo tanto para los usuarios como para el personal de la agencia. Cuando no hay un sistema automatizado, todo esto se vuelve más complicado. Es difícil saber qué propiedades están disponibles, acceder a información actualizada, y los clientes no pueden buscar fácilmente lo que necesitan. También se pierde el control sobre los contratos, los pagos o cuándo se vencen. Por eso, proponemos desarrollar una aplicación que permita a la agencia tener un control completo de todo lo que maneja, haciendo que el trabajo interno sea más organizado y que la experiencia del usuario sea mucho mejor.

## Objetivo general: 

Desarrollar en un periodo de 3 semanas una aplicación orientada a objetos que permita gestionar propiedades, clientes y contratos en una agencia de finca raíz para mejorar la eficiencia y organización de la información.

## Objetivos específicos:
* Diseñar e implementar las clases principales y las secundarias y modelar las relaciones y la multiplicidad en un Diagrama de UML.  SEMANA 1 - SEMANA 2
Permitir el registro, consulta, edición y eliminación de propiedades. SEMANA 1 - SEMANA 2
* Implementar la funcionalidad para gestionar la información de propietarios y clientes (registro, consulta y edición). SEMANA 2
* Desarrollar la creación y gestión de contratos de compraventa o arriendo, incluyendo estado y condiciones, en un plazo máximo de 3 semanas. SEMANA 2 A SEMANA 3 
* Aplicar los principios de encapsulamiento, herencia y polimorfismo en la estructura del código durante toda la fase de implementación.
* Diseñar una interfaz funcional y sencilla que permita interactuar con el sistema. 

## REQUERIMIENTOS FUNCIONALES:

* RF1 - Registro de Propiedades:  El sistema debe permitir registrar nuevas propiedades, especificando atributos como tipo (casa, apartamento, local, etc.), ubicación, precio, área, número de habitaciones, número de baños, disponibilidad (venta/arriendo) y estado actual (disponible, reservado, vendido/arrendado). Es importante porque sin esta función no se podrán guardar las propiedades en el sistema. Permite tener toda la información organizada y lista para ser consultada o modificada después.
* RF2 - Visualización/Consulta General de propiedades: El sistema debe permitir ver el detalle completo de una propiedad específica seleccionada por el usuario. Sirve para que los usuarios puedan ver la información de las propiedades registradas. Esto es clave para saber qué hay disponible, qué propiedades no lo están.
* RF3 - Actualización de propiedades: El sistema debe permitir actualizar la información de una propiedad existente. Es útil porque las propiedades pueden cambiar de estado (por ejemplo, de disponible a vendida). Entonces, es necesario poder editar la información cuando algo cambie.
* RF4 - Eliminación de Propiedades: El sistema debe permitir eliminar una propiedad registrada en el sistema. Ayuda a mantener el sistema limpio y actualizado. Si una propiedad ya no se maneja en la agencia, se puede quitar fácilmente.
* RF5 - Registro de Propietarios y Clientes: El sistema debe permitir registrar propietarios y clientes, almacenando información como nombre, identificación, teléfono, correo electrónico, presupuesto y dirección. Permite guardar los datos de las personas que venden o buscan propiedades.
* RF6 - Visualización/Consulta General de propietarios y clientes: El sistema debe permitir ver el detalle completo de los atributos asignados tanto a los propietarios como a los clientes. Permite ver los datos guardados de propietarios y clientes, lo cual es útil para encontrar alguna propiedad que encaje con sus datos.
* RF7 - Actualización de propietarios y clientes: El sistema debe permitir actualizar la información de un propietario o cliente existente, por ejemplo, cambiar el presupuesto o en caso de ser propietario, actualizar cuantas propiedades tiene a su nombre. Es importante porque permite mantener todo actualizado.
* RF8 - Eliminación de propietarios y clientes: El sistema debe permitir eliminar un propietario o un cliente registrado en el sistema, esto, en caso de que consigan otra agencia de finca raíz o simplemente no les interese vender o comprar propiedades. Esta función permite eliminar los datos innecesarios.
* RF9 - Creación de Contratos: El sistema debe permitir generar contratos entre un propietario y un cliente, registrando detalles como tipo (arriendo o venta), fecha de inicio, duración (en caso de arriendo), monto pactado, condiciones especiales y estado del contrato (activo, finalizado, cancelado). Es esencial para formalizar acuerdos entre propietarios y clientes. Sirve para tener un registro claro y organizado de ventas o arriendos.
* RF10 - Búsqueda de Propiedades: El sistema debe permitir que los clientes realicen búsquedas de propiedades filtrando por tipo, ubicación, precio máximo y número de habitaciones. Esta función es muy útil para los clientes, ya que les permite encontrar propiedades según lo que necesitan, como tipo, ubicación, habitaciones o precio. 
