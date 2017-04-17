#language:nl

Functionaliteit: Account aanmaken op de webshop

  Scenario: Gebruiker moet een nieuwe account kunnen aanmaken

  Gegeven het scherm ‘account aanmaken’ zichtbaar is

  Als ik een accountgegevens invul voor "John" "tester", "08/24/1978" en "#random" met een standaard adres
    En het password met "test125"
    En als ik op de knop ‘aanmaken' klik

  Dan komen mijn gegevens in de database
    En kan ik inloggen




  Scenario: Foutmelding moet verschijnen als een eerder gebruikt emailadres wordt gebruikt.

    Gegeven het scherm ‘account aanmaken’ zichtbaar is

    Als ik een accountgegevens invul voor "John" "tester", "08/24/1978" en "test@test.nl" met een standaard adres
    En het password met "test125"
    En als ik op de knop ‘aanmaken' klik
    En controleer foutmelding "e-address allready exists"



  Abstract Scenario: Er moeten foutmeldingen verschijnen bij het leeglaten van een invoerveld

    Gegeven het scherm ‘account aanmaken’ zichtbaar is

    Als ik een accountgegevens invul voor "<voornaam>" "<achternaam>", "<geboortedatum>" en "<email>" met een standaard adres
    En het password met "test123"
    En als ik op de knop ‘aanmaken' klik
    En controleer foutmelding "<foutmelding>" bij leeglaten van veld

    Voorbeelden:
      | voornaam    | achternaam    | geboortedatum | email   |  foutmelding                                            |
      | john        | tester        |               | #random |  date of birth must be in this format                   |
      | john        | tester        | 01/06/1956    |         |  e-mail address must contain a minimum of 6 characters  |
      |             | tester        | 01/06/1956    | #random |  first name must contain a minimum of 2 characters      |
      | john        |               | 01/06/1956    | #random |  last name must contain a minimum of 2 characters       |




  Scenario: Er moeten meerdere accounts achter elkaar aangemaakt kunnen worden

    Gegeven het scherm ‘account aanmaken’ zichtbaar is

    Gegeven deze accounts zijn aangemaakt:
      | voornaam | achternaam | geboortedatum | password |
      | piet     | tester     | 01/01/2000    | test123  |
      | klaas    | tester     | 01/01/2001    | test123  |
      | henk     | tester     | 01/01/2000    | test123  |
    En de winkelwagen is leeg