import java.util.*;

class Card {
    int cardType;
    int buyPrice;
    int sellPrice;

    public Card(int cardType, int buyPrice, int sellPrice) {
        this.cardType = cardType;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }
}

public class cardtrading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int K = sc.nextInt();
        int[] deck = new int[N];
        for (int i = 0; i < N; i++) {
            deck[i] = sc.nextInt();
        }

        Card[] cards = new Card[T];
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            cards[i] = new Card(i + 1, a, b);
        }
        sc.close();

        long profit = 0;
        int[] cardCount = new int[T + 1];

        for (int card : deck) {
            cardCount[card]++;
        }

        List<Integer> cardWorthList = new ArrayList<>();
        List<Integer> cardTypes = new ArrayList<>();

        for (Card card : cards) {
            int type = card.cardType;
            int count = cardCount[type];
            int cardWorth = 0;

            if (count == 0) {
                cardWorth = 2 * card.buyPrice;
            } else if (count == 1) {
                cardWorth = card.buyPrice + card.sellPrice;
            } else {
                cardWorth = 2 * card.sellPrice;
            }

            cardWorthList.add(cardWorth);
            cardTypes.add(type);
        }

        // Sort the cardTypes based on the card worth in ascending order
        System.out.println("worth:" + cardWorthList);
        System.out.println("type:" + cardTypes);
        List<Integer> sortedCardTypes = new ArrayList<>(cardTypes);
        sortedCardTypes.sort(Comparator.comparingInt(cardType -> cardWorthList.get(cardType - 1)));
        System.out.println("sorted:" + sortedCardTypes);
        for (int i = 0; i < K; i++) {
            int type = sortedCardTypes.get(i);
            int count = cardCount[type];
            System.out.println("Type is" + type);
            System.out.println("Count is" + count);
            if (count < 2) {
                profit -= (long) (2-count) * cards[type - 1].buyPrice ;
                System.out.println("Current Profit is" + profit);
            }
        }

        for (int i = K; i < sortedCardTypes.size(); i++) {
            int type = sortedCardTypes.get(i);
            int count = cardCount[type];
            System.out.println("Type is" + type);
            System.out.println("Count is" + count);
            if (count > 0) {
                profit += (long) count * cards[type - 1].sellPrice;
                System.out.println("Current Profit is" + profit);
            }
        }
        System.out.println(sortedCardTypes);
        System.out.println(profit);
    }
}