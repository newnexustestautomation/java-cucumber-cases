#language:nl

Functionaliteit: Account aanmaken op de webshop

  @REGRESSIETEST
  Scenario: Gebruiker moet een nieuwe account kunnen aanmaken

  Gegeven het scherm ‘account aanmaken’ zichtbaar is

  Als ik een accountgegevens invul voor "John" "tester", "08/24/1978" en "#random" met een standaard adres
    En het password met "test125"
    En als ik op de knop ‘aanmaken' klik

  Dan komen mijn gegevens in de database
    En kan ik inloggen


  @REGRESSIETEST
  Scenario: Foutmelding moet verschijnen als een eerder gebruikt emailadres wordt gebruikt.

    Gegeven het scherm ‘account aanmaken’ zichtbaar is

    Als ik een accountgegevens invul voor "John" "tester", "08/24/1978" en "test@test.nl" met een standaard adres
    En het password met "test125"
    En als ik op de knop ‘aanmaken' klik
    En controleer foutmelding "e-address allready exists"

