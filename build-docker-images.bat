cd ./config && ^
mvn -DskipTests clean install && ^
docker build -t cloud-config:0.0.1-SNAPSHOT . && ^
cd ../naming-server && ^
mvn -DskipTests clean install && ^
docker build -t naming-server:0.0.1-SNAPSHOT . && ^
cd ../ms-job && ^
mvn -DskipTests clean install && ^
docker build -t job-microservice:0.0.1-SNAPSHOT . && ^
cd ../ms-department && ^
mvn -DskipTests clean install && ^
docker build -t dept-microservice:0.0.1-SNAPSHOT . && ^
cd ../ms-employee && ^
mvn -DskipTests clean install && ^
docker build -t emp-microservice:0.0.1-SNAPSHOT . && ^
cd ..

