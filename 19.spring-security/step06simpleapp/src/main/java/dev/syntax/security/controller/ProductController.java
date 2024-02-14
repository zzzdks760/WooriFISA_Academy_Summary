package dev.syntax.security.controller;

import dev.syntax.security.entity.Product;
import dev.syntax.security.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String showProductMainPage(Authentication a, Model model) {

        // 인증된 사용자의 정보를 담고 있는 객체에서 사용자 이름 취득
        String name = a.getName();
        model.addAttribute("username", name);

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "products"; // src/main/resources/templates/products.html로 렌더링
    }
}