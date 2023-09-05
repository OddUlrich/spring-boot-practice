package cn.oo.demo.mapstruct.model.struct;

import cn.oo.demo.mapstruct.model.domain.multisource.Address;
import cn.oo.demo.mapstruct.model.domain.multisource.Person;
import cn.oo.demo.mapstruct.model.dto.multisource.DeliveryAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 从多个源获取数据完成映射
 */
@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "description", source = "person.description")
    @Mapping(target = "houseNumber", source = "address.houseNo")
    DeliveryAddressDTO personAndAddressToDeliveryAddressDto(Person person, Address address);
}
