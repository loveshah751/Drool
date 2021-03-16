<h1>Rule Attribute</h1>

<p>
Rule Attributes are extra feature that we can add to our rules, to modify their their behavior in 
a specific way.
</p>
<label>There are many rule attribute provided by drool framework.</label>

* Enabled Flag : Enable a flag is one of the attribute used to turn on/off the execution of the rule.
 so if Enable flag set to false, the rule be evaluated but will not be executed. <br>
 <b>Rule Engine will first evaluate the LHS Condition of the rule, if it satisfied then 
 rule attribute enable flag will control the execution of the rule based on the value.</b>

  ~~~~
   rule "simple attribute Example"
   enabled false

         When Customer()
         then System.out.println("We Have Customer")
  end
  ~~~~

* salience : sometime, there is a situation when we want certain rules to be executed first before 
some other rule should execute. In that case, we add the salience rule attribute to our rule. Rule with
higher salience will be executed first. 

    ~~~~
       rule "Pre-Processing"
       salience 2
             When Customer()
             then System.out.println("We Have Customer")
  end
       rule "Processing"
         salience 1
               When Customer()
               then System.out.println("Customer is processing now.....")
  end
     ~~~~
  In our example we want pre-processing should be executed first before the actual processing of our data.So, by adding
  salience, we are forcing rule engine to run rule with higher salience first before executing the rule with lower
  salience.
  <b>By Default, rule Engine add the salience value of 0 to all the rules.</b>
  
 * no-loop: As we know, whenever any rule modify or update the data within working memory, rule engine re-evaluate all
 the rule again. But, sometime there might be possibility that we want the rule which modify the data should not be 
 re-evaluate by the rule engine. 
 
     ~~~~
        rule "Classify Mid range Item"
              When 
                 $i : Item(price > 200 && price < 500, category == NA)
              then 
                 $i.setCategory(Mid_Range)
                update($i)
        end
   
        rule "Classify Mid/High Range Item(Special)"
        no-loop
        salience 2
            When 
             $i : Item(price > 300 && price < 400)
            then 
                $i.setCategory(SPECIAL_MIDHIGH_RANGE)
                update($i)
         end
      ~~~~
   
   In our example, if we don't have no-loop attribute defined and let's say the price of item in the working memory is 
   $350, now with above rules, rule with higher salience will execute first by rule engine, and then we classify item as
   SPECIAL_MIDHIGH_RANGE, rule will modify the item available in working memory with this item with SPECIAL_MIDHIGH_RANGE.
   So, after updating, rule engine will re-trigger all the rules and again this rule will evaluate to true and executed 
   again. Rule Engine, will keep on executing this rule and will be in infinite cyclic loop. 
   
   So Inorder to avoid the infinite cyclic loop, we can change rule condition by adding one more attribute evaluation to
   second rule, or we can use use <b> no-loop </b> attribute, which will enforce the rule engine not to re-trigger the 
   rule which update the data in the working memory.
   
   
 * Agenda-group 