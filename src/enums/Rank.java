package enums;

/** Une valeur de carte. */
public enum Rank {
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  HEIGHT(8),
  NINE(9),
  JACK(10),
  QUEEN(11),
  KING(12),
  ACE(13);

  /** La valeur en numérique. */
  private final int rank;

  Rank(int value) {
    rank = value;
  }

  /** Obtenir la valeur numérique. */
  public int value() {
    return rank;
  }
}
