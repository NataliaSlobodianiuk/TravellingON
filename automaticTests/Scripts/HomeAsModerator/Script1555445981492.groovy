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

WebUI.setText(findTestObject('HomeAsModerator/input_Login_name'), 'admin@admin.com')

WebUI.setEncryptedText(findTestObject('HomeAsModerator/input_Login_password'), 'HaDILDpcf1xkQmZMAxMqoQ==')

WebUI.click(findTestObject('HomeAsModerator/button_Submit'))

WebUI.waitForElementPresent(findTestObject('HomeAsModerator/caption_Sights'), 30)

WebUI.verifyElementPresent(findTestObject('HomeAsModerator/a_Logout'), 10)

WebUI.verifyElementText(findTestObject('HomeAsModerator/a_Logout'), 'Logout')

WebUI.verifyElementText(findTestObject('HomeAsModerator/p_You are logged in as adminadmincom'), 'You are logged in as admin@admin.com')

WebUI.verifyElementPresent(findTestObject('HomeAsModerator/form_NameLocationDescriptionAdd'), 10)

WebUI.verifyElementPresent(findTestObject('HomeAsModerator/p_Amount of sights found 4'), 10)

WebUI.verifyElementPresent(findTestObject('HomeAsModerator/caption_Sights'), 10)

WebUI.verifyElementPresent(findTestObject('HomeAsModerator/button_View Trips'), 10)

WebUI.verifyElementPresent(findTestObject('HomeAsModerator/button_Update'), 10)

WebUI.verifyElementPresent(findTestObject('HomeAsModerator/button_Remove'), 10)

WebUI.verifyElementPresent(findTestObject('HomeAsModerator/button_Remove All'), 10)

WebUI.closeBrowser()

