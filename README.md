# Orange-Task
Spring boot + Angular 6 (RestfullAPI)

Technologies<br/>
Mandatory<br/>
⦁	MySQL Database  ✅ <br/>
⦁	Spring Framework  ✅ <br/>
⦁	Build Tool (i.e. Maven or Gradle)  ✅ <br/>
⦁	REST  ✅ <br/>
Bonus<br/>
⦁	ORM (i.e. Hibernate)  ✅ <br/>
⦁	Unit Test (i.e. Junit) (fully understand but not implemented) <br/>
⦁	Angular  ✅ (without login) <br/>

## Instructions to run backend
1- Just extract the BACKEND folder to STS(Spring Tool Suite) and run it as (Java Application) on port=8080.<br/>
2- For database you can excute the sql file in your Sql Editor (it contain database creation statement) OR
   Just create the database(name=store) maunally and run the application and it will create the Tables with it objects.<br/>
3- Then you can test iy using Postman.<br/>
<br/>
== Categories ==<br/>
Return all Categories (GET : localhost:8080/categories)<br/>
Return Category       (GET : localhost:8080/categories/{id})<br/>
Add Category          (POST : localhost:8080/categories) with json body<br/>
Update Category       (PUT : localhost:8080/categories) with json body<br/>
Delete Category       (DELETE : localhost:8080/categories/{id})<br/>
<br/>
== Products ==<br/>
Return all Products  (GET : localhost:8080/products)<br/>
Return Product       (GET : localhost:8080/products/{id})<br/>
Add Product          (POST : localhost:8080/products) with json body<br/>
Update Product       (PUT : localhost:8080/products) with json body<br/>
Delete Product       (DELETE : localhost:8080/products/{id})<br/>

== Relation between Products And Categories ==<br/>
Return all Products bassed on Category (GET : localhost:8080/categories/{id:Category}/products)<br/>
<br/>
Here is a Video by me running the backend project and test it using postman >><br/>
https://www.youtube.com/watch?v=4c8GZKw0n-M<br/>
<br/>
## Instructions to run frontend
1- Extract the FRONT-END to youe text editor and just run (ng serve)on port(4200) for angular ((6)) after installing node.js and angualr-cli.<br/>
2- To fully functional project you must run spring boot in background.<br/>
<br/>
Here is a Video by me running the fully functional project (backend + frontend) >><br/>
https://www.youtube.com/watch?v=KckXnNcow2A<br/>


