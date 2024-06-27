# novatec
novatec crediban



Sistema de backend microservicios spring boot para el manejo de tarjetas de un banco. 

El sistema provee la siguiente funcionalidad :
1.
Generar número de tar jeta
Tipo de método: GET
Recurso: /card/{productId}/number
2.
2. Activar tarjetaActivar tarjeta
Tipo de método: POST
Recurso: /card/enroll { "cardId": "1020301234567801" }
3.
3. Bloquear tarjetaBloquear tarjeta
Tipo de método: DELETE
Recurso: /card/{cardId}
4.
4. Recargar saldoRecargar saldo
Tipo de método: POST
Recurso: /card/balance { "cardId": "1020301234567801", "balance": "10000" }
5.
5. Consulta de saldoConsulta de saldo
Tipo de método: GET
Recurso: /card/balance/{cardId}
6.
6. TTransacción de compraransacción de compra
Tipo de método: POST
Recurso: /transaction/purchase { "cardId": "1020301234567801", "price": 100 }
7.
7. Consultar transacciónConsultar transacción
Tipo de método: GET
Recurso: /transaction/{transactionId}
Nivel 2
1. Crear el servicio de anulación de transacciones, el cual consiste en que a partir de la transacción de compra:
• Se debe anular a partir del id de transacción
• La transacción a anular no debe ser mayor a 24 horas.
• La transacción quede marcada en anulada.
• El valor de la compra debe volver a estar disponible en el saldo.
Tipo de método: POST
Recurso: /transaction/anulation { "cardId": "1020301234567801", "transactionId":


Modelo de componentes
![image](https://github.com/aldringutierrez/novatec/assets/18297438/c6615a94-2618-4fe8-9156-6ecafd6a2d04)


modelo de base de datos :
![image](https://github.com/aldringutierrez/novatec/assets/18297438/1e46496d-d38f-4a5f-ad7c-9d56f2940bc1)


Se hace el uso de copilot para generar los esqueletos de los casos de pruebas unitarias
![image](https://github.com/aldringutierrez/novatec/assets/18297438/ad3431cd-2c98-4d5e-83a1-b00959c12c30)


Se evidencia la cobertura con jacoco :
![image](https://github.com/aldringutierrez/novatec/assets/18297438/670c2708-ea00-42c3-9e37-ebf44105a01e)

Se evidencia la aplicacion corriendo :
![image](https://github.com/aldringutierrez/novatec/assets/18297438/b6cef558-0996-4fbf-8bbc-35483c2df571)

Se evidencia la aplicacion respondiendo desde postman :
![image](https://github.com/aldringutierrez/novatec/assets/18297438/b016df59-de37-420b-801b-37f8a851df1e)

Se evidencia que el microservicio crea una tarjeta con dos transacciones :
![image](https://github.com/aldringutierrez/novatec/assets/18297438/6957366b-20ab-4933-95c1-9d7f18ded03f)

![image](https://github.com/aldringutierrez/novatec/assets/18297438/692f38fd-693e-4c73-9687-08cd1b8bcdf1)

Se evidencia el microservicio anular2. verifica transaccion dentro de 24 horas. 
(se encuentra un bug a ultima hora toca darle dos veces ejecutar desde postman) :
![image](https://github.com/aldringutierrez/novatec/assets/18297438/862a0c85-01b2-42ae-aaf5-1bcdacfc9e29)

se evidencia la correcta modificacion de la base de datos :
la transaccion en estado anulado :
![image](https://github.com/aldringutierrez/novatec/assets/18297438/c7dc4ded-8010-4d93-bec5-7523557352a7)

el saldo de la tarjeta restaurado :
![image](https://github.com/aldringutierrez/novatec/assets/18297438/13ccab7a-e9f4-4f75-a0cd-cf2a51cd1eb5)

se adjunta coleccion de postman y archivo sql con el create de las tablas.
![image](https://github.com/aldringutierrez/novatec/assets/18297438/ad9b5749-960a-4344-a10f-f388285720b2)



























