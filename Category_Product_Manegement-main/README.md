# Category_Product_Manegement
A CRUD (Create, Read, Update, Delete) application for managing products and categories.

**Table of Contents**

-Description

-Usage

-Installation

-Downloading the ZIP file from GitHub

-Importing the project into your IDE

-Maven 

-MySQL Database

-Postman

-Swagger

-Technologies Used

**1 Description**

This application provides functionality to manage products and categories. The Product Category Application is a CRUD (Create, Read, Update, Delete) application built using Java and Spring Boot. It allows users to manage products and categories through RESTful API endpoints. Users can perform various operations such as creating, reading, updating, and deleting products and categories.

The application provides endpoints for managing both products and categories separately. For products, users can create new products, retrieve products by ID, retrieve all products, update existing products, and delete products. Similarly, for categories, users can create new categories, retrieve all categories with pagination support, retrieve categories by ID, update existing categories, and delete categories.

This application is useful for businesses or developers who need a simple yet effective way to manage product and category data. It provides a straightforward API interface for interacting with product and category information, making it easy to integrate with other systems or use as a standalone service.

**2 Usage**

The application exposes the following Usage:

_**Products:**_

Create a new product

Retrieve a product by ID

Retrieve all products 

Update a product 

Delete a product

_**Categories:**_

Create a new category

Retrieve all categories with pagination

Retrieve a category by ID

Update a category by ID

Delete a category by ID


**3 Installation:**

**_To install and run the provided project, you'll need the following:_**

**3.1 Java Development Kit (JDK):**

Ensure that you have JDK installed on your system. You can download and install JDK from the official Oracle website or use OpenJDK, which is an open-source alternative.

**3.2 Integrated Development Environment (IDE):**

You can use any Java IDE of your choice to work with the project. Some popular IDE options include:

-IntelliJ IDEA

-Eclipse

-NetBeans

-Spring Tool Suit 4 

These IDEs provide features such as code editing, debugging, version control integration, and project management.


**4 Downloading the ZIP file from GitHub:**

Downloading a specific ZIP file from a GitHub repository and importing it into an IDE is a straightforward process. Here's a step-by-step guide:


**4.1 Navigate to the GitHub repository:** 

Open your web browser and go to the GitHub repository page where the ZIP file is located.

**4.2 Locate the file:**

Find the specific ZIP file you want to download. It may be located in the repository's root directory or within a subdirectory.

**4.3 Click on the file:**

Click on the name of the ZIP file to open it.

**4.4 Download the ZIP file:** 

On the file page, you should see a "Download" button. Click on it to download the ZIP file to your computer.

**4.5 Wait for the download to complete:**

Depending on the size of the ZIP file and your internet connection speed, the download may take some time to complete.


**5 Importing the project into your IDE:**

**5.1 Extract the ZIP file:**

Once the download is complete, locate the downloaded ZIP file on your computer and extract its contents. This will typically create a folder containing the project files.

**5.2 Open your IDE:**

Launch your preferred Integrated Development Environment (IDE). Popular IDEs include IntelliJ IDEA, Eclipse, Spring Tool Suit 4 and Visual Studio Code.

**5.3 Import the project:**

In your IDE, look for an option to import an existing project. The exact steps may vary depending on your IDE, but typically, you can find this option in the File menu.

**5.4 Select the project folder:**

Navigate to the folder where you extracted the ZIP file contents. This folder should contain the project's configuration files, source code, and other resources.

**5.5 Complete the import process:**

Follow the prompts in your IDE to import the project. You may need to specify project settings, such as the project type, build tool (e.g., Maven or Gradle), and SDK version.

**5.6 Build the project:** 

After importing the project, your IDE may automatically start building it. If not, trigger a build manually to ensure that all dependencies are resolved and the project compiles successfully.

**5.7 Explore the project:** 

Once the project is imported and built, you can explore its structure, view source code files, and start working on it within your IDE.

**6 Maven:** 

