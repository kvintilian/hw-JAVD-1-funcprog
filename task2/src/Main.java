import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    final static int ADVERT_COUNT = 50;
    final static int AREA_SIZE = 500;
    final static int MIN_SIZE = 100;
    final static double COST_DEVIATION = 0.2d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите стоимость за метр квадратный:");
        int recommendedCost = scanner.nextInt();
        List<Advert> advertList = generateAdvertList(ADVERT_COUNT, recommendedCost);
        analyzeAds(advertList, recommendedCost);
    }

    private static void analyzeAds(List<Advert> advertList, int recommendedCost) {
        int honest = 0;
        int notHones = 0;
        for (Advert ads : advertList) {
            if (isHonest(ads, recommendedCost)) {
                System.out.println("Сделка \"" + ads + "\" честная");
                honest++;
            } else {
                System.out.println("Сделка \"" + ads + "\" НЕ честная");
                notHones++;
            }
        }
        System.out.printf("\nЧестных сделок: %d\nНе честных сделок: %d\n", honest, notHones);
    }

    private static boolean isHonest(Advert ads, int recommendedCost) {
        int costAds = ads.getPrice() / (ads.getLength() * ads.getWidth());
        return costAds >= recommendedCost;
    }

    private static List<Advert> generateAdvertList(int count, int recommendedCost) {
        List<Advert> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int width = random.nextInt(AREA_SIZE) + MIN_SIZE;
            int length = random.nextInt(AREA_SIZE) + MIN_SIZE;
            double currentDeviation = (recommendedCost * COST_DEVIATION);
            int cost = (int) Math.abs(random.nextGaussian() * currentDeviation + recommendedCost);
            result.add(new Advert(width, length, width * length * cost));
        }
        return result;
    }
}
