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

WebUI.verifyElementNotPresent(findTestObject('LoginInvalidCredentials/error'), 30)

WebUI.setText(findTestObject('LoginInvalidCredentials/input_Login_email'), 'login@example.com')

WebUI.setEncryptedText(findTestObject('LoginInvalidCredentials/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.click(findTestObject('LoginInvalidCredentials/button_Submit'))

WebUI.verifyElementPresent(findTestObject('LoginInvalidCredentials/error'), 30)

WebUI.verifyElementText(findTestObject('LoginInvalidCredentials/error'), 'Login failed: There is no user record corresponding to this identifier. The user may have been deleted.OK')

WebUI.click(findTestObject('LoginInvalidCredentials/button_error_OK'))

WebUI.verifyElementNotPresent(findTestObject('LoginInvalidCredentials/error'), 30)

WebUI.closeBrowser()

