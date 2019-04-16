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

WebUI.setText(findTestObject('RemoveSight/input_Login_name'), 'admin@admin.com')

WebUI.setEncryptedText(findTestObject('RemoveSight/input_Login_password'), 'HaDILDpcf1xkQmZMAxMqoQ==')

WebUI.click(findTestObject('RemoveSight/button_Submit'))

WebUI.setText(findTestObject('RemoveSight/input_Name_newSightName'), 'new')

WebUI.setText(findTestObject('RemoveSight/input_Location_newSightLocation'), 'new')

WebUI.setText(findTestObject('RemoveSight/textarea_Description_newSightDescription'), 'new')

WebUI.click(findTestObject('RemoveSight/button_Add'))

WebUI.waitForPageLoad(30)

WebUI.verifyElementPresent(findTestObject('RemoveSight/button_Remove'), 10)

WebUI.click(findTestObject('RemoveSight/button_Remove'))

WebUI.closeBrowser()

