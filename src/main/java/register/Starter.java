package register;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import register.rest.MarriageController;
import register.viev.MarriageRequest;

public class Starter {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"springContext.xml"}
        );

//        MarriageController controller = context.getBean(MarriageController.class);
//        MarriageController controller = context.getBean("controller", MarriageController.class);
//        controller.findMarriageCertificate(new MarriageRequest());
    }
}
