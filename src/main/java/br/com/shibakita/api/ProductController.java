package br.com.shibakita.api;

import br.com.shibakita.model.model.Product;
import br.com.shibakita.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final SpringTemplateEngine templateEngine;
    private final ProductService service;

    @GetMapping
    public String addAndListAllProducts() {
        service.insertSomeProduct();

        List<Product> products = service.findAll();
        return processTemplate(products);
    }

    private String processTemplate(List<Product> products) {
        try {
            Context thymeleafContext = new Context();
            thymeleafContext.setVariables(Map.of("products", products));
            return templateEngine.process("index.html", thymeleafContext);
        } catch (Exception e) {
            throw new RuntimeException("Thymeleaf error", e);
        }
    }

}
