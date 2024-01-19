Feature: My course test

  Scenario Outline: Check user can open course by namme
    Given Main page is opened
    And I open course page <courseName>
    Then I check course <courseName> page is opened

    Examples:
      | courseName |
      | "Kafka"    |
      | "Python"   |


  Scenario Outline: check user can open course with min and max date
    Given Main page is opened
    And I open course with <range> date
    Then I check course page is opened

    Examples:
      | range |
      | 1     |
      | 2     |


  Scenario Outline: Check user can open online course with min and max price
    Given Online Courses page is opened
    And I choose online course with price <range>
    Then I check online course page is opened

    Examples:
      | range |
      | MAX     |
      | MIN     |

  Scenario: Check user can open course with date more than provided one
    Given Main page is opened
    And I open course with "C 23 апреля" date
    Then I check course page is opened




