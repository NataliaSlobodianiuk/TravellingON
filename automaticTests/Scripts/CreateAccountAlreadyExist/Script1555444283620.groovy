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

WebUI.navigateToUrl('http://localhost:3000/signup')

WebUI.verifyElementNotPresent(findTestObject('CreateAccountAlreadyExists/small_Error occured'), 30)

WebUI.setText(findTestObject('CreateAccountAlreadyExists/input_Create account_name'), 'user@example.com')

WebUI.setEncryptedText(findTestObject('CreateAccountAlreadyExists/input_Create account_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.click(findTestObject('CreateAccountAlreadyExists/button_Submit'))

WebUI.verifyElementPresent(findTestObject('CreateAccountAlreadyExists/small_Error occured'), 30)

WebUI.verifyElementText(findTestObject('CreateAccountAlreadyExists/small_Error occured'), 'Error occured: The email address is already in use by another account.OK')

WebUI.click(findTestObject('CreateAccountAlreadyExists/button_OK'))

WebUI.verifyElementNotPresent(findTestObject('CreateAccountAlreadyExists/small_Error occured'), 30)

WebUI.closeBrowser()

