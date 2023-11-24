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

		}

		@Override
		public void depositar(int numero, float valor) {

		}

		@Override
		public void transferir(int numeroOrigem, int numeroDestino, float valor) {

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
