# spring-web-flux-poc

## Before run this application please do the following

Execute the following command to create necessarry tables
```aws dynamodb --endpoint-url http://localhost:4566 create-table --table-name customer-sync --attribute-definitions AttributeName=customerId,AttributeType=S --key-schema AttributeName=customerId,KeyType=HASH --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5```

Then execute the following command from spring-webflux-demo directory
```docker-compose up -d```
