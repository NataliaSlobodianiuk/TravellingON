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

WebUI.verifyElementPresent(findTestObject('LoginValidCredentials/a_Login'), 30)

WebUI.verifyElementText(findTestObject('LoginValidCredentials/a_Login'), 'Login')

WebUI.verifyElementPresent(findTestObject('LoginValidCredentials/a_Create Account'), 30)

WebUI.verifyElementText(findTestObject('LoginValidCredentials/a_Create Account'), 'Create Account')

WebUI.verifyElementText(findTestObject('LoginValidCredentials/p_You are not logged in'), 'You are not logged in')

WebUI.setText(findTestObject('LoginValidCredentials/input_Login_name'), 'admin@admin.com')

WebUI.setEncryptedText(findTestObject('LoginValidCredentials/input_Login_password'), 'HaDILDpcf1xkQmZMAxMqoQ==')

WebUI.click(findTestObject('LoginValidCredentials/button_Submit'))

WebUI.waitForElementPresent(findTestObject('LoginValidCredentials/caption_Sights'), 30)

WebUI.verifyElementPresent(findTestObject('LoginValidCredentials/a_Logout'), 30)

WebUI.verifyElementText(findTestObject('LoginValidCredentials/a_Logout'), 'Logout')

WebUI.verifyElementText(findTestObject('LoginValidCredentials/p_You are logged in as adminadmincom'), 'You are logged in as admin@admin.com')

WebUI.closeBrowser()

