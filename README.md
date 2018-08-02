# SET!
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

## Game Logic
Below is a flow diagram of the Single Player game logic. Not represented is the presence of both synchronous logic (selections, validations) and asynchronous logic (timer, end-game conditions).
<img src="https://github.com/brandontran24/SET/blob/master/app/src/screenshots/Logic.png" width="600">

## Single Player
In single player, the user must find all possible SETs. The user can take as much time as they want. The timer is the amount of time in seconds that has passed. When there are no more possible SETs to make, the game will revert to the main menu, updating the high score if the user beat the previous high score. By default, the first high score is an arbitrarily large number. Below we see one SET being made, with the cards remaining, score, and timer updating. The claimed cards are replaced. Invalid SETs will not update the score, and the cards will not be replaced.
<img src="https://github.com/brandontran24/SET/blob/master/app/src/screenshots/singleplayer1a.png" width="250">     <img src="https://github.com/brandontran24/SET/blob/master/app/src/screenshots/singleplayer2.png" width="250">

## Multi Player
In multiplayer, two users face each other using the same device. The goal is to claim the most available SETs possible. To claim a SET, each player must press the SET button oriented towards them. The SET button will make the other player's SET button unresponsive, and start a timer of 3 seconds. Within the 3 seconds, the player must claim a valid SET to increase their score. If they do not claim a valid SET, or try to claim an invalid SET, their score will decrease by 1 (bottoming out at 0). The game will end when no SETs are possible. Below we see the layout of the multiplayer mode. The cards are unshuffled for simplicity. We see the layout when the bottom-facing player presses SET. The other player's interface is greyed out and a timer is counting down.

<img src="https://github.com/brandontran24/SET/blob/master/app/src/screenshots/multiplayer_timer.png" width="250">     <img src="https://github.com/brandontran24/SET/blob/master/app/src/screenshots/multiplayer1.png" width="250">

# Challenges
The biggest challenge of this project was implementing the game logic while adhering to the <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">Model-View-Controller Principle</a>. Our Card class was decoupled from the ImageViews that the user sees. We update an array of selected cards, valid cards, and the overall deck of available cards with each SET claimed. The task of updating our data structures as well as the ImageViews in an elegant way required robust coding practices of abstraction and parameterization. Additionally, the mixture of synchronous game logic and asynchronous timers presented another challenge to overcome by using threads that constantly checked for end-game conditions.
