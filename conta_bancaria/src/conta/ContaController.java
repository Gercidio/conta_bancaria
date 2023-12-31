package conta;

import java.util.ArrayList;
import java.util.Optional;

import conta.model.Conta;
import conta.repository.Repository;

public class ContaController implements Repository{

	//criar collection
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	//var p/ receber o numero da conta
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
//mudar p/optional
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			conta.get().visualizar();
		else
			System.out.println("A Conta número: " + numero + " não foi encontrada!");
	
	}
	
	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}
		@Override
		public void cadastrar(Conta conta) {
			listaContas.add(conta);
			System.out.println("A Conta numero: " + conta.getNumero() + " foi criada com Sucesso!");
		}
		
		@Override
		public void atualizar(Conta conta) {
			Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

			if (buscaConta.isPresent()) {
				listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
				System.out.println("A Conta numero: " + conta.getNumero() + " foi atualizada com sucesso!");
			}else
				System.out.println("A Conta numero: " + conta.getNumero() + " não foi encontrada!");

				
		
		} //atualizar metodo deletar
		@Override
		public void deletar(int numero) {
			Optional<Conta> conta = buscarNaCollection(numero);
			

			if (conta.isPresent()) {
				if(listaContas.remove(conta.get()) == true)
					System.out.println("A Conta numero: " + numero + " foi excluída com sucesso!");
			}else
				System.out.println("A Conta número: " + numero + " não foi encontrada!");
		}
		
		@Override
		public void sacar(int numero, float valor) {

			Optional<Conta> conta = buscarNaCollection(numero);
			

			if (conta.isPresent()) {
				if(conta.get().sacar(valor) == true)
					System.out.println("O saque no valor " + valor + " na Conta numero: " + numero + " efetuado com sucesso!");
			}else
				System.out.println("A Conta número: " + numero + " não foi encontrada!");
		}


		@Override
		public void depositar(int numero, float valor) {
			
			Optional<Conta> conta = buscarNaCollection(numero);
			

			if (conta.isPresent()) {
				conta.get().depositar(valor);
					System.out.println("O depósito no valor " + valor + " na Conta numero: " + numero + " foi efetuado com sucesso!");
			}else
				System.out.println("A Conta número: " + numero + " não foi encontrada!");
		}

		@Override
		public void transferir(int numeroOrigem, int numeroDestino, float valor) {

			Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
			Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

			if (contaOrigem.isPresent() && contaDestino.isPresent()) {
				if(contaOrigem.get().sacar(valor) == true) {
					contaDestino.get().depositar(valor);
				
					System.out.println("A transferência no valor de " + valor + " na Conta numero: " + numero + " foi efetuado com sucesso!");
				}
			}else
				System.out.println("A Conta número: " + numero + " não foi encontrada!");
			
		}

		/* Métodos Auxiliares */

		public int gerarNumero() {
			return ++numero;
		}
// alterações: add Optional.empty e optional.of(conta)
		
		public Optional<Conta> buscarNaCollection(int numero) {

			for (var conta : listaContas) {
				if (conta.getNumero() == numero)
					return Optional.of(conta);
			}

			return Optional.empty();
		}
}
