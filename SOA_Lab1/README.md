# Session 1 - SOA Lab

Information related to exercises of session #1 of SOA Labs.

- Analyse the application _**portalNewTec**_
- Calling external SOAP Web Service

Prerequisites:
    You should have installed all software listed in [previous step][step0].

1. _*PortalNewTec*_
    - Start the environment _**Ret Hat Developer Studio**_
    - Import the project _**portalNewTec**_ from the folder _**Ferramentas**_
    - Describe the application.
    - Start the server and test the aplication.
    
#### 2. Invoking External SOAP Service Project
This example shows how to invoke a SOAP Web Service to find Brazilian CEP information, the service provider is **UFSC**.

The service endpoint is:
https://ws.homologacao.ufsc.br/services/CEPService

The service description is:
https://ws.homologacao.ufsc.br/services/CEPService?wsdl

    - cepUser/cepUser2008
    
Test the service with SoapUI.

##### Code Snippets "CEP Service Project"
- **SwitchYard**
    - **Group Id:** `br.ufsc.das`
    - **Namespace:** `http://das.ufsc.br`
    - **target Id:** `br.ufsc.das`
    
- **BPEL**
    Variable initialization code snippet for _service partnerLink_ in the assign block BPEL file:
    ```xml
    <int:getCepInfo xmlns:int="http://interfaces.cep.services.ufsc.br/">
    	<cep/>
    </int:getCepInfo>
    ```
- **deploy.xml**
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <deploy xmlns="http://www.apache.org/ode/schemas/dd/2007/03" xmlns:das.ufsc.br="http://das.ufsc.br">
      <process name="das.ufsc.br:CEP_Process">
        <process-events generate="all"/>
        <provide partnerLink="CEP_Process">
    		<service name="das.ufsc.br:CEP_Process" port="ignored" />    
        </provide>
        <invoke partnerLink="CEP_Service">
        <service name="das.ufsc.br:CEPService" port="ignored" />
        </invoke>
      </process>
    </deploy>
    ```

