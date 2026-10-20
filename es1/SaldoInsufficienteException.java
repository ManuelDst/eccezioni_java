public class SaldoInsufficienteException extends Exception {
    private double saldoAttuale;
    private double importoRichiesto;

    public SaldoInsufficienteException(double saldoAttuale, double importoRichiesto) {
        super("Saldo insufficiente per completare l'operazione.");
        this.saldoAttuale = saldoAttuale;
        this.importoRichiesto = importoRichiesto;
    }

    public double getSaldoAttuale() {
        return saldoAttuale;
    }

    public double getImportoRichiesto() {
        return importoRichiesto;
    }

    public double getDeficit() {
        return importoRichiesto - saldoAttuale;
    }
}