#!/bin/sh
set -e

export HOST_HUB=172.27.0.2
mvn compile
mvn exec:java -Dexec.mainClass="com.bbva.selenium.Main"
