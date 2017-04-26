#!/usr/bin/env bash
mvn clean install -DskipTests
rm -rf $SERVER_HOME/standalone/deployments/arquillian-cube-tests.war
mv -f target/arquillian-cube-tests.war $SERVER_HOME/standalone/deployments/
$SERVER_HOME/bin/standalone.sh