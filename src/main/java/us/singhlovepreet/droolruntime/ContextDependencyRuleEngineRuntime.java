package us.singhlovepreet.droolruntime;

import lombok.extern.java.Log;
import org.jboss.weld.environment.se.Weld;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import us.singhlovepreet.domain.model.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Log
@ApplicationScoped
public class ContextDependencyRuleEngineRuntime {

    @Inject
    @KSession
    private static KieSession kSession;

    public static void main(String[] args) {
        var weld = new Weld();
        var welContainer = weld.initialize();
        var classBean =  welContainer.instance().select(ContextDependencyRuleEngineRuntime.class).get();

        log.info("Test");
        //classBean.feedDataToRuleEngine();

    }

    private void feedDataToRuleEngine(){
        var item = Item.builder().id(101L).name("gift").cost(100d).salePrice(90d).build();
        var iphone = Item.builder().id(102L).name("IphonePro").cost(1000d).salePrice(950d).build();
        log.info("Item Category before Rule Engine Processing " + item.getCategory());
        log.info("Iphone Category before Rule Engine Processing " + iphone.getCategory());

        kSession.insert(item);
        kSession.insert(iphone);
        log.info("Item Category after Rule Engine Processing " + item.getCategory());
        log.info("Iphone Category After Rule Engine Processing " + iphone.getCategory());
    }
}
