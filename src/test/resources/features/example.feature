#language:nl
  Functionaliteit:  aanmaken account op de webshop


    Scenario: gebruiker moet een nieuw account kunnen aanmaken


Gegeven  ik heb de website geopend
      #En het scherm 'account aanmaken' is zichtbaar

  Als  ik heb de link 'new customer' geklikt
  En ik mijn gegevens invul voor "Jan" "Tester" "10/01/1966" en #random met een standaard adres

  Dan  wordt mijn account aangemaakt

