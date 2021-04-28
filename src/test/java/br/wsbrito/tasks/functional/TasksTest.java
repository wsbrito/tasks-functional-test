package br.wsbrito.tasks.functional;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
//	public void testAmbiente() {
//		System.setProperty("webdriver.chrome.driver", "/home/wsbrito/Desenv/drivers/chromedriver");
//		WebDriver driver = new ChromeDriver();
//		driver.navigate().to("http://www.google.com");
//	}
	
	/*
	 * ps aux | grep chromedriver
	 * killall chromedriver
	 **/
	
	public WebDriver getApplicationBrowser() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "/home/wsbrito/Desenv/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
//		URL url = new URL("http://172.18.0.1:4444/wd/hub/");
//		DesiredCapabilities cap = DesiredCapabilities.chrome();
//		WebDriver driver = new RemoteWebDriver(url,cap);
		
		// Acessa the main page of application
		driver.navigate().to("http://192.168.0.109:8080/tasks/");
		//driver.navigate().to("http://localhost:9999/tasks/");
		
		// Configuring a wait strategy
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() throws MalformedURLException {
		
		WebDriver driver = getApplicationBrowser();
		try {
			
			// Click on button "Add Todo"
			// id="saveButton"
			driver.findElement(By.id("addTodo")).click();
			
			// Fill "Task" - id="task"
			driver.findElement(By.id("task")).sendKeys("Testing by Selenium");
			
			// Fill "Due Date" - id="dueDate"
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2021");
			
			// Click "Save" button - id="saveButton"
			driver.findElement(By.id("saveButton")).click();
			
			// Verify "Sucess" messagem on screen - id="message"
			String message = driver.findElement(By.id("message")).getText();
			
			// Validating message
			Assert.assertEquals("Success!", message);
			
		} finally {
			// Close browser window
			driver.quit();
		}
		
	}
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() throws MalformedURLException {

		WebDriver driver = getApplicationBrowser();
		try {
			
			// Click on button "Add Todo"
			// id="saveButton"
			driver.findElement(By.id("addTodo")).click();
			
			// Fill "Task" - id="task"
			driver.findElement(By.id("task")).sendKeys("Testing by Selenium");
			
			// Fill "Due Date" - id="dueDate"
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2010");
			
			// Click "Save" button - id="saveButton"
			driver.findElement(By.id("saveButton")).click();
			
			// Verify "Sucess" messagem on screen - id="message"
			String message = driver.findElement(By.id("message")).getText();
			
			// Validating message
			Assert.assertEquals("Due date must not be in past", message);

		} finally {
			// Close browser window
			driver.quit();
		}
		
	}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() throws MalformedURLException {

		WebDriver driver = getApplicationBrowser();
		try {

			// Click on button "Add Todo"
			// id="saveButton"
			driver.findElement(By.id("addTodo")).click();
			
			// Fill "Due Date" - id="dueDate"
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2021");
			
			// Click "Save" button - id="saveButton"
			driver.findElement(By.id("saveButton")).click();
			
			// Verify "Sucess" messagem on screen - id="message"
			String message = driver.findElement(By.id("message")).getText();
			
			// Validating message
			Assert.assertEquals("Fill the task description", message);
			
			
		} finally {
			// Close browser window
			driver.quit();
		}
		
	}

	@Test
	public void naoDeveSalvarTarefaSemData() throws MalformedURLException {

		WebDriver driver = getApplicationBrowser();
		try {
			
			// Click on button "Add Todo"
			// id="saveButton"
			driver.findElement(By.id("addTodo")).click();
			
			// Fill "Task" - id="task"
			driver.findElement(By.id("task")).sendKeys("Testing by Selenium");
			
			// Click "Save" button - id="saveButton"
			driver.findElement(By.id("saveButton")).click();
			
			// Verify "Sucess" messagem on screen - id="message"
			String message = driver.findElement(By.id("message")).getText();
			
			// Validating message
			Assert.assertEquals("Fill the due date", message);

		} finally {
			// Close browser window
			driver.quit();
		}
		
	}
	
}
