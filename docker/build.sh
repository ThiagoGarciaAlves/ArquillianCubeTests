#!/usr/bin/env bash

if [[ $(pwd) == *ArquillianCubeTests ]]
then
    mvn clean install -DskipTests
    cp target/arquillian-cube-tests.war docker/
    docker build -t thiagogarciaalves/arquillian-cube-tests docker
    rm docker/arquillian-cube-tests.war
else
    echo "Execute da pasta 'ArquillianCubeTests' (docker/build.sh)"
fi



