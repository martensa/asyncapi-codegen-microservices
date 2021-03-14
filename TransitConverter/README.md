# TransitConverter

## Version 0.0.1

The TransitConverter microservice is converting the EmployeeCreated event into an object for data transfer. 
It should be exchanged with cloud services, where different security policies apply. 
One requirement is that confidential data needs to be encrypted before it is transferred to Microsoft Azure Event Hub, independent of having SSL/TLS in place or not. 
Therefore, HashiCorp Vault is used for encryption, decryption and management of the secrets.
