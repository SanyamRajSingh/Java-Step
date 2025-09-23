package week6.assignments;

import java.util.Objects;

class Game {
    private String name;
    private int maxPlayers;

    public Game(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
    }

    @Override
    public String toString() {
        return "Game{" + "name='" + name + '\'' + ", maxPlayers=" + maxPlayers + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Game)) return false;
        Game other = (Game) obj;
        return maxPlayers == other.maxPlayers && Objects.equals(name, other.name);
    }
}

class CardGame extends Game {
    private int numberOfCards;
    private String deckType;

    public CardGame(String name, int maxPlayers, int numberOfCards, String deckType) {
        super(name, maxPlayers);
        this.numberOfCards = numberOfCards;
        this.deckType = deckType;
    }

    @Override
    public String toString() {
        return "CardGame{" + "numberOfCards=" + numberOfCards + ", deckType='" + deckType + '\'' +
                "} inherits " + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof CardGame)) return false;
        CardGame other = (CardGame) obj;
        return numberOfCards == other.numberOfCards && Objects.equals(deckType, other.deckType);
    }

    public static void main(String[] args) {
        Game game1 = new Game("Board Game", 4);
        Game game2 = new Game("Board Game", 4);
        System.out.println(game1.toString());
        System.out.println("game1 equals game2? " + game1.equals(game2));

        CardGame cardGame1 = new CardGame("Poker", 6, 52, "Standard");
        CardGame cardGame2 = new CardGame("Poker", 6, 52, "Standard");
        System.out.println(cardGame1.toString());
        System.out.println("cardGame1 equals cardGame2? " + cardGame1.equals(cardGame2));
    }
}
