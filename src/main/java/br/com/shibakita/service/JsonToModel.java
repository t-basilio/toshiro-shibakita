package br.com.shibakita.service;

import br.com.shibakita.model.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class JsonToModel {

    private final ObjectMapper objectMapper;

    public List<Product> toListModel() throws IOException {
        return objectMapper.readValue(
                Objects.requireNonNull(getClass().getResourceAsStream("/static/products.json")),
                new TypeReference<>() {});
    }
}
