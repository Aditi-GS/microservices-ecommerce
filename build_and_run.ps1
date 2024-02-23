# pre-docker commands
$ROOT_PATH="C:\Users\1037763\Desktop\Microservices"
$BUILD_JAR="./gradlew clean bootJar"

# JAR file + Build docker images
cd $ROOT_PATH\config-server
Invoke-Expression $BUILD_JAR
docker build -t config-server-image:v2 .

cd $ROOT_PATH\discovery-server
Invoke-Expression $BUILD_JAR
docker build -t discovery-server-image:v2 .

cd $ROOT_PATH\gateway-server
Invoke-Expression $BUILD_JAR
docker build -t gateway-server-image:v2 .

cd $ROOT_PATH\user-service
Invoke-Expression $BUILD_JAR
docker build -t user-service-image:v2 .

cd $ROOT_PATH\product-category-service
Invoke-Expression $BUILD_JAR
docker build -t product-category-service-image:v2 .

# run the docker compose up
cd $ROOT_PATH
docker-compose up 





