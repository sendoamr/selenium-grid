# Each feature contains one feature
Feature: Test the form funcionality


 Background: User navigation to url
    Given User navigation to http://10.23.27.196:8080

 Scenario Outline: the user must be able to fill in the form
   Given user is on the form page
   And the user enters name <name>, email <email> and Skills <skills>
   When user click on send
   Then user gets <response>

    Examples:
      | name          | email            | skills         | response | message                    |
      | Selenium test | prueba@gmail.com | Cucumber       | OK       | Skills:Selenium            |
      | Selenium test | pruebagmail.com  | Tests          | KO       | Invalid e-mail address!    |
