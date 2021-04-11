package atvBancos;

import java.util.Random;

public class ContaBancaria {
	 private static int ultimoNumeroConta = 1000; // Último número de conta utilizado
	 
	    private String correntista;
	    private int numeroConta; // número da conta
	    private double saldo; // saldo da conta
	    private String senha; //senha da conta
	    private double cpmf; //cpmf cobrado da conta
	    Random random = new Random();
	 
	    public ContaBancaria(String correntista, double saldo) {
	        ultimoNumeroConta++;
	        this.numeroConta = ultimoNumeroConta;
	        this.saldo = saldo;
	        this.correntista = correntista;
	        this.senha = criarSenha();
	    }
	 
	    public void depositar(double valor) {
	        this.saldo = this.saldo + valor;
	    }
	    public void sacar(double valor) {
	        this.saldo = (this.saldo - valor) - ((valor*0.25)/100);
	        this.cpmf += (valor*0.25)/100;
	    }
	 
	    public void transferir(double valor, ContaBancaria contaDestino) {
	        this.saldo = this.saldo - valor;
	        contaDestino.depositar(valor);
	    }
	 
	    public double getSaldo() {
	        return this.saldo;
	    }
	 
	    public int getNumeroConta() {
	        return this.numeroConta;
	    }
	 
	    public String toString() {
	        return "Conta de " + this.correntista + " - Saldo de R$ " + this.saldo;
	    }
	    public String getSenha() {	
	    	return this.senha;
	    }
	    
	    public double getCpmf() {
	    	return this.cpmf;
	    }
	    
	    private String criarSenha() {
			String senha = "";
			for(int i = 0; i<6; i++) {	
				int d = random.nextInt(10);
				Integer.toString(d);
				senha = senha+d;
			}
			return senha;
	    }
}