/**
 * @author : Mohamed Zaim
 * @mailto : mohamed.zaim97@gmail.com
 * @created : 27/04/2024, Saturday
 **/


package com.smi.cata_mvc.web;

import com.smi.cata_mvc.dao.ProductRepository;
import com.smi.cata_mvc.entities.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Validated
@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int p,
                        @RequestParam(name = "size",defaultValue = "5") int s,
                        @RequestParam(name = "kw",defaultValue = "") String keyWord){
        Page<Product> pageProducts= productRepository.findByKeyword(keyWord ,PageRequest.of(p, s));

        model.addAttribute("listProducts",pageProducts.getContent());

        model.addAttribute("totalPages", pageProducts.getTotalPages());

        model.addAttribute("currentPage", p);
        model.addAttribute("size", s);
        model.addAttribute("kw", keyWord);
        return "products";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteProduct(Long id, int page, int size,@RequestParam(name = "kw",defaultValue = "") String kw){

        productRepository.deleteById(id);
        return "redirect:/index?page="+page+"&size="+size+"&kw="+kw;
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String addProduct(Model model){
        model.addAttribute("product",new Product());
        return "formProduct";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String addProduct(Model model, @Valid Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "formProduct";
        productRepository.save(product);
        return "confirmation";
    }

}
