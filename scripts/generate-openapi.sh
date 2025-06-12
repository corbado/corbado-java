#!/bin/sh

GENERATED_PACKAGE_NAME="generated"
SDK_PACKAGE_NAME="com/corbado"
GENERATED_PROJECT_NAME="corbado-java-generated"

echo "Generating OpenAPI code ..."

cd "$(dirname "$0")"
rm -rf .gen
mkdir -p .gen
cd .gen
rm -rf ../../src/main/java/$SDK_PACKAGE_NAME/$GENERATED_PACKAGE_NAME
mkdir -p ../../src/main/java/$SDK_PACKAGE_NAME/$GENERATED_PACKAGE_NAME

curl -s https://backendapi.cloud.corbado.io/v2/openapi.yaml -o backend_api.yml
docker pull openapitools/openapi-generator-cli
docker run -v ${PWD}:/local --user $(id -u):$(id -g) openapitools/openapi-generator-cli generate \
    -i /local/backend_api.yml \
    -g java \
    -o /local \
    --additional-properties=packageName=com.corbado.generated \
    --additional-properties=groupId=com.corbado \
    --additional-properties=artifactId=corbado-java-generated \
    --additional-properties=artifactVersion=1.0.0 \
    --additional-properties=invokerPackage=com.corbado.generated.invoker \
    --additional-properties=modelPackage=com.corbado.generated.model \
    --additional-properties=apiPackage=com.corbado.generated.api \
    --additional-properties=useSwaggerAnnotations=false

cp -r src/main/java/$SDK_PACKAGE_NAME/$GENERATED_PACKAGE_NAME/* ../../src/main/java/$SDK_PACKAGE_NAME/$GENERATED_PACKAGE_NAME
cd ..
rm -rf .gen



