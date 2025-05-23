
# Marco de Trabajo para Sistema de gestión inmobiliaria: Documentación Completa

## 1. PRESENTACIÓN DEL EQUIPO: 

**1. CATALINA SANDOVAL**

ROLES:
- DAOs Y CLASES DE SERVCICIO
- INTEGRAR Y VALIDAR EL FUNCIONAMIENTO DEL CÓDIGO

**2. MARIANA CUADROS**

ROLES:
- REQUERIMIENTOS FUNCIONALES 6-10
- DOCUMENTACIÓN COMPLETA

**3. THOMAS GOMEZ**

ROLES:
- REQUERIMIENTOS FUNCIONALES 1-5

**4. DAVID MURCIA**

ROLES:
- MANEJO DE EXCEPCIONES

## 2. DESCRIPCIÓN DEL PROBLEMA: 
Hoy en día, las agencias de finca raíz tienen muchos retos a la hora de organizar y manejar bien todas sus operaciones. Por ejemplo, deben gestionar muchas propiedades al mismo tiempo, llevar el control de la información de propietarios y clientes, y tener registrados todos los contratos de arriendo o venta. Además, necesitan ofrecer un servicio rápido, claro y cómodo tanto para los usuarios como para el personal de la agencia. Cuando no hay un sistema automatizado, todo esto se vuelve más complicado. Es difícil saber qué propiedades están disponibles, acceder a información actualizada, y los clientes no pueden buscar fácilmente lo que necesitan. También se pierde el control sobre los contratos, los pagos o cuándo se vencen. Por eso, proponemos desarrollar una aplicación que permita a la agencia tener un control completo de todo lo que maneja, haciendo que el trabajo interno sea más organizado y que la experiencia del usuario sea mucho mejor.

## 3. OBJETIVO DEL PROYECTO: 

Desarrollar en un periodo de 3 semanas una aplicación orientada a objetos que permita gestionar propiedades, clientes y contratos en una agencia de finca raíz para mejorar la eficiencia y organización de la información.

## 3.1 OBJETIVOS PRINCIPALES:
* Diseñar e implementar las clases principales y las secundarias y modelar las relaciones y la multiplicidad en un Diagrama de UML.  SEMANA 1 - SEMANA 2
Permitir el registro, consulta, edición y eliminación de propiedades. SEMANA 1 - SEMANA 2
* Implementar la funcionalidad para gestionar la información de propietarios y clientes (registro, consulta y edición). SEMANA 2
* Desarrollar la creación y gestión de contratos de compraventa o arriendo, incluyendo estado y condiciones, en un plazo máximo de 3 semanas. SEMANA 2 A SEMANA 3 
* Aplicar los principios de encapsulamiento, herencia y polimorfismo en la estructura del código durante toda la fase de implementación.
* Diseñar una interfaz funcional y sencilla que permita interactuar con el sistema.

## 4. PROBLEMAS A SOLUCIONAR: 
El sistema de gestión inmobiliaria enfrenta varios desafíos que este marco de trabajo aborda: 
1. Desorganización en la gestión de propiedades: las agencias manejan muchas propiedades y sin un sistema, es difícil tener control sobre cuál está disponible, arrendada o vendida.
2. Dificultad para buscar propiedades adecuadas: los clientes tienen que revisar muchas opciones sin filtros adecuados.
3. Gestión manual de propietarios y clientes: las agencias suelen guardar datos en archivos sueltos o papel, lo que lleva a errores o pérdida de información.
4. Falta de trazabilidad de contratos: No hay seguimiento claro de contratos de arriendo o venta, sus fechas, duración o estados.
5. Ineficiencia en el proceso de atención al cliente: sin automatización, responder dudas o actualizar información toma más tiempo.

## 5. REQUERIMIENTOS FUNCIONALES:

**5.1 GESTIÓN DE PROPIEDADES**

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

**5.2 GESTIÓN DE PROPIETARIOS Y CLIENTES**

