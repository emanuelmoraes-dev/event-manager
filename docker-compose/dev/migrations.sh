#!/usr/bin/env sh

if ! aws dynamodb describe-table --table-name messages --endpoint-url http://dynamodb-local-dem:8000 --region us-west-2 > /dev/null; then
  aws dynamodb create-table \
    --table-name messages \
    --attribute-definitions AttributeName=id,AttributeType=S \
    --key-schema AttributeName=id,KeyType=HASH \
    --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
    --endpoint-url http://dynamodb-local-dem:8000 --region us-west-2
fi
