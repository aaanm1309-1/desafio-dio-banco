import lombok.Getter;

@Getter
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static  int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }


    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        imprimirInfo();
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public void imprimirInfo() {
        System.out.print("Agencia: " + this.agencia);
        System.out.println(" - Conta Numero: " + this.numero);
        System.out.println("Cliente/Titular: " + this.cliente.getNome());
    }

}