RF6 - Registro de Propietarios y Clientes
Permite registrar sus datos personales como nombre, ID, contacto, dirección, presupuesto, etc. Esencial para relacionarlos con propiedades y contratos.

RF7 - Consulta de Propietarios y Clientes
Permite visualizar los datos completos de los propietarios y clientes. Facilita el acceso rápido a la información.

RF8 - Actualización de Propietarios y Clientes
Permite editar información como presupuesto o número de propiedades. Importante para tener siempre datos actuales.

RF9 - Eliminación de Propietarios y Clientes
Permite borrar registros cuando ya no se usen o si deciden no continuar. Evita saturar el sistema con datos innecesarios.

**5.3 GESTIÓN DE CONTRATOS**

RF10 - Creación de Contratos
Permite generar contratos entre propietario y cliente, incluyendo tipo, fechas, duración, monto, condiciones y estado. Formaliza el acuerdo entre las partes con trazabilidad.

## 6. ARQUITECTURA Y DECISIONES DE DISEÑO 

## 6.1 JERARQUÍA DE CLASES 

La arquitectura se basa en una jerarquía de clases cuidadosamente diseñada: 

Persona (clase base) -> Propiedad (clase abstracta) y Contratobase (clase abstracta). 
Persona (clase base) -> Propietario y Cliente (clases hijas). 
Propiedad (clase abstracta) -> Apartamento, Casa, Lote, Oficina (clases hijas). 
Contratobase (clase abstracta) -> ContratoCompra, Contratoventa, ContratoArriendo (clases hijas). 

## 6.2 JUSTIFICACIÓN DE DISEÑO: 

**Clase Base Concreta (Persona)**

Se definió como una clase base concreta porque tanto propietarios como clientes comparten atributos y comportamientos comunes, como identificación, nombre, teléfono y correo. Al hacerla concreta: Se evita duplicación de código, se permite instanciar personas genéricas si fuese necesario y facilita el uso de herencia para extender funcionalidad en clases específicas.

**Clases Concretas Derivadas (Propietario, Cliente)**

Estas clases heredan de Persona y encapsulan comportamientos o atributos específicos.
- Propietario puede tener una lista de propiedades asociadas.
- Cliente puede tener un presupuesto y preferencias de búsqueda.
- Permite aplicar **polimorfismo** y tratamiento diferenciado según el rol de la persona.

**Clase Abstracta Intermedia (Propiedad)**

Se diseñó como una clase abstracta ya que representa un concepto general de propiedad inmobiliaria, pero no se pretende crear instancias directamente.
- Encapsula atributos comunes como dirección, precio, área, número de habitaciones/baños y estado.
- Define métodos abstractos (por ejemplo, calcular impuestos o mostrar detalles).
- Obliga a las subclases (Apartamento, Casa, Lote, Oficina) a implementar comportamiento específico.
- 
**Clases Concretas Finales (Apartamento, Casa, Lote, Oficina)**

Estas representan tipos reales de propiedades con atributos o reglas particulares (por ejemplo, administración en apartamentos, área construida en casas, etc.).
- Favorecen la extensibilidad si se agregan más tipos en el futuro.
- Permiten especializar comportamiento sin romper la jerarquía general.

**Clase Abstracta Intermedia (ContratoBase)**

Define una estructura genérica para los contratos sin representar ningún contrato real.
- Contiene atributos comunes (ID, tipo, duración, monto, estado).
- Define métodos abstractos como validarContrato() o calcularMontoFinal().
- Establece una plantilla común obligando a las subclases a definir su comportamiento específico.

**Clases Concretas Finales (ContratoCompra, ContratoVenta, ContratoArriendo)**

Estas clases concretas heredan de ContratoBase e implementan la lógica y atributos específicos de cada tipo de contrato.
- Cada tipo de contrato tiene reglas y datos distintos (por ejemplo, duración solo aplica a arriendo).
- Permite encapsular validaciones propias y controlar el estado de los contratos según su naturaleza.

