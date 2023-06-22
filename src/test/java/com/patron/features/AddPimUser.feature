# new feature
# Tags: optional

Feature: Adding new PIM user

  Scenario Outline: adding and checking new PIM user
    Given open browser and login with "admin" and "admin123"
    When i add a PIM user with name <firstname> <lastname>
    Then the user should exist with name <firstname> <lastname>

    Examples:
      | firstname   | lastname  |
      | "James"     | "Bond"    |
      | "Cristiano" | "Ronaldo" |
      | "Marco"     | "Borsato" |
      | "Steve"     | "Jobs"    |
      | "Stevie"    | "Wonder"  |