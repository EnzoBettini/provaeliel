package enzo.provaeliel.repositories;

import enzo.provaeliel.entity.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
