# API-SportsLiveScores

- En caso que la API que estamos consumiendo tarde mucho tiempo o falle, deberíamos aplicar alguna estrategia de resiliencia con un Circuit Breaker que, a modo de diyuntor, detecte la falla y delegue el flujo a un método FallBack que nos permita decidir con anticipación las acciones que se realizarán en dicho caso.
De ésta manera, a pesar de que la API falle, podemos devolver una respuesta controlada al cliente sin la necesidad de retornar un error.
Este patron lo podemos ver reflejado en el proyecto en el controlador que contiene el metodo GET con su respectivo Circuit Breaker.

- La herencia que utiliza "JsonSubTypes" se puede encontrar en el proyecto "UTNPhones" en el siguiente repositorio: https://github.com/FeDeJMendez/UTNPhones , donde encontramos una clase "Person" que hereda en las clases "Backoffice" y "Client".


Trabajo para Laboratorio V 2022
