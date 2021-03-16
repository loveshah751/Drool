<h1> Working Memory in Drool </h1>

So as we Know, rule engine is responsible for running our all the rules we have defined. Only role for us is to feed the 
data to the rule Engine to start its processing. So Whenever we feed a data to rule Engine, where that data goes inside the Rule Engine.
Actually, that data (also known as <b> facts </b> in drools framework) is stored in drool working memory just like JVM in Java, from which rule Engine refers to data
and tries to process the LHS of the Rule and perform actions. 

***So How Rule Engine evaluate the LHS of the rule and perform actions defined in RHS of the Rule, we will discuss the drools internals in this link Here.***

So Working Memory plays the significant role in the execution of the Rule Engine. We will discuss the benefits here.

In Java, Whenever we have to write complex business logic or may be a function or method, which cannot be written in one method, 
with series of instruction. There are a couple of reason for that, the most important one is single responsibility of the method 
will be violated and writing all the logic in one method makes to difficult from maintenance perspective. To Solve this issue,
we break down the functionality of bigger complex method in many smaller and simpler methods.

Similarly, in drools if we have complex business rule, we can follow same pattern of defining the multiple simple rules. 
But, due to declarative approach of rule Engine, in which rule engine decides which rule need to be executed and when 
it needs to be executed. So, We can't call one rule to another one. So, How do we split our rules that it doesn't violate
Rule Engine declarative approach.

***This is where drool working Memory comes into the picture. So Whenever we split our complex business rules into simpler rules, 
any kind of action (modification/creating) performed by one rule on the data, the result of that rule will be updated or inserted 
into working Memory, so that rule Engine can evaluate those updation or insertion  of data and tries evaluate the condition of all the rules,
including the one which update the working Memory. If the condition evaluates to be true, then RHS of the rule will be executed.***

### Various Action that can be performed by Rule on Working Memory
* Insert : Insert Keyword will insert the new object inside the working Memory, and rule Engine will evaluate all the rules again. 
Refer to src/main/resources/rules/workingMemory/InsertKeywordRules for the examples.

* Modify : To modify the existing data available inside the working memory, drools provide two mechanism one is Modify Keyword
and another one is update Keyword. Refer to src/main/resources/rules/workingMemory/ModifyKeywordRules for the examples.

* Delete : Delete Keyword is used to remove the invalid data from the working memory of drools.
 Refer to src/main/resources/rules/workingMemory/DeleteKeywordRules for the examples.