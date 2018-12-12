package com.glen.demo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities; 

import java.io.File;  
import java.net.URL;  
import java.util.List;

 
public class ContactsTest {
    private AppiumDriver driver; 
    @Before
    public void setUp() throws Exception {
        //设置apk的路径
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "ContactManager.apk");
        
        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "192.168.228.101:5555");
        
        //设置安卓系统版本
        capabilities.setCapability("platformVersion", "7.0");
        //设置apk路径
        capabilities.setCapability("app", app.getAbsolutePath()); 
        
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        
        //初始化
        //driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);    
        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities) {
			
			@Override
			public MobileElement scrollToExact(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MobileElement scrollTo(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		};
    }
 
    @Test
    public void addContact(){
        //WebElement el = driver.findElementByName("Add Contact");
    	driver.findElement(By.xpath(".//*[@resource-id='com.example.android.contactmanager:id/showInvisible']")).click();
    	//driver.findElement(By.xpath(".//*[@text='Show Invisible Contacts (Only)']")).click();
    	//WebElement el = driver.findElement(By.xpath(".//*[@text='Add Contact']"));
    	WebElement el = driver.findElement(By.xpath(".//*[@resource-id='com.example.android.contactmanager:id/addContactButton']"));
        el.click();
        
        driver.findElement(By.xpath(".//*[@resource-id='com.example.android.contactmanager:id/contactPhoneTypeSpinner']")).click();
        driver.findElement(By.xpath(".//*[@text='Work']")).click();
        //driver.findElement(By.xpath(".//*[@resource-id='android:id/text1']")).click();
        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("Some Name");
        textFieldsList.get(2).sendKeys("Some@example.com");
        driver.swipe(100, 500, 100, 100, 2);
        driver.findElement(By.xpath(".//*[@text='Save']")).click();
    }    
    
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}