#!/bin/bash

mvn clean package
mv target/main-jar-with-dependencies.jar target/resurface-ndjson-faker.jar
cloudsmith push raw resurfacelabs/release target/resurface-ndjson-faker.jar --version $1
