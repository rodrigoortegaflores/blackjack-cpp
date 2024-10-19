import java.util.Random;

public class black_j {
    static int player = 0;
    static int dealer = 0;
    static String playerMessage = "Cartas del primer jugador son: ";
    static String dealerMessage = "Cartas del segundo jugador son: ";
    static int[] cards = new int[52];

    static int obtenerValorCarta(int card) {
        if (card >= 10 && card <= 12) {
            return 10;
        } else if (card == 13) {
            return 11;
        } else {
            return card;
        }
    }

    static void crearBaraja() {
        int cardCount = 0;
        for (int palo = 0; palo < 4; palo++) {
            for (int card = 1; card <= 13; card++) {
                cards[cardCount] = obtenerValorCarta(card);
                cardCount++;
            }
        }
    }

    static int obtenerCartaAleatoria() {
        Random random = new Random();
        return cards[random.nextInt(52)];
    }

    static int asignarCartas(StringBuilder message) {
        int card1 = obtenerCartaAleatoria();
        int card2 = obtenerCartaAleatoria();
        message.append(card1).append(" y ").append(card2);
        return card1 + card2;
    }

    static void iniciarJuego() {
        StringBuilder playerMsg = new StringBuilder(playerMessage);
        StringBuilder dealerMsg = new StringBuilder(dealerMessage);

        player = asignarCartas(playerMsg);
        dealer = asignarCartas(dealerMsg);

        System.out.println(playerMsg.toString());
        System.out.println(dealerMsg.toString());
        System.out.println("Puntuación del primer jugador: " + player);
        System.out.println("Puntuación del segundo jugador: " + dealer);
    }

    static void validarResultado() {
        if (player == 21) {
            System.out.println("Felicidades, ganaste con un BlackJack!");
        } else if (player > dealer && player <= 21) {
            System.out.println("Felicidades, has ganado");
        } else if (player == dealer) {
            System.out.println("Es un empate");
        } else if (player > 21) {
            System.out.println("Tu puntuación es mayor a 21, has perdido");
        } else {
            System.out.println("Lo siento, has perdido");
        }
    }

    public static void main(String[] args) {
        crearBaraja();
        iniciarJuego();
        validarResultado();
    }
}
