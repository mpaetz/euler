Feature: Palindrome

  Scenario: Check if a number is a palindrome
    Given I have entered the number 12321
    When I press check
    Then the result should be true