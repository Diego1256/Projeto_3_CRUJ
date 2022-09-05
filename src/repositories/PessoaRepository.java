package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Pessoa;
import factories.ConnectionFactory;
import interfaces.IRepository;

public class PessoaRepository implements IRepository<Pessoa> {

	@Override
	public void create(Pessoa obj) throws Exception {
		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection.prepareStatement("INSERT INTO (NOME,EMAIL,CPF) VALUES (?,?,?)");

		statement.setString(1, obj.getNome());
		statement.setString(2, obj.getEmail());
		statement.setString(3, obj.getCpf());

		statement.execute();
		connection.close();
	}

	@Override
	public void update(Pessoa obj) throws Exception {
		Connection connection = ConnectionFactory.createConnection();
		PreparedStatement statement = connection
				.prepareStatement("UPDATE PESSOA SET NOME=?, EMAIL=?, CPF=? WHERE IDPESSOA=?");
		statement.setString(1, obj.getNome());
		statement.setString(2, obj.getEmail());
		statement.setString(3, obj.getCpf());
		statement.setInt(4, obj.getIdPessoa());
		statement.execute();

		connection.close();
	}

	@Override
	public void delete(Integer id) throws Exception {
		Connection connection = ConnectionFactory.createConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM PESSOA WHERE IDPESSOA=?");
		statement.setInt(1, id);

		statement.execute();

		connection.close();

	}

	@Override
	public List<Pessoa> findAll() throws Exception {
		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection.prepareStatement("SELECT * FROM PESSOA");
		ResultSet resultSet = statement.executeQuery();

		List<Pessoa> lista = new ArrayList<Pessoa>();

		while(resultSet.next()) {
			
			Pessoa pessoa = new Pessoa();
			
			pessoa.setIdPessoa(resultSet.getInt("IDPESSOA"));
			pessoa.setNome(resultSet.getString("NOME"));
			pessoa.setEmail(resultSet.getString("EMAIL"));
			pessoa.setCpf(resultSet.getString("CPF"));

			lista.add(pessoa); // adicionando pessoa na lista
		}

		connection.close();
		return lista;
	}

	@Override
	public Pessoa findById(Integer id) throws Exception {
		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection.prepareStatement("SELECT * FROM PESSOA WHERE IDPESSOA=?");
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		Pessoa pessoa = null;

		if (resultSet.next()) {
			pessoa = new Pessoa(); // instanciando a classe Pessoa

			pessoa.setIdPessoa(resultSet.getInt("IDPESSOA"));
			pessoa.setNome(resultSet.getString("NOME"));
			pessoa.setCpf(resultSet.getString("CPF"));
			pessoa.setEmail(resultSet.getString("EMAIL"));

		}

		connection.close(); // fechando conexão
		return pessoa; // retornando o objeto Pessoa

	}

}
