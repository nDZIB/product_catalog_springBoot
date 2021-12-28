# product_catalog_springBoot
#####      spring boot product management api

	This is a product catalog api. It is written in java using the spring boot framework. It has two main microservices; a product service (product_service) and a category service(category_service). As each name implies the microservices respectively handle operations on products and categories. Also, there is a naming server for the api (the naming server is a eureka naming server).
	
## Before Running
	Before running any of the microservices;
1.  Ensure to have spring tool suite(STS) ide or sts integrated into a java ide of your choice
2.	Ensure internet connection so as to download any dependencies on-the-go if needed

## Getting it running

1.	Clone this repository
2.  Open a choice IDE and import the various microservice provided in this repository into it.
3.	Run the the applications (microservices) beginning from the naming server (com.product-catalog-namingserver).
	
	he product_service runs on port 8081, the category_service runs on port 8080
	 and the naming serving on port 8761.

## Getting around the api

	
The major microservices are each provided with swagger documentation (which provides details about the service's endpoints, request and response structures). Once a microservice is up and running as shown by  the naming server (that is at localhost:8761/eureka) then its swagger documention can be accessed as:
	
	product_service = localhost:8081/swagger-ui.html
	category_service = localhost:8080/swagger-ui.html

	
	
	
	
	
	
##### Note
	*All microservices make use of the h2 database (spring boot's in-memory database)
