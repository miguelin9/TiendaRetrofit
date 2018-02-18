# TIENDA MVP
El presente proyecto forma parte de una de las tareas de la asignatura de Programación de Servicios y Procesos del Ciclo Formativo de Grado Superior de Desarrollo de Aplicaciones Multiplataforma del IES Vírgen del Carmen en Jaén.

Este proyecto consiste en desarrollar una App nativa en Android para un servicio REST usando la librería Retrofit en el cliente. 

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
http://52.47.123.57:5000

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

