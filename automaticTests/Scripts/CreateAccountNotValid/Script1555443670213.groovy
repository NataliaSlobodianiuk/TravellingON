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

WebUI.verifyElementNotPresent(findTestObject('CreateAccountInvalid/small_Error occured'), 30)

WebUI.setText(findTestObject('CreateAccountInvalid/input_Create account_name'), 'user@email.com')

WebUI.setEncryptedText(findTestObject('CreateAccountInvalid/input_Create account_password'), 'NOZHw6sL/1I=')

WebUI.click(findTestObject('CreateAccountInvalid/button_Submit'))

WebUI.verifyElementPresent(findTestObject('CreateAccountInvalid/small_Error occured'), 30)

WebUI.verifyElementText(findTestObject('CreateAccountInvalid/small_Error occured'), 'Error occured: Password should be at least 6 charactersOK')

WebUI.click(findTestObject('CreateAccountInvalid/button_OK'))

WebUI.verifyElementNotPresent(findTestObject('CreateAccountInvalid/small_Error occured'), 30)

WebUI.closeBrowser()

