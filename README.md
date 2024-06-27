# novatec
novatec crediban



Sistema de backend microservicios spring boot para el manejo de tarjetas de un banco. El sistema debe proveer la siguiente funcionalidad :
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






