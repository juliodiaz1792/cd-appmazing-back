package com.campusdual.appmazing.model.dto.dtomapper;

import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    //Siempre tiene tres métodos, que SIEMPRE son como están aquí abajo escritos
    ProductDTO toDTO(Product product); //Convertir modelo en DTO
    List<ProductDTO> toDTOList(List<Product> products); //Convertir una lista de modelos en una lista de DTO
    Product toEntity(ProductDTO productDTO); //Convertir DTO en modelo
}
