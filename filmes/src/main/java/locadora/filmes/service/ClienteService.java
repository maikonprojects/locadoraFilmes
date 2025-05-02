package locadora.filmes.service;

import locadora.filmes.DTO.EntradaDadosCliente;
import locadora.filmes.DTO.EntradaDeDados;
import locadora.filmes.model.Cliente;
import locadora.filmes.model.Filme;
import locadora.filmes.model.Locacao;
import locadora.filmes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public EntradaDadosCliente inserirCliente(EntradaDadosCliente dados){
        try {
            Cliente cliente = new Cliente(dados);
            Cliente clienteSalvo = repository.save(cliente);
            return new EntradaDadosCliente(clienteSalvo.getNome(), clienteSalvo.getEmail());
        } catch (RuntimeException se){
            throw new RuntimeException();
        }
    }


    public List<Cliente> listarCliente() {
        return repository.findAll();
    }


}
