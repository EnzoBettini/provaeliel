package enzo.provaeliel.services;

import enzo.provaeliel.entity.ProdutoModel;
import enzo.provaeliel.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public ProdutoModel salvar(ProdutoModel produto) {
        return repository.save(produto);
    }

    public List<ProdutoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<ProdutoModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<ProdutoModel> atualizar(Long id, ProdutoModel produtoAtualizado) {
        return repository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setStatus(produtoAtualizado.getStatus());
            return repository.save(produto);
        });
    }

    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
