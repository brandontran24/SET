# SET
<img src="https://github.com/brandontran24/SET/blob/master/app/src/screenshots/SET.png" width="1000">
An Android implementation of SET! for ECE 150: Mobile Embedded Systems

# Rules
In <a href="https://en.wikipedia.org/wiki/Set_(card_game)">SET!</a>, the goal is to find valid SETs. Cards in SET! contain four parameters: number, symbol, shading, and color. A SET is formed by three cards that satisfy the following conditions:

1. They all have the same number or have three different numbers.
2. They all have the same symbol or have three different symbols.
3. They all have the same shading or have three different shadings.
4. They all have the same color or have three different colors.

# Our App
In our implementation, there are four Activities: MainActivity, SinglePlayer, MultiPlayer, and RulesActivity

<img src="https://github.com/brandontran24/SET/blob/master/app/src/screenshots/MainMenu.png" width="210">    <img src="https://github.com/brandontran24/SET/blob/master/app/src/screenshots/singleplayer.png" width="210">    <img src="https://github.com/brandontran24/SET/blob/master/app/src/screenshots/multiplayer1.png" width="210">    <img src="https://github.com/brandontran24/SET/blob/master/app/src/screenshots/rules.png" width="210">

# Single Player
In single player, the user must find all possible SETs. The user can take as much time as they want. The timer is the amount of time in seconds that has passed. When there are no more possible SETs to make, the game will revert to the main menu, updating the high score if the user beat the previous high score. By default, the first high score is an arbitrarily large number. Below we see one SET being made, with the cards remaining, score, and timer updating. The claimed cards are replaced.
<img src="https://github.com/brandontran24/SET/blob/master/app/src/screenshots/singleplayer1a.png" width="250">     <img src="https://github.com/brandontran24/SET/blob/master/app/src/screenshots/singleplayer2.png" width="250">
