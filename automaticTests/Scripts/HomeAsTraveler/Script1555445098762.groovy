import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:3000/login')

WebUI.setText(findTestObject('HomeAsTraveler/input_Login_name'), 'user@example.com')

WebUI.setEncryptedText(findTestObject('HomeAsTraveler/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.click(findTestObject('HomeAsTraveler/button_Submit'))

WebUI.waitForElementPresent(findTestObject('HomeAsTraveler/table_Sights'), 30)

WebUI.verifyElementPresent(findTestObject('HomeAsTraveler/a_Logout'), 10)

WebUI.verifyElementText(findTestObject('HomeAsTraveler/a_Logout'), 'Logout')

WebUI.verifyElementText(findTestObject('HomeAsTraveler/p_You are logged in as userexamplecom'), 'You are logged in as user@example.com')

WebUI.verifyElementPresent(findTestObject('HomeAsTraveler/p_Amount of sights found 4'), 10)

WebUI.verifyElementPresent(findTestObject('HomeAsTraveler/form_NameLocationDescriptionAdd'), 10)

WebUI.verifyElementPresent(findTestObject('HomeAsTraveler/table_Sights'), 10)

WebUI.verifyElementPresent(findTestObject('HomeAsTraveler/button_View Trips'), 10)

WebUI.verifyElementPresent(findTestObject('HomeAsTraveler/button_Update'), 10)

WebUI.closeBrowser()

