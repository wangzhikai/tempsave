from selenium import webdriver

browser = webdriver.Firefox()
browser.get('http://seleniumhq.org/')

browser.add_cookie({'name' : 'foo', 'value' : 'bar'}) 
