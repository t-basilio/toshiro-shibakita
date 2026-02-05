package br.com.shibakita.service;

import br.com.shibakita.model.model.Product;
import br.com.shibakita.model.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final JsonToModel jsonToModel;

    public List<Product> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Product insertSomeProduct() {

        try {
            var products = jsonToModel.toListModel();
            int random = new Random().nextInt(products.size());
            Product product = Product.builder()
                    .name(products.get(random).getName())
                    .description(products.get(random).getDescription())
                    .price(products.get(random).getPrice())
                    .host(InetAddress.getLocalHost().getHostName())
                    .ip(InetAddress.getLocalHost().getHostAddress())
                    .build();

            return repository.save(product);

        } catch (IOException e) {
            throw new RuntimeException("Service error: ", e);
        }
    }

}
