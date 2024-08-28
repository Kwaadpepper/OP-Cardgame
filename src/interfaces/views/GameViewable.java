package interfaces.views;

/** For the game to be viewed. */
public interface GameViewable {
  /** Prompt for a players name. */
  void promptForPlayerName();

  /** Prompt user to flip cards. */
  void promptForFlip();

  /** Prompt the user to battle again. */
  void promptForNewGame();

  /** Display the winners name. */
  void showWinner(String playerName);

  /** Show a players name. */
  void showPlayerName(int playerId, String playerName);

  /** Show cards faced down for a player. */
  void showPlayerCardFacedDown(int playerId, String playerName);

  /** Show cards faced up for a player. */
  void showPlayerCardFacedUp(int playerId, String playerName, String rank, String suit);

  /** Print a message to the user. */
  void printMessage(String message);
}
