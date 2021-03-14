# asyncapi-codegen-microservices

## Overview
This repo contains code artifacts that were used in my AsyncAPI Code Generation Blogs + Videos.

* [Video Link](https://youtu.be/rjvG62nPxCk)

## Artifacts
* *Acme_Rideshare_EP_Export.json*: This is my Solace Event Portal Acme Rideshare Application Domain Export
* *Acme_Rideshare_HR_EP_Export.json*: This is my Solace Event Portal Acme Rideshare HR Application Domain Export
* *TransitConverter.yaml*: This is the AsyncAPI document I exported from the Event Portal and used for Code Generation
* *TransitConverter/*: This directory is what was generated from from the AsyncAPI Code Generator
* AsyncAPI Code Gen Command: `ag --force-write -o TransitConverter -p binder=solace -p view=provider -p actuator=true -p artifactId=TransitConverter -p groupId=acme.rideshare.hr -p javaPackage=acme.rideshare.hr -p javaClass=TransitConverterApplication -p host=localhost:55555 -p username=default -p password=default -p msgVpn=default -p springBootVersion=2.4.3 -p springCloudVersion=2020.0.1 ~/Downloads/TransitConverter.yaml @asyncapi/java-spring-cloud-stream-template`
* Run Command:
  * `cd TransitConverter/`
  * `mvn spring-boot:run`

## License

This project is licensed under the Apache License, Version 2.0. - See the [LICENSE](LICENSE) file for details.

## Resources

For more information try these resources:

- The Solace Developer Portal website at: https://solace.dev
- Ask the [Solace Community](https://solace.community)
