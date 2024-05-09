package com.example.BUYsell.Controllers;

import com.example.BUYsell.Models.Product;
import com.example.BUYsell.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/")
    public String getProducts(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.getProducts(title));
        return "products";
    }
    @PostMapping("/product/create")
    public String addProduct(@RequestParam("file1") MultipartFile file,Product product) throws IOException {
        productService.saveProdusct(product, file);
        return "redirect:/";
    }
    @PostMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
    @GetMapping("product/{id}")
    public String productInfo(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("images", productService.getProductById(id).getImage());
        return "/productInfo";
    }
}
