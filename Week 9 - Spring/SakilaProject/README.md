# Sakila Database Film Rental Project

<img align="right" width="250" height="250" src="https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%205%20-%20Java%20Week%203/DataMigrationProject/program%20screenshots/logo.png">

![java_badge](https://img.shields.io/badge/-Java-lightgrey?style=for-the-badge&logo=appveyor)
![spring_boot](https://img.shields.io/badge/-Spring%20Boot-green?style=for-the-badge&logo=appveyor)
![maven_badge](https://img.shields.io/badge/-Maven-yellow?style=for-the-badge&logo=appveyor) 
![database](https://img.shields.io/badge/-Database-orange?style=for-the-badge&logo=appveyor)
![my_sql](https://img.shields.io/badge/-My%20SQL-orange?style=for-the-badge&logo=appveyor)
![front_end](https://img.shields.io/badge/-Front%20End-purple?style=for-the-badge&logo=appveyor)
![agile](https://img.shields.io/badge/-Agile-blue?style=for-the-badge&logo=appveyor)
![scrum](https://img.shields.io/badge/-Scrum-red?style=for-the-badge&logo=appveyor)

### **Table Of Contents**
  * [**Overview**](#overview)
  * [**Technology**](#technology)
  * [**Observations**](#observations)
  * [**Screenshots**](#screenshots)
      - [Landing Page](#landing-page)
      - [Browse Films](#browse-films)
      	- [Film Details](#film-details)
      - [Browse Actors](#browse-actors)
      - [Login Page](#login-page)
      - [Customer Page](#customer-page)
      - [Owner Page](#owner-page)
      	- [Films' Details](#films-details)
      	- [Customers' Details](#customers-details)
      - [Sign Out](#sign-out)
  * [**Future Work**](#future-work)


## **Overview**
- A Web App front end for the Sakila database
- The database models the data associated with a film rental business
- The Web App will provide data for 3 levels of user:
	- Visitor: Will be able to see all information about films and actors (anyone who accesses the Web App with no credentials)
		- Browsing for films and actors made easier
		- Able to search by a specific film title, actor first/last name or film category
	- Customer: Will be able to see their own account information including which films they have rented
		- Allows for personalised experience for each customer
		- Able to rent a specific film
	- Owner: Has all levels of access and can write to the database. Can see all customer information and films that have been taken out
		- Allows for organised control when it comes to owners
		- Able to update the information of a specific film
		- Able to delete a specific film


## **Technology**
- Spring Boot
	- As a Java-based framework
- Thymeleaf
	- As a Java-based templating engine
- My SQL
	- As a database
- JUnit
	- Including Mock testing
- Scrum Framework within Agile


## **Observations**
- The entire project was built in less than 3 days as means of learning how to prioritise requirements in an agile environments
- Altering a database was the main struggle we faced with due to numerous primary-foreign key relationships between tables


## **Screenshots**

### **Landing Page**
- Once the application is started, the first page any user will see is the Landing Page that welcomes the user. User can choose further action from the navigation bar at the top of the screen.

![landing](https://github.com/janjakovacevic/TheSakilaProject/blob/master/sakila%20assets/landing-page.png)

### **Browse Films**
- Should a user choose to search all the available films, they would be directed to the page below. They can search for the film by the film title.

![films](https://github.com/janjakovacevic/TheSakilaProject/blob/master/sakila%20assets/browse-films.png)

#### **Film Details**
- User has the option to view film details by clickin on the hyperlinked film title. They will be redirected to the following page. It is important to note the user will be asked to log in should they choose to click on the `Rent Film` button.

![film_details](https://github.com/janjakovacevic/TheSakilaProject/blob/master/sakila%20assets/film-details.png)

### **Browse Actors**
- User can also choose to search for actors using their first name, last name or both. It should be noted that by clicking on the actor ID, user will be displayed with all the films the selected actor appears in.

![actors](https://github.com/janjakovacevic/TheSakilaProject/blob/master/sakila%20assets/browse-actors.png)

### **Login Page**
- By selecting the `Login` button in the navigation bar, the user will be prompted for their credentials. They will only be logged in if the credentials are valid.

![login](https://github.com/janjakovacevic/TheSakilaProject/blob/master/sakila%20assets/login-page.png)

### **Customer Page**
- If the credentials entered correspond to a customer, they will be recognised as a customer and then redirected to the customer page where they will be able to view their information including the films they have rented in the past.

![customer_page](https://github.com/janjakovacevic/TheSakilaProject/blob/master/sakila%20assets/customer-page.png)

### **Owner Page**
- If the credentials entered correspond to an owner's crednetials, they will be recognised as an owner and then redirected to the owner page where they will be able to view their information, perform admin actions as well as have an insight in the current count of customers and available films.

![owner_page](https://github.com/janjakovacevic/TheSakilaProject/blob/master/sakila%20assets/owner%20page.png)

#### **Films' Details**
- Should an owner want to take a closer look at the films the business offers, they can choose to select `View All Films` and they will be redirected to the following page. In addition to being able to browse for a specific film, they can view all the details for the selected film including the number of currently availble copies. They will also be able to performs `edit` or `delete` actions by selcting the corresponding option on `Action` column.

![films](https://github.com/janjakovacevic/TheSakilaProject/blob/master/sakila%20assets/films.png)

#### **Customers' Details**
- Should an owner want to take a closer look at the current customers of the business, they can choose to select `View All Customers` and they will be redirected to the following page. In addition to being able to browse for a specific customer, they will also be able to view their rental history by selecting `Detail` option in the `History` column.

![customers](https://github.com/janjakovacevic/TheSakilaProject/blob/master/sakila%20assets/customers.png)

### **Sign Out**
- Whenever the user chooses to sign out, all they have to do is navigate back to their profile page by selecting the `Customer Page` or `Owner Page` button (depending on their access level) in the top righ corner and then select the `Sign Out` button that can be found just above their user information.

## **Future Work**
- Allow user to type the input, instead of filtering it
- Allow search for films by language
- Allow for changes in the inventory to be made to reflect the most up to date rental status
- Add film/customer functionality
- Edit/delete customer functionality





