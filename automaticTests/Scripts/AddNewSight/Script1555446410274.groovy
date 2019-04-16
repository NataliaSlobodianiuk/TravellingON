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

WebUI.setText(findTestObject('AddNewSight/input_Login_name'), 'user@example.com')

WebUI.setEncryptedText(findTestObject('AddNewSight/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.click(findTestObject('AddNewSight/button_Submit'))

WebUI.setText(findTestObject('AddNewSight/input_Name_newSightName'), 'New Sight')

WebUI.setText(findTestObject('AddNewSight/input_Location_newSightLocation'), 'New Location')

WebUI.setText(findTestObject('AddNewSight/textarea_Description_newSightDescription'), 'New Description')

WebUI.click(findTestObject('AddNewSight/button_Add'))

WebUI.waitForPageLoad(10)

WebUI.verifyElementText(findTestObject('AddNewSight/input_Name_newSightName'), '')

WebUI.verifyElementText(findTestObject('AddNewSight/input_Location_newSightLocation'), '')

WebUI.verifyElementText(findTestObject('AddNewSight/textarea_Description_newSightDescription'), '')

WebUI.closeBrowser()

