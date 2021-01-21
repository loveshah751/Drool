#Drool Rule Language Syntax

####This Branch will cover everything you should know while writing the rule in DRL.

<p> What is DRL and what is usage of it in the rule Engine ?</p>

<p> DRL stands for Drool Rule Language provided by RED HAT Inc, used to write business rule for the object Oriented languages like JAVA.</p>

Simple Syntax of Writing any rule in DRL as:
 * First create a file with extension drl i.e. <b>Example.drl</b>.
 * After Creating the drl file. The content of the file should always be like below with adds on according to the requirement and need.
 * Starts with <b>rule keyword</b> then define the Name of the Rule, which is String. For Instance: <b>rule "generating the PromoCode."</b>
 * After defining the Name of the rule, then we define the condition or Business Reason for the rule, which starts <b>when Keyword and then condition of the rule. </b>
 For Instance 
    ~~~~
    When
        $customer: Customer(category == CustomerCategory.SILVER)
        $order : Order(customer == $customer)
   
   # When part of the Rule is called as left-hand side (LHS) of the Rule.
    ~~~~
 * After defining the LHS of the rule, we need a block for the action part, which means whenever the condition in <b> When</b> becomes true,
 rule Engine needs to perform some processing. To do so, there a block in the rule syntax which is called <b> then block</b>.
 For Instance 
 
    ~~~~
    then
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(1);
         insert(new PromoCode($customer,$order,PromoCodeType.POINTS,startDate,endDate));
   
   # then part of the Rule is called as right-hand side (RHS) of the Rule.
    ~~~~
  * When we define the LHS and RHS of the Rule, then at last we use <b> end</b> keyword, to specify the end of the rule. 
 
    #####  example.drl File should Like this
    ~~~~
    package us.singhlovepreet.rules;
    import us.singhlovepreet.domain.enumvalue.CustomerCategory;
    import us.singhlovepreet.domain.enumvalue.PromoCodeType;
    import us.singhlovepreet.domain.model.Customer;
    import us.singhlovepreet.domain.model.Order;
    import us.singhlovepreet.domain.model.PromoCode;
    import java.time.LocalDate;
    
    /**
    Business rule :
    If the customer  falls under the silver category, generate the promoCode of Pionts for that Custoner
    **/
    
    rule "generating the PromoCode for Customer Category of Silver"
    
    when
        $customer: Customer(category == CustomerCategory.SILVER)
        $order : Order(customer == $customer)
        then
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(1);
         insert(new PromoCode($customer,$order,PromoCodeType.POINTS,startDate,endDate));
         end
    ~~~~
    
    Above example is very basic rule, and we will be going to talk about each block in more details, and some other powerful
    features which can be used with above structure to solve various common problem encounter while writing the business rule.
    
  
