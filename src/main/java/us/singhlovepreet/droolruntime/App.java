package us.singhlovepreet.droolruntime;

import lombok.extern.java.Log;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import us.singhlovepreet.domain.enumvalue.CustomerCategory;
import us.singhlovepreet.domain.enumvalue.OrderStatus;
import us.singhlovepreet.domain.model.Customer;
import us.singhlovepreet.domain.model.Item;
import us.singhlovepreet.domain.model.Order;
import us.singhlovepreet.domain.model.OrderQuantity;
import us.singhlovepreet.domain.service.EmailNotificationService;

import java.time.LocalDate;
import java.util.List;

@Log
public class App {

    public static void main(String[] args) {

        log.info("BootStrapping the Rule Engine");

        var kieServices = KieServices.Factory.get();
        var kieContainer = kieServices.getKieClasspathContainer();
        var kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("emailNotificationService", new EmailNotificationService());
        workingMemoryRuleExecution(kieSession);
    }

    private void simpleRuleExecution(KieSession kieSession) {
        var item = Item.builder().id(101L).name("gift").cost(100d).salePrice(90d).build();
        var iphone = Item.builder().id(102L).name("IphonePro").cost(1000d).salePrice(950d).build();

        log.info("Item Category before Rule Engine Processing " + item.getCategory());
        log.info("Iphone Category before Rule Engine Processing " + iphone.getCategory());
        kieSession.insert(item);
        kieSession.insert(iphone);
        kieSession.fireAllRules();

        log.info("Item Category after Rule Engine Processing " + item.getCategory());
        log.info("Iphone Category After Rule Engine Processing " + iphone.getCategory());
    }

    private static void workingMemoryRuleExecution(KieSession kieSession) {
        var customer = Customer.builder().customerId(101L).age(30).name("Motta").email("example@example.com").category(CustomerCategory.GOLD).build();
        var item = Item.builder().id(101L).name("Pizza").cost(5d).salePrice(10d).build();
        var customer1 = Customer.builder().customerId(102L).age(30).name("NewCustomer").email("abc@example.com").category(CustomerCategory.NA).build();
        var order = Order.builder().orderId(1L).orderDate(LocalDate.now()).customer(customer1)
                .status(OrderStatus.COMPLETED).orderQuantities(List.of(OrderQuantity.builder().itemPurchased(item).itemQuantity(1).build()
                ,OrderQuantity.builder().itemPurchased(item).itemQuantity(1).build())).build();

        log.info("Customer1 Category Before Rule Engine Processing " + customer1.getCategory());
        kieSession.insert(customer);
        kieSession.insert(customer1);
        kieSession.insert(item);
        kieSession.insert(order);
        kieSession.fireAllRules();

        log.info("Customer1 Category After Rule Engine Processing " + customer1.getCategory());
    }


}