Esta arquitectura favorece la reusabilidad, cohesión y el uso correcto de la herencia y el polimorfismo, haciendo el sistema escalable y mantenible.

## 6.3 INTERFACES: 

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

## 7. RELACIONES ENTRE OBJETOS: 
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

## 8. EXPLICACIÓN DETALLADA DEL CODIGO

**1: DAOs**

public class PropietariosDAO implements IDAO<Propietario> {

    ArrayList<Propietario> propietarios;
    private PropietarioRepositorio repositorio;

    public PropietariosDAO() {
        this.repositorio = new PropietarioRepositorio("src/files/vendedores.txt", "|");
        this.propietarios = repositorio.getData();
    }

    @Override
    public Propietario searchById(int id) {
        for (Propietario propietario : propietarios) {
            if(propietario.getId() == id){
                return propietario;
            }
        }
        return null;
    }

    ...

    EXPLICACIÓN: odos los DAOs siguen la misma estructura: implementan la interfaz IDAO con su clase concreta (como Propietario), declaran un ArrayList para manejar los datos en memoria y un repositorio correspondiente como atributo. En el constructor se instancia el repositorio y se cargan los datos desde el archivo. Se implementan los métodos create, readAll, update, delete y searchById, que permiten operar sobre la lista de objetos y sincronizar cambios con el repositorio.

**2: ENTITIES**

public class Apartamento extends Propiedad {

    private int idApartamento;
    private String edificio;
    private int numBanos;
    private int numHabitaciones;

    public Apartamento(int id, String tipo, String direccion, String estado, double precio, float areaMSq,
                       int idApartamento, String edificio, int numBanos, int numHabitaciones) {
        super(id, tipo, direccion, estado, precio, areaMSq);
        this.idApartamento = idApartamento;
        this.edificio = edificio;
        this.numBanos = numBanos;
        this.numHabitaciones = numHabitaciones;
    }

    @Override
    public String toString() {
        return ...
}

EXPLICACIÓN: Las entities del sistema representan las clases del dominio y están organizadas en clases abstractas y concretas. La clase abstracta Propiedad contiene los atributos comunes de inmuebles como id, tipo, dirección, estado, precio y área, y es extendida por clases concretas como Apartamento y Casa, que agregan atributos específicos. Además, existen otras entidades como Cliente, Contrato, ContratoVenta, entre otras, que representan objetos clave en el sistema con sus propios atributos y métodos. Todas siguen una estructura clara con constructores, getters, setters y una sobrescritura del método toString.

**3. INTERFACES:**

import java.util.ArrayList;

public interface ICliente<T> {
    void create(T t);
    void update(T t);
    void delete(int id);
    T read(int id);
    ArrayList<T> readAll();
}


EXPLICACIÓN: Las interfaces del sistema definen contratos que deben seguir las clases que las implementan. IDAO<T> establece métodos CRUD genéricos y es implementada por todas las clases DAO, garantizando una estructura uniforme. ICliente<T> define operaciones específicas para clientes y permite modularidad al separar la lógica cliente del resto. Por su parte, IContrato e IRepositorio<T> organizan comportamientos clave relacionados con la gestión de contratos y acceso a archivos, respectivamente. Todas las interfaces contribuyen a la abstracción y desacoplamiento del sistema.

**4. SERVICES:**

public class ContratoService {

    private final ArrayList<Contrato> lista = new ArrayList<>();
    private final UsuarioService usuariosService;

    public ContratoService(UsuarioService usuariosService) {
        this.usuariosService = usuariosService;
    }

