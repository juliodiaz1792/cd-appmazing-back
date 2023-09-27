package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ProductDTO;

import java.util.List;

public interface iProductService {
    ProductDTO queryProduct(ProductDTO product); //Paso un ProductDTO y me devuelve toda la info de ese ProductDTO concreto
    List<ProductDTO> queryAllProducts(); //Devuelve todos los ProductDTO con toda la info

    /*
    *
    * Métodos para insertar, actualizar y borrar info
    * Devuelven un número entero porque queremos que nos devuelva la clave primaria
    *
    * */
    int insertProduct(ProductDTO product);
    int updateProduct(ProductDTO product);
    int deleteProduct(ProductDTO product);
}
