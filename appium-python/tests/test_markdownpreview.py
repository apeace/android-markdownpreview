import os
import unittest

from appium import webdriver

class TestMarkdownPreview:
  def setup(self):
    desired_caps = {}
    desired_caps['platformName'] = 'Android'
    desired_caps['platformVersion'] = '6.0'
    desired_caps['deviceName'] = 'Android Emulator'
    desired_caps['app'] = os.path.abspath(os.path.join(os.path.dirname(__file__),'../../app/build/outputs/apk/app-debug.apk'))
    desired_caps['appPackage'] = 'com.apeace.markdownpreview'
    desired_caps['appActivity'] = '.MainActivity'
    self.driver = webdriver.Remote('http://0.0.0.0:4723/wd/hub', desired_caps)
    self.screenshot_dir = os.getenv('SCREENSHOT_PATH', os.path.abspath(os.path.join(os.path.dirname(__file__),'../screenshots/')))

  def teardown(self):
    self.driver.quit()

  def test_preview_btn(self):
    preview_btn = self.driver.find_element_by_id('com.apeace.markdownpreview:id/preview_button')
    preview_btn.click()
    preview_view = self.driver.find_element_by_id('com.apeace.markdownpreview:id/markdown_preview')
    assert preview_view.is_displayed()

  def test_preview_with_markdown(self):
    text_field = self.driver.find_element_by_id('com.apeace.markdownpreview:id/markdown_text')
    text_field.send_keys('This is **bold**')
    preview_btn = self.driver.find_element_by_id('com.apeace.markdownpreview:id/preview_button')
    preview_btn.click()
    preview_view = self.driver.find_element_by_id('com.apeace.markdownpreview:id/markdown_preview')
    assert preview_view.is_displayed()
    self.driver.save_screenshot(os.path.join(self.screenshot_dir, 'preview.png'))
