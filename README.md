# IETI-LAB02-MongoDB

## AUTOR.

> Eduardo Ospina Mejia



### Desplegando localmente.

En esta seccion se daran intrucciones de como descargar y correr localmente la API REST de users:

##### Requisitos:
1)   [Java 11](https://www.java.com/download/ie_manual.jsp) 
2)   [Git](https://git-scm.com/downloads) 
3)   IDE de java. (intellij o visual studio code)

##### Despliegue local API

para esto se siguen los siguientes pasos:

1) clonar el repositorio, ya se a traves de cmd o de GIT: 

	git clone https://github.com/eduardoospina/IETI-LAB02-MongoDB.git

2) ingresamos al proyecto clonado y desde cmd hacer uso de gradle. 

```maven
	gradle build
      gradlew bootRun
```


3) Ejecutamos el proyecto utilizando los comandos en el cmd o corremos directamente desde la ide.


### Desarrollo:


#### Part 1: Creating your Atlas account and first cluster:

If you haven't created your MongoDB Cluster follow part 1 - 4:

![](https://i.postimg.cc/jSFHTPWW/Mongo-DB-creacion.png)


#### Part 2: Connecting my MongoDB Cluster with Spring Boot

    1) Login into your MongoDB Atlas account

    2) Click connect on the cluster you created on Part 1:

    3) Select Connect your application:

    4) Choose the Java driver, select the latest version and copy the connection string:

![](https://i.postimg.cc/264hnt0v/conexion-Mongodb.png)

    5) Replace the password on the connection string with the password used when creating your database user.

    6) Add an Environment Variable to the application.properties file to store the MongoDB URI:

    		spring.data.mongodb.uri=${MONGODB_URI}


![](https://i.postimg.cc/wBNmdP8P/aplication-property-mongodb.png)


    7) Add the environment variable to IntelliJ Idea by editing the Run/Debug Configurations:


![](https://i.postimg.cc/j2cfF70S/variableambiente-mongofb-conection.png)

    8) Add the Spring Boot starter data MongoDB dependency to your build.gradle:

       dependencies {
            implementation 'org.springframework.boot:spring-boot-starter-web'
            implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
            testImplementation 'org.springframework.boot:spring-boot-starter-test'
        }

    9) Run your project and verify that the connection is successful.

![](https://i.postimg.cc/bNYk23kD/conexionmongodb-correcta.png)

    10) To avoid future problems connecting to your Atlas instance (because of ip whitelist) find the way to allow connections from any Ip (not recommended for real-world applications)
		
		1.
![](https://i.postimg.cc/GmtcYsXx/ipallowance-1.png)

		2.
![](https://i.postimg.cc/nhWn1c5b/ipallowance-2.png)

		3.
![](https://i.postimg.cc/N0rBCvqy/ipallowance-3.png)

		4.
![](https://i.postimg.cc/FRymmbKN/ipallowance-4.png)


#### Part 3: Implementing the MongoDB Service

    1) Create a new package called repository.

    2) Modify your current User class to use MongoDB notations:

      import org.springframework.data.annotation.Id;
      import org.springframework.data.mongodb.core.index.Indexed;
      import org.springframework.data.mongodb.core.mapping.Document;
      
      import java.util.Date;
      
      @Document
      public class User
      {
         @Id
         String id;
      
         String name;
      
         @Indexed( unique = true )
         String email;
      
         String lastName;
      
         Date createdAt;
      
         public User()
         {
         }
      }

    3) Create a new interface called UserRepository inside the repository package:

      import org.springframework.data.mongodb.repository.MongoRepository;
      
      public interface UserRepository extends MongoRepository<User, String>
      {}

    4) Create a new UserService implementation called UserServiceMongoDB and inject inside the UserRepository:

       import java.util.List;
       
       public class UserServiceMongoDB
       implements UserService
       {
       
           private final UserRepository userRepository;
       
           public UserServiceMongoDB(@Autowired UserRepository userRepository )
           {
               this.userRepository = userRepository;
           }
       
           @Override
           public User create( User user )
           {
               return null;
           }
       
           @Override
           public User findById( String id )
           {
               return null;
           }
       
           @Override
           public List<User> all()
           {
               return null;
           }
       
           @Override
           public boolean deleteById( String id )
           {
               return false;
           }
       
           @Override
           public UserDto update( User user, String id )
           {
               return null;
           }
       }

    5) Implement the methods of the UserServiceMongoDB using the UserRepository.

    6) Remove the @Service annotation from the UserServiceHashMap and add it to the UserServiceMongoDB.

    7) Test your API and verify that your data is stored in your cluster.


##### Estructure: 

![]()




### Insomnia: 


##### getall()
![]()

##### create()
![]()
##### create()
![]()

##### getall()
![]()

##### findbyid()
![]()

##### update()
![]()

##### getall()
![]()

##### delete()
![]()

##### getall()
![]()













