package com;

import javax.swing.JOptionPane;

public class Conta {
	private static int accountCount = 1;
	
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	
	
	public Conta(Pessoa pessoa) {
		this.numeroConta = numeroConta;
		this.pessoa = pessoa;
		numeroConta += 1;
	}


	public int getNumeroConta() {
		return numeroConta;
	}


	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	@Override
	public String toString() {
		return "Conta\nNúmero da Conta: " + numeroConta + "\nNome: " + this.pessoa.getNome() + "\nEmail: " + this.pessoa.getEmail() + "\nsaldo: " + saldo;
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			JOptionPane.showMessageDialog(null,"Seu depósito foi realizado com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null,"Não foi possível realizar o depósito.");
		}
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			JOptionPane.showMessageDialog(null,"Saque realizado com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null,"Não foi possível realizar o saque.");
		}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			JOptionPane.showMessageDialog(null,"Transferência realizada com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null,"Não foi possível realizar a tranferência.");
		}
	}
}
