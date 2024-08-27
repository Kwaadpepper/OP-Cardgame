package Enums;

/** Une couleur de carte */
public enum Suit {
    /** Trèfles */
    CLUBS (1),
    /** Piques */
    SPADES (2),
    /** Cœurs */
    HEARTS (3),
    /** Carreaux */
    DIAMONDS (4);

    /** La valeur en numérique */
    private final int color;

    Suit(int value) {
        color = value;
    }

    /** Obtenir la valeur numérique */
    public int value() {
        return color;
    }
}
