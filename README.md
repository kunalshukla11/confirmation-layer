# confirmation-layer
Assumptions for the confirmation layer
-Trade Events coming via rest , 
  Can discuss on making it via MQ or kafka based on requirements


Future aspect for designing rule engine for defining confirmations
Instead of having database , we can use below Options
Json Static Rules
 Json can be used to write Rules for the client and list of confirmations
 Json itself could be externalised and may be updatable by business 
Using Dedicated rule engine to compile all the rules once and to be used while running the application**


Questions/Cofusions
Should the account be Long instead of string
How frequent rule changes for clients, Can we poll on interval or load on startup