#!/bin/bash

mvn clean package
mv target/main-jar-with-dependencies.jar target/resurface-simulator.jar
cloudsmith push raw resurfaceio/release target/resurface-simulator.jar --version $1
