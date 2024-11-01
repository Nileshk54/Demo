
@tag
Feature: Purchasing 
  I want to use this template for my feature file

Background:
Given I landed on Page

  @tag2
  Scenario Outline: Title of your scenario outline
    Given Login with username <name> and password <value>
    When   added a product <productName> to cart
    And checkout <productName> and submit it
    Then 	verify the "THANKYOU FOR THE ORDER." is displayed

    Examples: 
      | name  									| value 				|productName										|
      | neel7020632@gmail.com		| Nileshk_54		|IPHONE 13 PRO									|
    
