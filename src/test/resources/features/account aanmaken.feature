#language:nl

  Functionaliteit: account aanmaken

    Scenario: My Account Information voor nieuwe gebruiker openen
      Gegeven de applicatie is opgestart
      En het inlogscherm is actief
      En ik klik op "My Account"
      En vervolgens klik "Continue"
      En opent het scherm "My Account Information"
      En het scherm "My Account Information" is geopend
      En ik alle verplichte velden vul
      En klik op "Continue"
      En opent het scherm "Your Account Has Been Created!"
      En het scherm "Your Account Has Been Created!"
      Als ik klik op "Continue"
      Dan opent het wederom scherm "My Account Information"
      En is de gebruiker opgeslagen in de database
      En kan ik na het uitloggen weer opnieuw inloggen
#
#    Scenario: Nieuwe gebruiker opvoeren
#      Gegeven het scherm "My Account Information" is geopend
#      Als ik alle verplichte velden vul
#      En klik op "Continue"
#      Dan opent het scherm "Your Account Has Been Created!"
#
#    Scenario: My Account Information openen na opvoer nieuwe gebruiker
#      Gegeven het scherm "Your Account Has Been Created!"
#      Als ik klik op "Continue"
#      Dan opent het scherm "My Account Information"

