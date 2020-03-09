#!/bin/sh

set -e

cd lambda/custom
./mvnw clean package
sls package
sls deploy

cd ../..
ask deploy -t skill
ask deploy -t model
