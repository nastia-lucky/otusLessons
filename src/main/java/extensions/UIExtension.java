package extensions;

import annotations.Driver;
import factories.WebDriverFactory;
import listeners.Listener;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.AbsBaseUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class UIExtension extends AbsBaseUtils implements BeforeEachCallback, AfterEachCallback {


    @Override
    public void afterEach(ExtensionContext extensionContext) {
        if (driver != null) {
            driver.quit();
        }

    }

    private List<Field> getAnnotatedFields(Class<? extends Annotation> annotation, ExtensionContext context) {
        List<Field> fields = new ArrayList<>();
        Class<?> testClass = context.getTestClass().get();
        for (Field field : testClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(annotation)) {
                fields.add(field);
            }
        }
        return fields;
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        driver = new WebDriverFactory().create();
        List<Field> fieldsToInjects = getAnnotatedFields(Driver.class, extensionContext);
        EventFiringWebDriver myDriver = (EventFiringWebDriver) driver;
        myDriver.register(new Listener());
        for (Field field : fieldsToInjects) {
            if (field.getType().getName().equals(WebDriver.class.getName())) {
                field.setAccessible(true);
                field.set(extensionContext.getTestInstance().get(), driver);
            }
        }

    }
}
