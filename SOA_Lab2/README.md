# Session 2 - SOA Lab

This document contains the information related to the exercises of session #2 of SOA Lab:

1. Download and setup service registry jUDDI.
2. Registering CEP service in UDDI.
3. Discovering SOAP Web Service registered in UDDI.
4. Discovering REST Web Service registered in UDDI

___

### 1. Download and setup service registry jUDDI

Download "juddi-distro-3.3.6.zip" from here: http://juddi.apache.org/releases.html

After downloading and unpacking of the "juddi-distro-3.3.6.zip", check the _**juddi-tomcat-3.3.6 -> conf -> tomcat-users**_ file for the password of the _**uddiadmin**_ user. Change the password before going live.

Check the _**juddi-tomcat-3.3.6 -> conf -> server**_ file and change the port. For this case we choose port 9082.
>Connector port="9082" protocol="HTTP/1.1".

Start the preconfigured tomcat server by going into the "_**juddi-tomcat-3.3.6 -> bin**_" directory and running _**startup**_.

Once the server is up and running can make sure the root data was properly installed by browsing to http://localhost:9082/juddiv3

For an advanced configuration consult the -**jUDDI_Guide**_ guide in the _**jUDDI" folder**_

___

### 2. Registering a service in the jUDDI server

#### Note:
>jUDDI offers an API that is divided into several "sets" (Web Services) representing a specific area of functionality. **For more information read [this](https://juddi.apache.org/docs/3.x/devguide/html/ch01.html#_uddi_and_juddi_api).**
>The web service used to query the registry is the **_"Inquiry service"_**, available in:
     http://localhost:9082/juddiv3/services/inquiry?wsdl

##### For registering a service in the jUDDI node follow the steps below:

 **URL GUI:** http://localhost:9082/juddi-gui
 **login/password:** uddiadmin/"your password"

The steps 1 and 2 creates a UDDI area to represent the enterprise that will provide/publish the services (for this example DAS)

1) **Register Key Generator (do it only once)**
	- **Key:** 	uddi:das.ufsc.br:keygenerator
	- **Name:**	DAS Key Generator 

2) **Register Business (do it only once)**
	- **Key:** 	uddi:das.ufsc.br:repository
	- **Name:** 	DAS Repository

3) **Create T-Model to categorize registered services (do it only once)**
	- **Key:**	uddi:das.ufsc.br:servicecategory
	- **Name:**	Service Category

4) **Register service (Create --> Register Services for WSDL)**
	- Put the location of the service's WSDL
	Choose the Business registered in step 1	
	**WSDL:** https://ws.homologacao.ufsc.br/services/CEPService?wsdl (Brazilian CEP information provided by **UFSC**)
	**User/Password:** cepUser/cepUser2008
	
5) **Set service category** 
(_Discover --> Services --> Choose the service from the list --> Categories --> Add Key Reference --> Selector --> Choose T-Model **"uddi:das.ufsc.br:servicecategory"** --> fill input data --> save_).

	- **T-Model Key:**	uddi:das.ufsc.br:servicecategory
	- **Name:**		    das.ufsc.br:servicecategory
	- **Value:**			Is the category name _(cepService)_


All the configurations made in last steps are saved to the UDDI database that is located in the folder **"YOUR\UDDI\DIRECTORY\juddi-tomcat-3.3.6\bin\target"**:
- Delete this folder means "clean" the UDDI.
___

### 3. Discovering and Invoking External SOAP Service Project

The service to be discovered is the same that was used in session 1, is used to find Brazilian CEP information and is provided by **UFSC**.

The service endpoint is:
> https://ws.homologacao.ufsc.br/services/CEPService
    
    User/Password: cepUser/cepUser2008

The service description is:
> https://ws.homologacao.ufsc.br/services/CEPService?wsdl


To support UDDI discovering in the MULE/ESB:

- Importar o projeto _**cep_service_uddi**_

- Modify **"pom.xml"** file to support UDDI dependency.

    Validate that compiler level is in 1.8:

    ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
<uddi>
	<manager name="default">
		<nodes>
			<node isHomeJUDDI="true">
				<name>default</name>
				<properties>
					<property name="serverName" value="localhost" />
					<property name="serverPort" value="9082" />
				</properties>
				<!-- JAX-WS Transport -->
				<proxyTransport>org.apache.juddi.v3.client.transport.JAXWSTransport</proxyTransport>
				<custodyTransferUrl>http://${serverName}:${serverPort}/juddiv3/services/custody-transfer</custodyTransferUrl>
				<inquiryUrl>http://${serverName}:${serverPort}/juddiv3/services/inquiry</inquiryUrl>
				<publishUrl>http://${serverName}:${serverPort}/juddiv3/services/publish</publishUrl>
				<securityUrl>http://${serverName}:${serverPort}/juddiv3/services/security</securityUrl>
				<subscriptionUrl>http://${serverName}:${serverPort}/juddiv3/services/subscription</subscriptionUrl>
			</node>
		</nodes>
	</manager>
</uddi>
    ```
- Copy the **"uddi.xml"** file to **"src/main/resources/META-INF"**.
- Add the WSDL service (external services to be invoked)
     
- For this example of **_CEP Service_** the class `CEPServiceDiscovery.java` is responsible to discover services of this category. The service category that will be registered as `T-Model` is "`cepService`".

- Be sure that the library **"juddi-uddi-client-1.0.0.jar"** is add.

---
### 4. Discovering and Invoking External RESt Service Project

- Exercise developed in the classroom.