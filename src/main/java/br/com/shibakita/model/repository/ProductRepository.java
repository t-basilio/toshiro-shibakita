package br.com.shibakita.model.repository;

import br.com.shibakita.model.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
