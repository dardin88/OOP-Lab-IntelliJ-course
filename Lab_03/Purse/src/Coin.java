public final class Coin {

    private final String name;
    private final double value;

    public Coin(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public boolean equals(Coin coin) {
        return this.name.equals(coin.getName());
    }
}