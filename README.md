#Purpose 
Source code for the blog entry 
http://mhdevelopment.wordpress.com/2014/02/23/my-start-with-neo4j-and-what-you-should-consider-when-starting-with-it

##What is required to use this code
* JAVA_HOME environment variable set to a JDK7
* Running MySQL Database with credentials root/root (can be changed in src/main/resources/application.yml
* Location configuration for the Neo4j embedded database is in mh.dev.blog.config.Neo4jConfig.java
* Database with name blog can also be changed in application.yml
* Eclipse or IntelliJ


##General usage
* execute gradlew eclipse or gradlew idea to create IDE specific files
* run mh.dev.blog.Application.java
