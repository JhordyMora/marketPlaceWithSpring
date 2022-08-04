package com.marketexample.mimarket.persistence.mapper;

import com.marketexample.mimarket.domain.Category;
import com.marketexample.mimarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
// para ayudar el mapper a ser mas rapido se le pasa en el argumento que estamos usando spring
public interface CategoryMapper {
    // @Mappings dice que vamos dentro de una tabla a hacer varios mapeos a varios elementos dentro de ({}) y luego
    // se crea un parametro que la regule (esto no se muy bien pq). La forma de hacerlo es poner la clase
    @Mappings({
            //@Mapping (sin s al final) le dice que elemento vamos a mappear. Le debemos dar el origen y en que lo
            // queremos convertir. Tomar de referencia siempre las clases que estan en el dominio y ponerlas en source.
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    // @InheritInverseConfiguration sirve la enviar la informacion externa a la tabla interna que estamos protegiendo
    // Como esta conversion en la inversa a la dicha arriba, por lo tanto no se tiene que definir @Mappings o @Mapping
    // para las cosas que ya definimos arriba.
    // La unica excepcion, son aquellos atributos que estan en categoria, que no tienen un atributo en category.
    // En este caso le tenemos que decir explicitamente que los tenemos que ignorar.
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategory(Category category);
}
