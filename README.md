# MusalaTask
this project is a testng project 
you can run it through run.xml or runner.java located in /src/test/java
## Configurations
please check main/resources/web.properties for configurations
## Data
for all object Repository "elements locators" exists in /test/resources/object RepositorySheetname.csv
for all test data exists in /test/resources/testdata.csv
## Browser selection
for chrome , change in web.properties browserName=ch and firefox browserName=ff
## Report
Report using allure report allure generate allure-results --clean && allure open


