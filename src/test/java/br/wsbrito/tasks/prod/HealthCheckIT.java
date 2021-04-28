package br.wsbrito.tasks.prod;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HealthCheckIT {
	
	@Test
	public void healthCheck() {
		System.setProperty("webdriver.chrome.driver", "/home/wsbrito/Desenv/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:9999/tasks/");
		try {
			// Configuring a wait strategy
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String versionText = driver.findElement(By.id("version")).getText();
			Assert.assertTrue(versionText.startsWith("build"));
		} finally {
			driver.quit();
		}
	}

}
