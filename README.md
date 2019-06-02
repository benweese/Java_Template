## Name
This project is for ...

## Motivation
Details...

## Build status of master

[![Build Status](https://travis-ci.org/benweese/javaautomation.svg?branch=master)](https://travis-ci.org/benweese/javaautomat------=---

## Tools?????????--------
"""""""
"=ed

<b>BDD framework used</b>
- [Cucumber](https://cucumber.io/)
- [Serenity](http://www.thucydides.info/)

UH^       b<b>Built with</b>
- [Eclipse IDE](https://www.eclipse.org/downloads/)

<b>Testing Language</b>
- [Selenium](https://www.seleniumhq.org/)

<b>Code Used for Better Reporting</b>
- [Awesome Newman HTML Template](https://github.com/MarcosEllys/awesome-newman-html-template)
- [Directory Lister](https://www.directorylister.com/)

<b>Downloads</b>
- [GeckoDriver](https://github.com/mozilla/geckodriver/releases)
- [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads)
- [Maven](https://maven.apache.org/)
- [Java SE Development Kit 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Postman](https://www.getpostman.com/apps)

## Features
Serenity creates HTML reports for the test. While Cucumber is a BDD Framework that allows us to explain the code in layman's terms.
With API testing our CI runner will use Newman to run postman collections in Command line and output an HTML report.

## Code Example
<b>Cucumber</b>

    //Using Cucumber you tie your Given tag to a test
	@Given("^Open Firefox and go to the macpractice site$")
	public void openFirefox() throws Throwable
	{
	    //call your selenium code in your serenity step
		test.open_Firefox_and_goto_the_macpractice_site();
	}

<b>Serenity with Selenium</b>

    //Here we tag our first Serenity step in out single test.
	@Step
	//This tag is suppose to give us screenshots of the browser when it fails.
	//Doesn't work currently.
	@Screenshots(onlyOnFailures=true)
	public void open_Firefox_and_goto_the_macpractice_site()
	{
		//This defines the path of the driver for the system
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");

		//Use Headless Chrome and make sure you set a bigger window size.
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1200x1100");

		// Create a new instance of the Chrome driver
		driver = new ChromeDriver(options);

		// And now use this to visit the MacPractice Website
		driver.get("http://www.macpractice.com");
 	}

<b>JUnit Runner</b>

    //This is the JUnit Runner for our test.
    //We are using both Cucumber and Serenity.
	@RunWith(CucumberWithSerenity.class)
	//We define where the Cucumber framework is located and where our code is.
	@CucumberOptions(features="src/test/resources/Features",glue={"StepDefinition"})

	public class Runner { }

<b>Postman Json API test</b>

	"name": "Post an Order",
	"event": [
		{
			"listen": "test",
			"script": {
				"id": "13d91bcf-223a-4465-be80-72c567c23dc6",
				"type": "text/javascript",
				"exec": [
					"pm.test('Post Accepted', () => pm.response.to.be.ok)",
					"",
					"pm.test(\"Response time is less than 200ms\", function () {",
					"    pm.expect(pm.response.responseTime).to.be.below(200);",
					"});"
				]
			}
		}
	],
	"request": {
		"method": "POST",
		"header": [
			{
				"key": "Accept",
				"value": "application/json"
			},
			{
				"key": "Content-Type",
				"value": "application/json"
			},
			{
				"key": "clientType",
				"value": "1"
			},
			{
				"key": "MPuserId",
				"value": "2"
			}
		],
		"body": {
			"mode": "raw",
			"raw": "{\n  \"patientId\": 2,\n  \"orderTypeId\": 100,\n  \"shortDescription\": \"Kyle's Second Post\",\n  \"longDescription\": \"Description\",\n  \"providerId\": 1,\n  \"officeId\": 1,\n  \"incidentId\": 1,\n  \"assignedToUserId\": 1,\n  \"due\": \"2018-05-16T21:00:26Z\",\n  \"urgent\": false,\n  \"orderNotes\": \"I am ironman.\"\n}"
		},
		"url": {
			"raw": "vapor-test-server.int.macpractice.net:8080/macpractice/Orders/1/orders/",
			"host": [
				"vapor-test-server",
				"int",
				"macpractice",
				"net"
			],
			"port": "8080",
			"path": [
				"macpractice",
				"Orders",
				"1",
				"orders",
				""
			]
		}
	},
	"response": []


## Documentation

- [Test Automation Technical Design](https://docs.google.com/document/d/1_sPdrNUwC5k4Z1dM7kbITtKccRtM8xdmMuQpx8HZN8Y/edit?usp=sharing)
- [Test Automation Standards Document](https://docs.google.com/document/d/1oOjeA3cAQLR25MRSFTBeE0OTpR8Y9mjn-95lqXBpGBw/edit?usp=sharing)

You can find the training slideshow For Web UI Testing at the following link.
- [Introduction to  Automated Testing](https://docs.google.com/presentation/d/124yOZHM-x9hMMbgnTp3SrwA3pZHLWyh85ul5j5GoCdA/edit?usp=sharing)

You can find postman training here.
- [Postman and API Testing](https://docs.google.com/presentation/d/1HKYbwOy80-_ZbJ7DINtgKaJ-nxdsMRn3RPYnB0S2Wao/edit?usp=sharing)
- [All Things Postman](https://github.com/DannyDainton/All-Things-Postman/)

## Credits
Ben Weese, Quality Assurance Technical Lead

MacPractice © [Ben Weese](https://gitlab.macpractice.net/bweese/)
