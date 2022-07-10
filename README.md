# Back-end is Java Project
### 1. the config properties is application.properties,  stocks api service information in this file


### 2. access API service as follow:

  All Exchanges: http://localhost:8080/api/stock/exchanges
  
  All Symbol of exchange: http://localhost:8080/api/stock/exchanges/US
  
  Stock: http://localhost:8080/api/stock/fundamental/{$symbol_code}.{exchange_id} For Example:  http://localhost:8080/api/stock/fundamental/MCD.US

### 3. jdk8+ must

# Front-end is Reactjs

### 1. Node environment is must
### 2. `yarn install`  
	download the dependences
### 3. `yarn start`  
	start the server
### 4. access UI by url:	
	http://localhost:3000
