public class Main {
    public static void main(String[] args) {
        var banco = new Banco();
        banco.setNome("Banco Local");
        banco.setNumero(15);

        var cli1 = new Cliente();
        var cli2 = new Cliente();

        cli1.setNome("Love");
        cli2.setNome("Dev");

        Conta cc = new ContaCorrente(cli1);
        Conta cp = new ContaPoupanca(cli2);

        banco.adicionarConta(cc);
        banco.adicionarConta(cp);

        cc.depositar(1500);
        cc.transferir(200, cp);

        cp.depositar(1200);

        System.out.println("======================");
        cc.imprimirExtrato();
        System.out.println("======================");
        cp.imprimirExtrato();


        System.out.println("======================");
        banco.listarContas();
        System.out.println("======================");
    }

}
