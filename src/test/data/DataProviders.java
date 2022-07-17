package data;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviders {

    @DataProvider(name = "homePageLinkTitles")
    public Object[] dpMethod(Method m) {
        switch (m.getName()) {
            case "test02":
                return new Object[]{"Demo Script Test drive - PHPTRAVELS"};
            case "test03":
                return new Object[]{"Demoaut.com"};
            case "test04":
                return new Object[]{"The Internetz"};
            case "test05":
                return new Object[]{"My Store"};
            case "test06":
                return new Object[]{""};
            case "test07":
                return new Object[]{"Swag Labs"};
            case "test08":
                return new Object[]{"Typescript React Shopping cart"};
        }
        return null;
    }
}
