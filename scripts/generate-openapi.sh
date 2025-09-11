#!/bin/sh
set -euo pipefail

GENERATED_PACKAGE_NAME="generated"
SDK_PACKAGE_NAME="com/corbado"
GENERATED_PROJECT_NAME="corbado-java-generated"

echo "Generating OpenAPI code ..."

cd "$(dirname "$0")"
rm -rf .gen
mkdir -p .gen
cd .gen
rm -rf "../../src/main/java/$SDK_PACKAGE_NAME/$GENERATED_PACKAGE_NAME"
mkdir -p "../../src/main/java/$SDK_PACKAGE_NAME/$GENERATED_PACKAGE_NAME"

mkdir -p templates

cp ../backend_api.yml backend_api.yml
cp ../common.yml common.yml
cp ../ApiClient.mustache templates/ApiClient.mustache

# --- 1) Generate with our overridden template (force okhttp-gson) ---
docker pull openapitools/openapi-generator-cli

docker run --rm --name corbado-openapi-gen -v "${PWD}:/local" --user "$(id -u):$(id -g)" \
  openapitools/openapi-generator-cli generate \
    -i /local/backend_api.yml \
    -g java \
    -o /local \
    -t /local/templates \
    --additional-properties=packageName=com.corbado.generated \
    --additional-properties=groupId=com.corbado \
    --additional-properties=artifactId=corbado-java-generated \
    --additional-properties=artifactVersion=1.0.0 \
    --additional-properties=invokerPackage=com.corbado.generated.invoker \
    --additional-properties=modelPackage=com.corbado.generated.model \
    --additional-properties=apiPackage=com.corbado.generated.api \
    --additional-properties=useSwaggerAnnotations=false \
    --additional-properties=disallowAdditionalPropertiesIfNotPresent=false

# --- 2) Verify the override actually applied ---
GEN_API_CLIENT="src/main/java/com/corbado/generated/invoker/ApiClient.java"

if [ ! -f "$GEN_API_CLIENT" ]; then
  echo "ERROR: Generated ApiClient.java not found at $GEN_API_CLIENT" >&2
  echo "Hint: Check the invokerPackage and selected library." >&2
  find src -name ApiClient.java || true
  exit 1
fi

# Check for our injected exception string
if ! grep -q 'TLS verification disabled (verifyingSsl=false). Refusing to install insecure TrustManager.' "$GEN_API_CLIENT"; then
  echo "ERROR: Template override did NOT apply to generated ApiClient.java" >&2
  echo "Diagnostics:" >&2
  grep -n 'applySslSettings' "$GEN_API_CLIENT" || true
  grep -n 'okhttp3' "$GEN_API_CLIENT" || echo "No okhttp3 import found; are you generating jersey instead of okhttp-gson?" >&2
  exit 1
fi

# --- 3) Copy generated sources into your project tree ---
cp -r "src/main/java/$SDK_PACKAGE_NAME/$GENERATED_PACKAGE_NAME/"* "../../src/main/java/$SDK_PACKAGE_NAME/$GENERATED_PACKAGE_NAME"

cd ..
rm -rf .gen

echo "✅ Generation complete and secure applySslSettings() injected."
