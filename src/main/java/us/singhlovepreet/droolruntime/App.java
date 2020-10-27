package us.singhlovepreet.droolruntime;

import lombok.extern.java.Log;
import org.kie.api.KieServices;
import us.singhlovepreet.domain.model.Item;

@Log
public class App {

    public static void main(String[] args) {

        log.info("BootStrapping the Rule Engine");

        var kieServices = KieServices.Factory.get();
        var kieContainer = kieServices.getKieClasspathContainer();
        var kieSession = kieContainer.newKieSession();
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
}
