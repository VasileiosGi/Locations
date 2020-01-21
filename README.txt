1. Create Mysql database using the script with title: soap_api.sql
2. There is another scirpt with name: ScriptToPopulateMemoryTable. This is because memory table gets empty when the MySQL server restarts. So this script populates locations memory table if needed (if you restart mysql).
3. Now, in the projects application.properties set values accrodingly (change url/username/password/port). 	
4. Maven Clean.
5. Run SpringBootSoapApplication.java .
6. Then using postman create a post request to http://localhost:8106/soapWS changing accordingly your port number. In headers  put in key Content-Type and in value text/xml. In Body choose raw and copy-paste what is written in get-list-with-higher-counter-request.xml or get-nearest-point-request.xml. Then click send and you will get your response.
7. WSDL location http://localhost:8106/soapWS/locationwsdl.wsdl (change port number accordingly).
8. Run as Maven Test to check test results.

