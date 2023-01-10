#  Proceso de creación de una API Rest en Springboot
  Una API Rest es un tipo de arquitectura de software que utiliza el protocolo HTTP
  Métodos más utilizados: 
   - GET: se utiliza para acceder a los distintos recursos.
   - POST: se utiliza para crear nuevos recursos.
   - PUT: se utiliza para modificar los recursos existentes. 
   - DELETE: se utiliza para eliminar los recursos.
  
   Estructura básica de una API Rest
   - Controller: Expone los endpoints (rutas) y recibe peticiones HTTP. Nos provee los métodos para un CRUD.
   - Service: Define la lógica de negocio.
   - Repository: Contiene las interfaces que extienden de JPA para que estas clases se conecten y manipulen la BD. Realiza operaciones      en la base de datos sin escribir tantas líneas de código.
   - Domain o Model: Son clases que a través del mapeo de las tablas de la BD permite manipular los datos de éstas.  
   
   Estructura de paquetes creada para este proyecto
   ![2023-01-09_21h48_13](https://user-images.githubusercontent.com/72228855/211437144-815797d5-7ed7-4596-941b-e7da0dba5df6.png)

  
   Para realizar las pruebas de los endpoints se utilizó  la herramienta Postman.
   Ejemplo de prueba del método GET que lista los contactos que existen en la BD
   
   ![2023-01-09_22h53_14](https://user-images.githubusercontent.com/72228855/211444215-dcc021fd-d853-4c65-a769-def01bd6c7e1.png)

   contactos que estaban en la BD
   ![2023-01-09_22h55_31](https://user-images.githubusercontent.com/72228855/211444390-f21ac6c1-2403-472f-8976-5cfdeb837aad.png)
   
   Ejemplo de prueba del método GET para buscar un contacto por nombre o apellido
   ![2023-01-09_22h59_03](https://user-images.githubusercontent.com/72228855/211444943-98f8a89c-09a3-4b29-8a43-3adbef5e436b.png)

