# Session 1 - SOA Lab

Information related to exercises of session #1 of SOA Labs.

1. Analysis of the application _**portalNewTec**_
2. Calling external SOAP Web Service
3. CEP Service Project in MULE

Prerequisites:
    You should have installed all software listed in [previous step][step0].

1. **PortalNewTec**
- Start the environment _**Ret Hat Developer Studio**_
- Import the project _**portalNewTec**_ from the folder _**Ferramentas**_
- Description of the application .
- Start the server and test the aplication.
    
2. **Invoking External SOAP Service Project**

This example shows how to invoke a SOAP Web Service to find Brazilian CEP information, the service provider is **UFSC**.

- The service endpoint is:
https://ws.homologacao.ufsc.br/services/CEPService
- The service description is:
https://ws.homologacao.ufsc.br/services/CEPService?wsdl
    - cepUser/cepUser2008
- Test the service with SoapUI.

3. **Consume a soap service with MULE/ESB**
- Start the environment _**Anypoint Studio**_ from the folder _**Ferramentas -> AnypointStudio-for-win-64bit-6.6.3-201909242011(6.6_3.9)**_
- Import the project _**CEPservice**_ from the folder _**Ferramentas -> AnypointStudio-for-win-64bit-6.6.3-201909242011(6.6_3.9)**_
- Description of slack.
- Start the server and test the service.

