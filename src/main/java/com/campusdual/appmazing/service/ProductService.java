package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.iProductService;
import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dao.ProductDAO;
import com.campusdual.appmazing.model.dto.ProductDTO;
import com.campusdual.appmazing.model.dto.dtomapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("ProductService")
@Lazy
public class ProductService implements iProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public ProductDTO queryProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        Product productFinal = this.productDAO.getReferenceById(product.getId());
        return ProductMapper.INSTANCE.toDTO(productFinal);
//        IDEM al return de arriba
//        ProductDTO dto = ProductMapper.INSTANCE.toDTO(productFinal);
//        return dto;
    }

    @Override
    public List<ProductDTO> queryAllProducts() {
        return ProductMapper.INSTANCE.toDTOList(this.productDAO.findAll());
    }

    @Override
    public int insertProduct(ProductDTO productDTO) { //Viene sin ID
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        Product product1 = this.productDAO.saveAndFlush(product);
        return product1.getId();
    }

    @Override
    public int updateProduct(ProductDTO productDTO) { //Viene con ID
        return this.insertProduct(productDTO);
    }

    @Override
    public int deleteProduct(ProductDTO productDTO) {
        int id = productDTO.getId();
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        this.productDAO.delete(product);
        return id;
    }

    @Override
    public int buyProduct(ProductDTO product, int quantity) {
        ProductDTO productToBuy = this.queryProduct(product);
        if (productToBuy.isActive() && quantity <= productToBuy.getStock()) {
            productToBuy.setStock(productToBuy.getStock() - quantity);
            this.updateProduct(productToBuy);
        }
        return productToBuy.getStock();
    }

    @Override
    public BigDecimal calculateAndDecreasePrice(ProductDTO product, int quantity) {
        ProductDTO productToBuy = this.queryProduct(product);
        return productToBuy.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    //Cuanto costaría comprar esa cantidad de elementos calculateAndDecreasePrice()

}
