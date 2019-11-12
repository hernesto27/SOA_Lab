# Session 3 - SOA Lab

Information related to exercises of session #3 of SOA Labs.

1. Setup of web services VISA.

### 1.  Setup of WS VISA
The services are locate in the folder _**PaymentServices/Wrapper/Visa**_

- Start the environment _**Ret Hat Developer Studio**_
- Import the project _**Visa**_
- Start the server and test the aplication.

**Wrapper for legacy app

- This example shows how to expose a legacy app (_using propietary protocols and data format_) as a SOAP web service, the approach used to build the service is **bottom/up**

- Run the **_run-visapayment-service-1.0.0.bat_** file located in _**PaymentServices/TCP/visa**_

- To test the wrapper just made a request _(could be with SoapUI)_ to the service endpoint with valid data.

     #### **Request Example**

     ```xml
     <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:visa="http://visa.das.ufsc.br/">
        <soapenv:Header/>
        <soapenv:Body>
           <visa:efetuarPagamento>
              <requisicao>
                 <dataVencimento>12/2020</dataVencimento>
                 <nome>FULANO</nome>
                 <numero>4234567890123456</numero>
                 <valor>252.43</valor>
              </requisicao>
           </visa:efetuarPagamento>
        </soapenv:Body>
     </soapenv:Envelope>
     ```
     
     #### **Response Example**

     ```xml
     <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
        <soap:Body>
           <ns2:efetuarPagamentoResponse xmlns:ns2="http://visa.das.ufsc.br/">
              <return>
                 <autorizacao>cdd85455-e100-404f-95b0-a9da11749949</autorizacao>
                 <valor>239.81</valor>
              </return>
           </ns2:efetuarPagamentoResponse>
        </soap:Body>
     </soap:Envelope>
     ```
