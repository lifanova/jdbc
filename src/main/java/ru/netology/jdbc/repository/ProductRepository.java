package ru.netology.jdbc.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.netology.jdbc.model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private static final String SQL_SCRIPT = "select.sql";
    private NamedParameterJdbcTemplate jdbcTemplate;
    private String scriptText = "";

    public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.scriptText = read(SQL_SCRIPT);
    }

    public List<String> getProductName(String name) {
//        Product product = jdbcTemplate.queryForList(scriptText,
//                new MapSqlParameterSource("name", name), new ProductMapper());

        List<String> list = jdbcTemplate.queryForList(scriptText, new MapSqlParameterSource("name", name), String.class);
//
//        if (product != null) {
//            return product.getProductName();
//        } else {
//            System.out.println(name + " ничего не купил!");
//            return null;
//        }

        return list;
    }

    private static final class ProductMapper implements RowMapper<Product> {
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product(rs.getString("name"), rs.getString("product_name"));

            return product;
        }
    }
    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
