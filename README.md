Hi,

This API automation is built on **Rest-Assured(Selenium-Java)** as a **Maven Project** with **TestNG** framework and it contains test cases for the below three modules

1. Pet
2. Store
3. User

**Below test cases are covered:**

Pet module- CREATE pet, UPDATE pet, VIEW pet by status, VIEW pet by ID, UPDATE with form data, Update with image upload and Delete pet
Store module-CREATE order, VIEW order by purchase id, DELETE order and VIEW Inventory
User module- CREATE n number of users with Array,GET user, UPDATE user,DELETE user,User Login, User Logout
   

**How to run:**-

To run the tests in a CI use **Jenkins** to run the code available in Git Hub. Please see the Extent Reprt/HTML Report once the build is completed.

**Steps to run in Jenkins:**

1. Click New item
2. Enter an item name
3. Click FreeStyleproject and ok
4. select Github project
5. select Source code management as Git
       Enter the repository URL
7. Branches to build */Nachimuthu-CBATest
8. Under Build Steps-Select Invoke top-level maven targets and write goal as  test
9. Add post build action and select publish HTML reports
       Click Add-Enter Directory as Reports\
       Index pages -index.html
       Report title-PetSTore API Automation Test Results
       and then click save.
10. Build now- you can see the HTML report in the dashboard-Project
If the report is not in clear format go to Dashboard–>Manage Jenkins–>Script Console and add the script as:
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP","")

Note:The user module is not stable, the users created are not reflecting some times in GET request. But I have attached the report with all test cases passed in the email.

Please review the code and let me know if there is any chance for improvements.




