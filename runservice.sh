#!/bin/sh
echo "clean install and run..."
echo $PWD
ls
./mvnw clean verify
./mvnw spring-boot:run

