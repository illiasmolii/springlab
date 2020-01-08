docker stop mysql || true && docker rm mysql || true && \
docker stop app || true && docker rm app || true && \
docker network rm local || true && \
mvn clean package -DskipTests && \
docker network create local && \
docker run --network=local --name=mysql \
  -v "${PWD}"/database/src/main/resources/startup:/docker-entrypoint-initdb.d \
  -e MYSQL_ROOT_PASSWORD=admin \
  -e MYSQL_DATABASE=springlab \
  -d mysql:latest && \
docker run --network=local --name=app -p 8888:8080 illiasmolii/test:1.0-SNAPSHOT
