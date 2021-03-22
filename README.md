# Telia Direction Reduction Challenge #

Small assignment to evaluate direction reduction from the array of possible directions.


# To run the project # 

Java 11 is required to run the project. 

spring-boot-starter artifact is being used explicitly with the reason. This small application could add-on more features iin future like use REST API to perform reduction or enabling persisting layer to support CRUD operations. So it could be small microservice or reuseable compenent which can be extended easily if required so in the future.    

To run the project
    
    mvn clean install
    
    
    -- Test it like ordinary jar project like example cases below:
    
    java -jar target/direction-reduction-0.0.1-SNAPSHOT.jar  "NORTH" "SOUTH"
        // return []
    java -jar target/direction-reduction-0.0.1-SNAPSHOT.jar  "NORTH"
        // return [NORTH]        
    java -jar target/direction-reduction-0.0.1-SNAPSHOT.jar
        // return []
    java -jar target/direction-reduction-0.0.1-SNAPSHOT.jar  "NORTH" "SOUTH" "EAST" "WEST"
        // return []
    java -jar target/direction-reduction-0.0.1-SNAPSHOT.jar  "NORTH" "EAST" "WEST" "SOUTH" "WEST" "WEST"
        // return [WEST,WEST]
    java -jar target/direction-reduction-0.0.1-SNAPSHOT.jar  "NORTH" "SOUTH" "SOUTH" "EAST" "WEST" "NORTH" "WEST"
        // return [WEST]
    java -jar target/direction-reduction-0.0.1-SNAPSHOT.jar  "NORTH" "SOUTH" "SOUTH" "EAST" "WEST" "NORTH"
        // return []
    java -jar target/direction-reduction-0.0.1-SNAPSHOT.jar  "NORTH" "WEST" "SOUTH" "EAST"
        // return [NORTH, WEST, SOUTH, EAST]
    
    
