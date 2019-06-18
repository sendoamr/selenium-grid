#!/bin/sh
set -e

export HOST_HUB=172.27.0.2
mvn clean test -Dbrowser=chrome