The project is managed using Maven, a build automation tool primarily used for Java projects. Make sure you have Maven installed on your system. You can download Maven from the Apache Maven website.

**7 MySQL Database:**

The project seems to be using MySQL as the database. Ensure that you have MySQL installed and running on your system. You may need to create a database for the project and configure the connection details accordingly.

**Configuration MySQL Database:**

The main configuration file for the application is application.properties, located in the src/main/resources directory. You can modify this file to change various application settings such as database connection details, server port, logging configuration, etc.

You can configure the application using environment variables. Set the following environment variables according to your setup:

**SPRING_DATASOURCE_URL:**   URL of the MySQL database.

**SPRING_DATASOURCE_USERNAME:**   Username for database authentication.

**SPRING_DATASOURCE_PASSWORD:**   Password for database authentication.

**SPRING_DATASOURCE_DRIVER_CLASS_NAME:**   JDBC driver class name for MySQL (e.g., com.mysql.cj.jdbc.Driver).

**SPRING_JPA_HIBERNATE_DDL_AUTO:**   Hibernate DDL auto configuration (e.g., update).

**SPRING_PROFILES_ACTIVE:**  Active profile for Spring Boot application (e.g., dev).

**SERVER_PORT:**  Port on which the Spring Boot server will run (default is 8080).

Ensure that you have the necessary permissions and dependencies installed before proceeding with the installation and configuration steps.


**8 Postman**

You can use Postman, an API development environment, to interact with the application's endpoints.

Postman is a popular API development tool that simplifies the process of creating, testing, and documenting APIs.

Postman allows you to send HTTP requests to your API endpoints and examine the responses. You can easily test different HTTP methods (GET, POST, PUT, DELETE) and parameters.

Once the application is running, you can interact with it using the provided RESTful API endpoints. Here are some example endpoints:


_**8.1 All Category Endpoint Responses**_

**Create a new category:** POST /api/categories/createCategory

**Retrieve all categories with pagination:** GET /api/categories

**Retrieve a category by ID:** GET /api/categories/getCategoryById/{id}

**Update a category by ID:** PUT /api/categories/updateCategory/{id}

**Delete a category by ID:** DELETE /api/categories/deleteCategory/{id}


_**8.2 All Products Endpoint Responses**_

**Create a new product:** POST /api/products/createProduct

**Retrieve a product by ID:** GET /api/products/getProductById/{id}

**Retrieve all products:** GET /api/products/getAllProducts

**Update a product:** PUT /api/products/{productId}

**Delete a product:** DELETE /api/products/deleteProduct/{productId}


**9 Swagger**

Swagger is a helpful tool for documenting your API (Application Programming Interface). Think of it like a manual that explains how to use your API. With Swagger, you can describe all the endpoints in your API, what kind of data they expect, and what they'll return. This makes it easier for other developers (or even yourself in the future) to understand and use your API.

**Swagger UI:**

Swagger UI is a web interface that automatically generates documentation for your API based on the information you provide. It's like having a website that shows all the details of your API in an easy-to-read format. With Swagger UI, developers can see all the endpoints, what data they need to send, and what they'll get back. They can even try out the endpoints right there in their web browser.

**How to Use Swagger:**

For the integration between spring-boot and swagger-ui, add the library to the list of your project dependencies (No additional configuration is needed) which is given below.

<dependency>
      
      <groupId>org.springdoc</groupId>
      
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      
      <version>2.5.0</version>
      
</dependency>
  
**Swagger Integration:**

above dependancy will automatically deploy swagger-ui to a spring-boot application:

Documentation will be available in HTML format, using the official "swagger-ui jars"

The Swagger UI page will then be available at "http://server:port/context-path/swagger-ui.html" and the OpenAPI description will be available at the following url for json format: "http://server:port/context-path/v3/api-docs"

Swagger UI can be accessed at http://localhost:9095/swagger-ui.html.


**10 Technologies Used**

Java

Spring Boot

Spring Data JPA

MySQL

Maven





