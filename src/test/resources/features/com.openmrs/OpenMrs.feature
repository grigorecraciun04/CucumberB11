Feature: Open MRS tests

  @openMRS
  Scenario: Register a patient
    Given the user logs in to OpenMRS with following credentials
      | username | admin    |
      | password | Admin123 |
    When the user register a new patient with following  information
      | givenName    | gerr         |
      | familyName   | derfe        |
      | gender       | Male         |
      | day          | 04           |
      | month        | April        |
      | year         | 1991         |
      | address      | 2200 e Devon |
      | phoneNumber  | 1112223344   |
      | relative     | Doctor       |
      | relativeName | grigore      |
    Then the user validate the patient name and familyName
      | GivenName  | gerr  |
      | FamilyName | derfe |