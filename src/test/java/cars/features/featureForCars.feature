Feature: Feature for Cars

  Scenario: test cars

    Given User on a main page
    When User go to "Research"
    Then The page Research is opened
    When User select random values for a car and click search
    Then The page car is opened
    When User click button Compare
    Then The page compare is opened
    When User save new options
    And User go to main page
    Then Main page is opened
    When User go to "Research"
    Then The page Research is opened
    When User select random values for a car and click search
    Then The page car is opened
    When User click button Compare
    Then The page compare is opened
    When User save new options
    When User go to "Research"
    Then The page Research is opened
    When User click a button Side-by-Side
    Then The page Side-by-Side is opened
    When User select values
    And  Click a button
    Then The page model compare is opened
    When User click add car
    And Select value
    And Click button done
    Then The necessary cars were opened





