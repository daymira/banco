package com;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AgenciaBancaria {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		
		int operacao = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma operação."+
				
				"\nOpção 1: Criar conta." +
				"\nOpção 2: Depositar." +
				"\nOpção 3: Sacar." +
				"\nOpção 4: Transferir." +
				"\nOpção 5: Listar." +
				"\nOpção 6: Sair."
				));
		
		
		switch(operacao) {
		
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listar();
			break;
		case 6:
			JOptionPane.showMessageDialog(null,"Obrigado por usar nossa agência.");
			System.exit(0);
		
		default:
			JOptionPane.showMessageDialog(null,"Opção inválida.");
			operacoes();
			break;
		}
	}
	
	public static void criarConta() {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
		pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
		pessoa.setEmail(JOptionPane.showInputDialog("Email: "));
		pessoa.setTelefone(JOptionPane.showInputDialog("Cel: "));
		
		
		
		Conta conta = new Conta(pessoa);
		
		contasBancarias.add(conta);
		JOptionPane.showMessageDialog(null,"Sua conta foi criada com sucesso!");
		operacoes();
	}
	
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta) {
					conta = c;
				}
			}
		}
		return conta;
	}
	
	public static void depositar() {
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar: "));
			conta.depositar(valorDeposito);
		}else {
			JOptionPane.showMessageDialog(null,"Conta não encontrada");
		}
		operacoes();
	}
	
	public static void sacar() {
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar: "));
			conta.sacar(valorSaque);
			
		}else {
			JOptionPane.showMessageDialog(null,"Conta não encontrada.");
		}
		operacoes();
	}
	
	public static void transferir() {
		int numeroContaR = Integer.parseInt(JOptionPane.showInputDialog("Número da sua conta: "));
		
		Conta contaR = encontrarConta(numeroContaR);
		
		if(contaR != null) {
			int numeroContaD= Integer.parseInt(JOptionPane.showInputDialog("Conta do destinatário: "));
			
			Conta contaD = encontrarConta(numeroContaD);
			
			if(contaD != null) {
				Double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog("Valor da tranferência: "));
				contaR.transferir(contaD, valorTransferencia);
			}
			
		}else {
			JOptionPane.showMessageDialog(null,"Conta não encontrada");
		}
		
		operacoes();
	}
	
	public static void listar() {
		if(contasBancarias.size() > 0) {
			for(Conta conta : contasBancarias) {
				JOptionPane.showMessageDialog(null,conta);
			}
		}else {
			JOptionPane.showMessageDialog(null,"Não há contas cadastradas.");
		}
		
		operacoes();
	}
}
