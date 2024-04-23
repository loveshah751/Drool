<h1>Global Variable in Drools</h1>

Most of the time, rule engine evaluate our business rules based on the data that feed into the drool working Memory.

<p>
But, There might be possibility that during the rule evaluation, we want some external data to be part of it without 
the actual insertion of the data inside the working memory. The one reason for that will be, let say that data is coming 
from some other partner api's, and that data from api's is only required for specific condition. Then at this point of 
the time drool provide a mechanism, to let our business rule's interact with external data using Global Variables.
</p>

Also, Global variable can be used for cross-cutting concern's within the application like logging. 

***Syntax to define Global variable in drools***
  ~~~~
    global DataType variableName;
  ~~~~
Check the GiftSuggestion.drl file for the example. <br>
@Note -> global variable should be defined in the top of the drl file and variable name of the global variable should 
match with one define in KieSession.
For example; 
  ~~~~
  kieSession.setGlobal("emailNotificationService", new EmailNotificationService());
  global EmailNotificationService emailNotificationService;
  ~~~~