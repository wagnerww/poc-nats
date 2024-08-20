
# Compilar e empacotar o projeto
mvn clean install package -U -DskipTests=true

# Subir o ambiente Docker com o NATS
cd sandbox
docker-compose up -d

