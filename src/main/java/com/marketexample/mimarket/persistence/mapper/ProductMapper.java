package com.marketexample.mimarket.persistence.mapper;

import com.marketexample.mimarket.domain.Product;
import com.marketexample.mimarket.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

// para ayudar el mapper a ser mas rapido se le pasa en el argumento que estamos usando spring.
// En este caso agregamos el parametro uses pq dentro del mapping vamos a usar una clase de la que ya
//tenemos un mapper hecho. Cuando esto pasa se usa el paramatreo "uses" para esas clases, y luego se
// le pone ".class".
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    // @Mappings dice que vamos dentro de una tabla a hacer varios mapeos a varios elementos dentro de ({}) y luego
    // se crea un parametro que la regule (esto no se muy bien pq). La forma de hacerlo es poner la clase
    @Mappings({
            //@Mapping (sin s al final) le dice que elemento vamos a mappear. Le debemos dar el origen y en que lo
            // queremos convertir. Tomar de referencia siempre las clases que estan en el dominio y ponerlas en source.
            @Mapping(source = "idProducto",target = "productId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "precioVenta",target = "price"),
            @Mapping(source = "cantidadStock",target = "stock"),
            @Mapping(source = "estado",target = "active"),
            @Mapping(source = "categoria",target = "category"),
    })
    Product toProduct(Producto producto);
    // tambien se puede hacer los mismo para varios productos en una lista de productos si algun metodo lo necesita.
    // Se define como se hizo en la parte de abajo. No se tiene que hacer @Mappings ni @Mapping para java la entiende
    // que tiene que tomar la informacion de arriba y repetirla
    List<Product> toProducts(List<Producto> productos);

    // @InheritInverseConfiguration sirve la enviar la informacion externa a la tabla interna que estamos protegiendo
    // Como esta conversion en la inversa a la dicha arriba, por lo tanto no se tiene que definir @Mappings o @Mapping
    // para las cosas que ya definimos arriba.
    // La unica excepcion, son aquellos atributos que estan en categoria, que no tienen un atributo en category.
    // En este caso le tenemos que decir explicitamente que los tenemos que ignorar.
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);


}
