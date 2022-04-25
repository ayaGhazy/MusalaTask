# MusalaTask
this project is a maven testng project 
you can run it through ### run.xml or ### runner.java located in /src/test/java
## Configurations
please check main/resources/web.properties for configurations
## Data
for all object Repository "elements locators" exists in /test/resources/object RepositorySheetname.csv
for all test data exists in /test/resources/testdata.csv
## Browser selection
for chrome , change in web.properties browserName=ch and firefox browserName=ff
## Report
Report using allure report ### allure generate allure-results --clean && allure open
## Environment and tools
this project use it is mandatory to have below installed on machine before run
1- java 8 
2- maven 
3- allure report
## Run 
1- make sure you have  right configuration on main/resources/web.properties 
2- ### Maven
run through *mvn clean install*
3- from any ide 
Right click on run.xml or runner.java and select "Run"
4- to generate report from cmd *allure generate allure-results --clean && allure open*


