package cn.oo.demo.mapstruct.model.struct;

import cn.oo.demo.mapstruct.model.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.Map;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    @Mapping(target = "name", source = "customer.name")
    Customer toCustomer(Map<String, String> map);
}
