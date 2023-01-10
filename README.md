#  Proceso de creación de una API Rest en Springboot
  Una API Rest es un tipo de arquitectura de software que utiliza el protocolo HTTP
  
   Estructura básica sobre la arquitectura de una API Rest
   - Controller: Expone los endpoints (rutas) y recibe peticiones HTTP. Nos provee los métodos para un CRUD.
   - Service: Define la lógica de negocio
   - Repository: Contiene las interfaces que extienden de JPA para que estas clases se conecten y manipulen la BD. Realiza operaciones      en la base de datos sin escribir tantas líneas de código.
   - Domain o Model: Son clases que a través del mapeo de las tablas de la BD permite manipular los datos de éstas.  
   
  

