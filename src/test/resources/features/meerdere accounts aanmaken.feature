#language:nl
Functionaliteit: Meerdere Accounts Aanmaken
  Scenario: Er moeten meerdere accounts achter elkaar kunnen worden aangemaakt
    Gegeven Het scherm 'account aanmaken' zichtbaar is
    En deze accounts zijn aangemaakt
    | Raoul     | da Silva Curiel | 02/06/1971  | rdsc@me.com    |
    | Someone   | Else            | 01/01/1970  | some1@else.com |
    Dan moeten deze accounts aangemaakt zijn
