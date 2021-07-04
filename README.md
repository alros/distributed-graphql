# distributed-graphql
This is a demo to show how to integrate data-services exposing GraphQL API into one frontend node.

There are countries and countries contains cities. 

As a user I want to search countries, cities, cities from a country, and a country from a city.

- DistributedGraphql-cityService: this is the data service hosting cities
- DistributedGraphql-countryService: this is the data service hosting countries
- DistributedGraphql-main: this is the frontend node that integrates the other two services and exposes new GraphQL API
- DistributedGraphql-shared: a shared model, nothing special

