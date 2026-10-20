public class Main {
    // Aggiungiamo 'throws SaldoInsufficienteException' alla firma del main
    public static void main(String[] args) throws SaldoInsufficienteException {
        ContoBancario conto = new ContoBancario(500.0);
        System.out.println("Conto creato con un saldo iniziale di: €500.0\n");

        // --- Scenario 1: Prelievo Valido ---
        System.out.println("--- Scenario 1: Prelievo Valido (150.0 €) ---");
        try {
            conto.preleva(150.0);
            System.out.println("Operazione completata con successo!");
            System.out.println("Saldo residuo: €" + conto.getSaldo());
        } catch (SaldoInsufficienteException e) {
            System.out.println("Errore: " + e.getMessage());
        }
        System.out.println();

        // --- Scenario 2: Prelievo Eccessivo (Checked Exception) ---
        System.out.println("--- Scenario 2: Prelievo Eccessivo (600.0 €) ---");
        try {
            conto.preleva(600.0);
        } catch (SaldoInsufficienteException e) {
            System.out.println("Eccezione catturata: " + e.getMessage());
            System.out.println("Saldo attuale: €" + e.getSaldoAttuale());
            System.out.println("Importo richiesto: €" + e.getImportoRichiesto());
            System.out.println("Deficit di denaro: €" + e.getDeficit());
        } finally {
            System.out.println("[FINALLY] Blocco finally eseguito. Saldo attuale invariato: €" + conto.getSaldo());
        }
        System.out.println();

        // --- Scenario 3: Prelievo Negativo (Unchecked Exception) ---
        System.out.println("--- Scenario 3: Prelievo Negativo (-50.0 €) ---");
        try {
            conto.preleva(-50.0);
        } catch (ImportoNonValidoException e) {
            System.out.println("Eccezione runtime catturata: " + e.getMessage());
        } finally {
            System.out.println("[FINALLY] Blocco finally eseguito per il prelievo non valido.");
        }
    }
}