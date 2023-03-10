
## Entity Relationship Diagram

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)


# ECommerceApp

Created an ECommerce app endpoints. Users can login,signin and check any products and puchase it with wallet money.


## Features

- Signup,Login with JWT token
- User and Admin functions
- Check all products and its reviews 
- Check products sorted by price
- User can give review
- Add money to wallet
- purchase product 
- Admins can add,delete or update products
- user can give reviews
- Add or remove items from cart


## API Reference

#### created APIs related to GET, POST, DELETE,PUT and PATCH


## Optimizations

In progress...


## Deployment

As of now it is deployed on Railway Cloud

```bash
ecommerceapp-production-488e.up.railway.app```


## Installation

Install and run with following properties if want to run locally

```bash
#changing the server port
server.port=8038
spring.datasource.url=jdbc:mysql://${DB_HOST:localhost}:${DB_PORT:3306}/${DB_NAME:eApp}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:sql@subhajit51193}

#spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# App Properties
ecommerce.app.jwtCookieName= subhajit
ecommerce.app.jwtSecret= subhajitSecretKey
ecommerce.app.jwtExpirationMs= 86400000

```
    
## Demo

https://drive.google.com/file/d/1AfYGaK2gYr1ww1z252G8yTgjWjwcHAOH/view?usp=sharing


## Tech Stack

**Client:** Java, SpringBoot, Maven, MySQL

**Server:** Embeded


## Authors

- [@Subhajit Saha](https://github.com/subhajit51193)


## Feedback

If you have any feedback, please reach out to us at nnorth87@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://subhajit51193.github.io/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/subhajit-saha-103110185/)



