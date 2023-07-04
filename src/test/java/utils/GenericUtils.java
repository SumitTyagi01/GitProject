package utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    public WebDriver driver;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void SwitchWindowToChild() throws InterruptedException {

        String currentWindowhandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> I1 = handles.iterator();

        while (I1.hasNext()) {
            String child_window = I1.next();
            if(!currentWindowhandle.equals(child_window)){
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                Thread.sleep(2000);
            }
        }
    }
}
