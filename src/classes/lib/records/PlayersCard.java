package classes.lib.records;

import classes.Card;
import interfaces.lib.players.Player;

/** A players card. */
public record PlayersCard(Player player, Card card) {}
