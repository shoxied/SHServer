#!/usr/bin/env bash
CI_REGISTRY_IMAGE="sh-server"
VERSION=1.0.0
IMAGE=${CI_REGISTRY_IMAGE}:${VERSION}
#mvn clean package
echo "Version is ${VERSION}, Image name is ${IMAGE}"
docker build --build-arg VERSION=${VERSION} -t ${IMAGE} .
docker tag ${IMAGE} ${CI_REGISTRY_IMAGE}:latest