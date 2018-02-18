# TIENDA MVP
El presente proyecto forma parte de una de las tareas de la asignatura de Desarrollo de Interfaces del Ciclo Formativo de Grado Superior de Desarrollo de Aplicaciones Multiplataforma.

Este proyecto consiste en desarrollar una App nativa en Android para un servicio REST usando los patrones Modelo-Vista-Presentador y Repositorio. 

El proyecto está realizado usando la metodología ágil SCRUM y el sistema de control de versiones Gitlab.
## Introducción
Se creará una app android nativa para el control del inventario de un almacen en una tienda, dicha app esta destinada a ayudar a los trabajadores del almacen para tener método rápido de actualizar el stock disponible. Adicionalmente intentaremos añadir más funcionalidades como dar de alta, una opción para realizar inventario y una busqueda por categorías.

## Backend
Usaremos un servicio REST montado con node.js, mongoose, express y mongoDB.<br/>
Este es el esquema usado en el backend:<br/>
codigo      : {type : Number, unique : true, required : true},<br/>
foto        : String,<br/>
nombre      : {type : String, required : true},<br/>
categoria   : String,<br/>
precio      : Number,<br/>
stock       : {type : Number, required : true},<br/>
descripcion : String<br/>
Hay varios campos que són obligatorios y de varios tipos, nuestro objetivo es controlarlo en el cliente así nunca se podrán subir o editar artículos que den error. 
Para más facilidad de uso hemos decidido usar el servicio gratuito de Amazon Web Service siendo la siguiente dirección la ip de la máquina:
http://52.47.123.57:3000/articulos/

Teniendo en cuenta la anterior ruta se pueden usar los endpoints siguientes:
<table>
    <tr>
        <th>URL</th>
        <th>VERBO HTTP</th>
        <th>CUERPO</th>
        <th>RESULTADO ESPERADO</th>
    </tr>
    <tr>
        <td>/articulos</td>
        <td>GET</td>
        <td>-</td>
        <td>Se obtiene un array json con todos los datos de artículos.</td>
    </tr>
    <tr>
        <td>/articulos</td>
        <td>POST</td>
        <td>JSON</td>
        <td>Se añade el artículo que va en el cuerpo a la base de datos.</td>
    </tr>
    <tr>
        <td>/articulos/codigo</td>
        <td>GET</td>
        <td>-</td>
        <td>Se obtiene un único artículo dado un código.</td>
    </tr>
    <tr>
        <td>/articulos/codigo</td>
        <td>DELETE</td>
        <td>-</td>
        <td>Borra un artículo de la base de datos dado un código.</td>
    </tr>
    <tr>
        <td>/articulos/codigo</td>
        <td>PUT</td>
        <td>JSON</td>
        <td>Actualiza un artículo existente dado un código, si no existe se crea.</td>
    </tr>
</table>


## Product Backlog
Deseos y requisitos de la app:

* Logo de la tienda.
* Información de contacto.
* Menú de navegación.
* Poder modificar el stock.
* Detalle de producto.
* CRUD de artículos.

## Modulos de la aplicación

* Actualizar un artículo: incluye presentador y vista para poder modificar los campos de un artículo.
* Detalle de artículo: incluye presentador y vista para ver un artículo en detalle, así como poder borrarlo. 
* Insertar artículo: incluye presentador y vista para dar de alta un nuevo artículo.
* Listar artículos: incluye presentador y vista para mostrar los artículos en forma de lista.
* Modelos: incluye el POJO de artículo y el patron repository.
* APIRest: incluye el SinglentonVolley y los metodos necesarios para realizar las peticiones REST.

## Bocetos Interfaz
Estos son los bocetos de la aplicación.

<table>
    <tr>
        <th>Vista inicial de la app:</th>
        <th>Menú Derecho</th>
        <th>Menú de la app:</th>
        <th>Listado: </th>
    </tr>
    <tr>
        <td>![vista inicial](http://oi65.tinypic.com/23jjs77.jpg)</td>
        <td>![menú derecho](http://oi67.tinypic.com/1629naw.jpg)</td>
        <td>![menú de la app](http://oi67.tinypic.com/20aaozl.jpg)</td>
        <td>![listado](http://oi65.tinypic.com/10hk3tj.jpg)</td>
    </tr>
    <tr>
        <th>Detalle</th>
        <th>Formulario:</th>
        <th>Categorías:</th>
        <th>Inventario:</th>
    </tr>
    <tr>
        <td>![detalle](http://oi67.tinypic.com/2vj30r9.jpg)</td>
        <td>![formulario](http://oi68.tinypic.com/106mwkn.jpg)</td>
        <td>![inventario](http://oi68.tinypic.com/rc65gn.jpg)</td>
        <td></td>
    </tr>
    
    

    

