import net.datafaker.Faker;
import java.util.Random;

// --- 1. Eccezione Controllata (Checked) ---
class EroeNonIdoneoException extends Exception {
    private String nomeEroe;
    private int livelloPotere;

    public EroeNonIdoneoException(String nomeEroe, int livelloPotere, String messaggio) {
        super(messaggio);
        this.nomeEroe = nomeEroe;
        this.livelloPotere = livelloPotere;
    }

    public String getNomeEroe() {
        return nomeEroe;
    }

    public int getLivelloPotere() {
        return livelloPotere;
    }
}

// --- 2. Classe Reclutatore ---
class Reclutatore {
    private Faker faker;
    private Random random;

    public Reclutatore() {
        this.faker = new Faker();
        this.random = new Random();
    }

    public void valutaEroe(int difficoltaMissione) throws EroeNonIdoneoException {
        // Genera un nome casuale da supereroe usando Datafaker
        String nomeEroe = faker.superhero().name();

        // Genera un livello di potere casuale tra 1 e 100
        int livelloPotere = random.nextInt(100) + 1;

        System.out.println("Candidato valutato: " + nomeEroe + " (Potere: " + livelloPotere + ")");

        // Se il potere è inferiore alla difficoltà, lancia l'eccezione
        if (livelloPotere < difficoltaMissione) {
            throw new EroeNonIdoneoException(
                    nomeEroe,
                    livelloPotere,
                    "Eroe scartato: potere insufficiente per la missione (richiesti almeno " + difficoltaMissione + ")."
            );
        }

        System.out.println("SUCCESSO! L'eroe " + nomeEroe + " è stato reclutato con successo!\n");
    }
}

// --- 3. Classe Main (con tutto il flusso) ---
public class Main {
    public static void main(String[] args) {
        Reclutatore reclutatore = new Reclutatore();
        int difficoltaMissione = 75;

        System.out.println("=== INIZIO CAMPAGNA DI RECLUTAMENTO ===");
        System.out.println("Difficoltà della missione: " + difficoltaMissione + "\n");

        // Ciclo di 5 tentativi di reclutamento
        for (int i = 1; i <= 5; i++) {
            System.out.println("--- Tentativo #" + i + " ---");
            try {
                reclutatore.valutaEroe(difficoltaMissione);
            } catch (EroeNonIdoneoException e) {
                System.out.println("--> " + e.getMessage());
                System.out.println("    (Dettagli scarto -> Eroe: " + e.getNomeEroe() + ", Potere: " + e.getLivelloPotere() + ")");
                System.out.println("Passaggio al candidato successivo...\n");
            }
        }

        System.out.println("=== FINE SESSIONE DI RECLUTAMENTO ===");
    }
}