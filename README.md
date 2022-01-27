# Associations API

This repository contains the graphql representation of the api to provide access to the information contained in the association.json file.

The application was built using Java Spring Boot and Maven.

### Configuration steps
The application contains a base application config file in YAML format with some graphql configuration and the key for the JSON file path. To configure the api you'll need set the path for the association file in the config key ASSOCIATIONS_FILE.

Once the file path has been assigned you'll be able to run the application from you IDE or build it and run it.

### Unit tests
The unit tests run using a sample associations file. Thus, you won't need to perform any additional configuration to run them.