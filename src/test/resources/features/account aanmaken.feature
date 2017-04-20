#language:nl
@REGRESSIETEST
Functionaliteit: Account aanmaken
Abstract Scenario: Account aanmaken
  Gegeven dat ik geen account heb
  En dat ik naar de nieuwe account pagina navigeer
  Als ik een accountgegevens invul voor "<nameFirst>" "<nameLast>", "<dateOfBirth>" met een standaard adres
  En account aanmaken klik
  Dan word een accountgegevens aangemaakt

Voorbeelden:
  | nameFirst | nameLast        | dateOfBirth |
  | Raoul     | da Silva Curiel | 02/06/1971  |
  | John      | Doe             | 08/24/1978  |