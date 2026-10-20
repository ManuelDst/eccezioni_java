public class ContoBancario {
    private double saldo;

    public ContoBancario(double saldoIniziale) {
        if (saldoIniziale >= 0) {
            this.saldo = saldoIniziale;
        } else {
            this.saldo = 0.0;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    // Dichiara la checked exception con throws
    public void preleva(double importo) throws SaldoInsufficienteException {
        if (importo <= 0) {
            throw new ImportoNonValidoException("Errore: L'importo del prelievo deve essere maggiore di zero.");
        }

        if (importo > saldo) {
            throw new SaldoInsufficienteException(saldo, importo);
        }

        saldo -= importo;
    }
}