    public void registrarContratoCliente() {
        System.out.println("La persona ya está registrada?");
        boolean ans = Verificacion.booleano("(s/n): ");
        if (!ans) {
            usuariosService.registrarCliente();
        }

        int idp = Verificacion.enteroMayorQue("ID: ", 0);
        Persona p = usuariosService.searchCliente(idp);

        int id = agregarContrato("ID: ");
        String tipo = Verificacion.cadena("Tipo de contrato: ");
        double monto = Verificacion.doubleMayorQue("Monto: ", 0);
        String estado = Verificacion.cadena("Estado: ");
        String notaria = Verificacion.cadena("Notaría: ");

        lista.add(new Contrato(id, tipo, monto, estado, notaria, p));
        System.out.println("→ Contrato registrado.\n");
    }
}

EXPLICACIÓN: El sistema cuenta con seis clases de servicio (Services) que manejan la lógica de negocio y la interacción entre las entidades y los usuarios. Estas son: App, que es la clase principal encargada de ejecutar la aplicación y coordinar las diferentes operaciones; ContratoService, que gestiona el registro, actualización, consulta y eliminación de contratos, asegurándose de validar la existencia de clientes mediante el uso de UsuarioService; PersonaService, que administra las operaciones relacionadas con las personas en el sistema; PropiedadService, encargado de la gestión de las propiedades; UsuarioService, que maneja la administración y validación de usuarios; y por último, Verificacion, que contiene métodos auxiliares para validar entradas y datos ingresados por el usuario. Todos estos servicios siguen una estructura organizada que permite realizar operaciones CRUD, validar datos y mantener la integridad de la información dentro del sistema.

**5. PERSISTANCE**

public class FileManager {
    private String pathFile;

    public FileManager(String pathFile){
        this.pathFile = pathFile;
    }

    public File getFile(){
        return new File(this.pathFile);
    }

    public ArrayList<String> getDataFile(){
        ArrayList<String> lines = null;
        try {
            File file = this.getFile();
            if (file.exists()){
                lines = new ArrayList<>();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getFile()));
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    lines.add(line);
                }
            }
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
        return lines;
    }

EXPLICACIÓN: La clase FileManager se encarga de la gestión de archivos para la persistencia de datos en el sistema. Su función principal es manejar la ruta del archivo, leer su contenido línea por línea y devolverlo como una lista de cadenas. Incluye métodos para obtener el archivo y extraer sus datos, asegurando una lectura segura mediante manejo de excepciones. Esta clase es utilizada por los repositorios para acceder a la información almacenada en archivos de texto y facilitar la manipulación de datos persistentes en la aplicación.

**6. REPOSITORIOS**


public class ClienteRepositorio extends Repositorio implements IRepositorio<Cliente> {

    public ClienteRepositorio(String path) {
        super(path, "|");
    }

    @Override
    public ArrayList<Cliente> getData() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<String> lines = this.fileManager.getDataFile();
        if (lines != null) {
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, this.delimitador);
                // Parseo de tokens para crear el objeto Cliente
            }
        }
        return clientes;
    }

    @Override
    public void insertData(Cliente p) {
        String line = p.getId() + "|" + p.getNombre() + "|" + p.getApellido() + "|" + p.getCedula();
        this.fileManager.writeFile(line);
    }
    
   ...Métodos updateData y deleteData con lógica similar adaptada para la entidad Cliente
}

EXPLICACIÓN: El proyecto cuenta con cinco repositorios: ClienteRepositorio, ContratoRepositorio, PropiedadRepositorio, PropietarioRepositorio y una clase base llamada Repositorio. Todos gestionan la persistencia de datos mediante archivos de texto delimitados, implementando operaciones básicas CRUD. La clase base Repositorio centraliza la gestión del archivo y el delimitador, mientras que cada repositorio específico se encarga de transformar las líneas en objetos y viceversa, facilitando así la manipulación y almacenamiento de datos de cada entidad.

**7. MAIN**

public class Main {
    public static void main(String[] args) {

        //Iniciar el menu
        App menu = new services.App();
        try {
            menu.run();
        } catch (NullPointerException e) {
            System.out.println("El objeto al que se quiere acceder es nulo");
        }catch (NumberFormatException e){
            System.out.println("Error de formato");
        }        catch (Exception e) {
            System.out.println("Error surgido de tipo: " + e.getClass());
        }

    }
}

