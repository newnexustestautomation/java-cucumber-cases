#language:nl
  Functionaliteit: account aanmaken

    Scenario: My Account Information voor nieuwe gebruiker openen
      Gegeven de applicatie is opgestart
      En het inlogscherm is actief
      Als ik klik op "My Account"
      En vervolgens klik "Continue"
      Dan opent het scherm "My Account Information"

    Scenario: Nieuwe gebruiker opvoeren
      Gegeven het scherm "My Account Information" is geopend
      Als ik alle verplichte velden vul
      En klik op "Continue"
      Dan opent het scherm "Your Account Has Been Created!"

    Scenario: My Account Information openen na opvoer nieuwe gebruiker
      Gegeven het scherm "Your Account Has Been Created!"
      Als ik klik op "Continue"
      Dan opent het scherm "My Account Information"

