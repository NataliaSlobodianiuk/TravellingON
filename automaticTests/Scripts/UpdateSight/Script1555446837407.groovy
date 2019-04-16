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

WebUI.setText(findTestObject('UpdateSight/input_Login_name'), 'user@example.com')

WebUI.setEncryptedText(findTestObject('UpdateSight/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.click(findTestObject('UpdateSight/button_Submit'))

WebUI.verifyElementNotPresent(findTestObject('UpdateSight/form_NameLocationDescriptionNew DescriptionSubmit'), 30)

WebUI.click(findTestObject('UpdateSight/button_Update'))

WebUI.verifyElementPresent(findTestObject('UpdateSight/form_NameLocationDescriptionNew DescriptionSubmit'), 30)

WebUI.setText(findTestObject('UpdateSight/input_Name_newSightName'), 'New Sight 1')

WebUI.setText(findTestObject('UpdateSight/input_Location_newSightLocation'), 'New Location 1')

WebUI.setText(findTestObject('UpdateSight/textarea_New Description'), 'New Description 1')

WebUI.click(findTestObject('UpdateSight/button_Submit_1'))

WebUI.verifyElementPresent(findTestObject('UpdateSight/form_NameLocationDescriptionNew DescriptionSubmit'), 30)

WebUI.closeBrowser()