EXPLICACIÓN: La clase Main es el punto de inicio del programa. En el método main, se crea un objeto de la clase App, que se encarga de mostrar el menú y manejar lo que el usuario quiere hacer. Luego se llama al método run() para comenzar a ejecutar el programa. Además, se usan bloques try-catch para controlar errores comunes, como cuando se intenta usar algo que no existe (NullPointerException), o cuando se escribe un número en un formato incorrecto (NumberFormatException). También hay un bloque general para atrapar cualquier otro error inesperado, mostrando mensajes claros para ayudar a entender qué pasó. De esta manera, el programa puede funcionar sin cerrarse de repente y avisar si algo no salió bien.

## 9. RESULTADO FINAL DEL CÓDIGO PARA EL USUARIO: 

El sistema funciona mediante un menú interactivo que se muestra cuando el programa arranca. Este menú permite que el usuario elija qué acción quiere realizar, como agregar un nuevo cliente, registrar un contrato, consultar información o actualizar datos existentes. Cuando el usuario selecciona una opción, el programa le pide que ingrese los datos necesarios, por ejemplo, el nombre del cliente, el tipo de contrato, o el ID de una propiedad. Para facilitar esto, se usan métodos de verificación que ayudan a validar que la información ingresada sea correcta y evitar errores, como asegurarse que un número sea positivo o que un texto no esté vacío. Además, si el usuario intenta hacer algo que no existe, como buscar un contrato que no está registrado, el sistema le muestra mensajes claros para que sepa qué ocurrió. También hay controles para evitar que el usuario ingrese datos repetidos, por ejemplo, IDs duplicados. Todo esto sucede de forma sencilla y ordenada para que el usuario pueda manejar la información sin complicaciones y el sistema responda de manera segura ante posibles errores. Así, la experiencia de uso es práctica y confiable.

## 10. DEMOSTRACIÓN DE CONCEPTOS POO 
El sistema desarrollado refleja claramente los pilares de la Programación Orientada a Objetos (POO) en su diseño e implementación:

1. Encapsulamiento: Los atributos de clases como Persona, Propiedad y ContratoBase son privados o protegidos, y su acceso está controlado mediante métodos get y set.La lógica interna, como el cálculo del monto total del contrato o la validación del estado de una propiedad, está contenida dentro de métodos públicos que encapsulan el comportamiento.
2. Abstracción: Se utilizan interfaces como ICliente, IContrato, IDAO, e IRepositorio para definir contratos claros de comportamiento sin exponer detalles de implementación. Clases abstractas como Propiedad y ContratoBase definen estructura y funcionalidad compartida entre sus subclases, permitiendo reutilización parcial y forzando a las clases hijas a implementar ciertos métodos esenciales.
3. Herencia: La jerarquía de clases establece relaciones del tipo “es un”: Propietario y Cliente heredan de Persona. Casa, Apartamento, Oficina y Lote heredan de Propiedad. ContratoCompra, ContratoVenta y ContratoArriendo extienden de ContratoBase. Se aprovecha la herencia para evitar duplicación de código y centralizar lógica común.
4. Polimorfismo: Gracias al uso de interfaces y clases abstractas, el sistema puede manejar objetos de diferentes clases concretas mediante referencias genéricas, como listas de ContratoBase o Propiedad. Los métodos como generarContrato() o mostrarDetalles() se comportan de forma distinta según la subclase concreta, demostrando polimorfismo en tiempo de ejecución.
5. Relaciones entre Objetos:
   - Asociación: Entre Propietario y Propiedad (un propietario puede tener múltiples propiedades).
   - Agregación: Entre Propiedad y Persona (la propiedad hace referencia a un dueño, pero ambos pueden existir por separado).
   - Composición: Entre Propiedad y ContratoBase (un contrato no existe sin una propiedad asociada; si la propiedad se elimina, los contratos también).
  
