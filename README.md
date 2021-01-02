# Power recommender system

System recommending power source for buildings with usage of neo4j graph database. 


## How to configure Neo4j database

Precedure is explained for Windows 10 but will be similar for other operating systems.

1. Download and install Neo4j Destop from https://neo4j.com/download/ .
2. Create a project and database in it.
3. Make sure that offline mode is disabled (Neo4j Application settings) and in section Plugins download APOC. It must be downloaded each time while running new database. In settings of your database add line "apoc.import.file.enabled=true".
4. Put **powerreccon.json** file in import directory for your project instance, it will be similar to **C:\Users\USER\AppData\Local\Neo4j\Relate\Data\dbmss\dbms-05e3940c-67dc-4d3a-a50a-ef187b38c2cd\import** .
5. Run databse, open its browser and run cipher:
**CALL apoc.import.json("file:///powerreccon.json")**


## Running project

1. Download project.
2. In file **\neo4j\src\main\resources\application.properties** add username and password for your local database (user neo4j is default).
3. Run (all needed packages are included in pom.xml).
