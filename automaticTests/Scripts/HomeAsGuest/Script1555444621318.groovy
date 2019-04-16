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

WebUI.navigateToUrl('http://localhost:3000')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomeAsTraveler/a_Login'), 30)

WebUI.verifyElementText(findTestObject('Object Repository/HomeAsTraveler/a_Login'), 'Login')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomeAsTraveler/a_Create Account'), 30)

WebUI.verifyElementText(findTestObject('Object Repository/HomeAsTraveler/a_Create Account'), 'Create Account')

WebUI.verifyElementText(findTestObject('Object Repository/HomeAsTraveler/p_You are not logged in'), 'You are not logged in')

WebUI.verifyElementPresent(findTestObject('Object Repository/HomeAsTraveler/table_Sights'), 30)

WebUI.verifyElementPresent(findTestObject('Object Repository/HomeAsTraveler/p_Amount of sights found 4'), 30)

WebUI.closeBrowser()

