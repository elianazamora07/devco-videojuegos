# Iniciar App contenerizada

## Generar Artefacto 
mvn clean package
mvn compile
mvn install

## Generar imagen del Docker 
docker build -t devco-video-juegos .

## Generar contenedor de la BD 
docker pull mysql:latest
docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=sa -e MYSQL_DATABASE=tiendavideojuegos -e MYSQL_USER=sa -e MYSQL_PASSWORD=sa -d mysql:latest
docker exec -it mysql-standalone bash -l

## Generar contenedor de la aplicacion con conexion a la BD 
docker run -d -p 8080:8080 --name devco-video-juegos --link mysql-standanole:mysql devco-video-juegos
