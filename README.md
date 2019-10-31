# SOA_Labs

## Tools for SOA lessons 

#### 1. Download all necessary tools
- Install the tools in the order stated below. Link for download [here1].
- Install the tools in the order stated below. Link for download [here2]
- UI SOAP: https://www.soapui.org/downloads/latest-release.html

#### 2. Download and install the **Java development kit (jdk)**.
* If the OS is a 64 bits Windows install the JDK using the `.jar` available in the downloaded folder _**"1_JDK"**_ in the first step.
    
    Setup: After installation follow the guide _**"PATH_Guide"**_ attached in the folder _**"1_JDK"**_, for PAHT configuration.

    If you are using other OS, download the JDK here:
    https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

#### 3. Anypoint Studio 6.6 e Mule 3.
To open _**Anypoint Studio 6.6 e Mule 3.9**_ package for windows (64 bits), use the `AnypointStudio` located in the folder _**"2_Anypoint Studio 6.6 e Mule 3.9"**_ downloaded in the first step.

Follow the CE installation guide located in the folder _**"2_Anypoint Studio 6.6 e Mule 3.9"**_

If you are using other OS, download here: https://www.mulesoft.com/lp/dl/studio/previous.

#### 4. JBoss EAP 7.2.0
To install the JBoss EAP runtime package, use the .jar located in the folder _**"3_Jboss"**_ downloaded in the first step.

Run the JBoss EAP installer double clicking on the file _**jboss-eap-7.2.0-installer**_ or executing the following command in the console:

java -jar jboss-eap-7.2.0-installer.jar

During installation:
- Accept the terms and conditions.
- Choose your preferred installation path (EAP_Install_Path), for the JBoss EAP runtime.
- Create an administrative user and make a careful note of these administrative user credentials for later.
- You can accept the default settings on the remaining screens.

#### 5. JBoss Developer Studio
- Run the installer located in the folder _**"3_Jboss"**_
    - For Mac / Windows Development Hosts:
        - Double-click on the jar (_**devstudio-12.0.0.GA-installer-standalone**_) to start the installer.
    - For Linux Development Hosts
        - Go to the folder where you have downloaded the installer and execute it. with
            ```sh
            java -jar devstudio-11.0.0.GA-installer-standalone.jar
            ```
- During installation:
    - Accept the terms and conditions.
    - Choose your preferred installation path.
    - Select the Java 8 JVM installed in 2dn step.
    - At the **Select Platforms and Servers** step, **configure the runtime server by clicking Add and browsing to the location of the **(EAP_Install_Path)** directory** _(last step)_.
- The developer environment will start up. When the Searching for runtimes dialog appears, click OK to create the JBoss EAP runtime.
- Accept any additional dependencies and license agreements.


[here1]: <https://www.dropbox.com/home/Ferramentas>
[here2]: <https://drive.google.com/open?id=13ogiZo3nIRS3icD50Dbk7GLH2-7lG2ax>