## 11. EXTENSIBILIDAD
El sistema está diseñado para ser modular y fácilmente extensible, permitiendo futuras adaptaciones sin alterar la arquitectura base:

1. Nuevos tipos de propiedad: Es posible agregar nuevas clases como Bodega, TerrenoRural o LocalComercial simplemente extendiendo la clase abstracta Propiedad, heredando atributos y comportamientos comunes.
2. Nuevos tipos de contrato:La clase abstracta ContratoBase puede ser extendida con nuevos contratos especializados, como ContratoPermuta o ContratoReserva, aprovechando la estructura común y agregando comportamientos particulares.
3. Nuevas interfaces para comportamiento adicional: Se pueden definir interfaces nuevas para agregar funcionalidades específicas a las clases sin modificar su jerarquía principal.
4. Sobrescritura de métodos en clases concretas: Las subclases como Casa o ContratoArriendo pueden sobrescribir métodos para personalizar el comportamiento según las reglas específicas del negocio.
5. Sistema flexible de gestión de personas: Se pueden integrar fácilmente nuevos roles de personas extendiendo la clase base Persona.
6. Separación de responsabilidades con interfaces (DAO y Repositorios): El uso de interfaces como IDAO e IRepositorio permite intercambiar o extender las implementaciones de acceso a datos sin modificar la lógica del dominio.
7. Escalabilidad del modelo de negocio: La arquitectura admite la incorporación de nuevas funcionalidades como historial de contratos, reportes automáticos, o integración con plataformas externas mediante adaptadores que implementen las interfaces existentes.

## 12. CASO DE USO PRÁCTICO: 
La clase Main demuestra un caso de uso práctico y completo del sistema inmobiliario:

1. Creación de personas: Se instancian objetos de tipo Propietario y Cliente, representando a los actores principales del sistema.
2. Creación de propiedades: Se crean instancias concretas como Apartamento, Casa, Lote y Oficina, demostrando el uso de herencia desde la clase abstracta Propiedad.
3. Generación de contratos: Se crean distintos tipos de contrato (ContratoCompra, ContratoVenta, ContratoArriendo) que enlazan propiedades con clientes y propietarios, aplicando el principio de composición.
4. Asociación de contratos a propiedades: Se demuestra cómo cada propiedad puede contener un contrato específico, evidenciando la relación de composición entre Propiedad y ContratoBase.
5. Almacenamiento y consulta en repositorio: A través de interfaces como IRepositorio e IDAO, las entidades son almacenadas y recuperadas sin acoplamiento directo a una implementación específica.
6. Recorrido polimórfico: Se recorre una colección heterogénea de propiedades o contratos utilizando referencias a clases base (Propiedad o ContratoBase), lo cual permite tratar uniformemente distintos tipos concretos.

## 13. CONCLUSIONES: 

El Marco de Trabajo para Gestión de Propiedades Inmobiliarias demuestra una arquitectura orientada a objetos bien estructurada que resuelve de manera eficaz los desafíos relacionados con la administración de propiedades, personas y contratos. A través del uso estratégico de interfaces, clases abstractas, y relaciones de herencia, composición, y asociación, el sistema establece una base sólida, extensible y mantenible para futuras aplicaciones inmobiliarias. Los principios fundamentales de la programación orientada a objetos se aplican de forma clara y coherente para: encapsular comportamientos específicos en clases responsables, reutilizar código mediante jerarquías de herencia bien definidas, definir contratos claros mediante interfaces y permitir polimorfismo.  Esta arquitectura facilita la implementación de nuevas funcionalidades, como nuevos tipos de contratos o propiedades, sin comprometer la estabilidad del sistema existente. En consecuencia, este marco puede servir como base robusta para el desarrollo de plataformas inmobiliarias escalables, adaptables tanto a aplicaciones empresariales como académicas.










































