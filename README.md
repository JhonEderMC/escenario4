### Escenario 4

### Introducción

* Esta es una aplicación de Spring WebFlux y MongoDB.
* Esta aplicación consiste en operaciones CRUD y búsquedas por parámetros de la información de algunos vehículos y sus desplazamientos.  
* Esta es una guía rápida de como consumir la API.

#### Información Carro
* **getAll:** localhost:8080/carinfo
* **getAllByPlaca:** localhost:8080/carinfo/placa/{placa}        ejemplo `localhost:8080/carinfo/placa/LAX031`
* **getAllByMarca:** localhost:8080/carinfo/marca/{marca}   ejemplo `localhost:8080/carinfo/marca/renoult`
* **delCarinByPlaca:** localhost:8080/carinfo/{placa} misma metodología anterior  
* **postCarInfo:** localhost:8080/carinfo 
  ejemplo body:
`{
  "placa":"pru203",
  "marca":"Kia",
  "modelo":"Picanto",
  "conductor":{
  "id": "402",
  "name": "Luis espinal"
  }
  }`
  
* **putCarInfo:** localhost:8080/carinfo mismo cuerpo que el post, la id es la placa del vehículo.

#### Desplazamiento carro
* **getAllDesp:** localhost:8080/desp
* **getAllDespByPlaca:** localhost:8080/desp/placa/{placa}  ejemplo `localhost:8080/desp/placa/lax301`
* **getAllDespByDestino:** localhost:8080/desp/destino/{destino} misma metrología anterior
* **getAllDespByfechaOrigen:** localhost:8080/desp/fecha/{fecha} ejemplo `localhost:8080/desp/fecha/2021-01-28`
* **postDesp:** localhost:8080/desp   ejemplo body 

{    
"placa":"JVX-321",
"origen":"Manizales",
"destino":"Cali",
"fechaOrigen":"2021-01-10",
"fechaDestino":"2021-05-10"
}

* Nota: Como un vehiculo puede tener varios desplazamientos este tiene un parámetro llamado id el cual corresponde a la id de cada desplazamiento.