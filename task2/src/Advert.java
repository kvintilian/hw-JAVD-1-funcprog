public class Advert {

    private final int width;
    private final int length;
    private final int price;

    public Advert(int width, int length, int price) {
        this.width = width;
        this.length = length;
        this.price = price;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Участок %d на %d стоимостью %d", width, length, price);
    }
}
