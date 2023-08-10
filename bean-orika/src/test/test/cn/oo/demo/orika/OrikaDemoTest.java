package cn.oo.demo.orika;

import cn.oo.demo.orika.model.MemberInfoDTO;
import cn.oo.demo.orika.model.MemberInfoVO;
import cn.oo.demo.orika.model.PersonDesInfo;
import cn.oo.demo.orika.model.PersonSrcInfo;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.time.LocalDate;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

/**
 * 显式调用orika方法实现实体映射
 */
public class OrikaDemoTest {

    @Test
    void testBasicMap() {
        DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        MapperFacade facade = mapperFactory.getMapperFacade();

        MemberInfoDTO dto = initMemberInfo();
        MemberInfoVO vo = facade.map(dto, MemberInfoVO.class);
//        facade.map(dto, vo);
        assertMemberInfoEquals(dto, vo);
    }

    @Test
    void testMapAsList() {
        DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        MapperFacade facade = mapperFactory.getMapperFacade();

        MemberInfoDTO dto1 = initMemberInfo();
        MemberInfoDTO dto2 = initMemberInfo2();
        List<MemberInfoDTO> dtoList = Lists.newArrayList(dto1, dto2);
        List<MemberInfoVO> voList = facade.mapAsList(dtoList, MemberInfoVO.class);
        for (int i = 0; i < dtoList.size(); ++i) {
            assertMemberInfoEquals(dtoList.get(i), voList.get(i));
        }
    }

    private MemberInfoDTO initMemberInfo() {
        MemberInfoDTO member = new MemberInfoDTO();
        member.setId(1000100010001L);
        member.setName("Gogo");
        member.setAge(14);
        member.setEmail("gogo@oo.com");
        member.setIdentity("employee");
        member.setGroup("marketing");
        return member;
    }

    private MemberInfoDTO initMemberInfo2() {
        MemberInfoDTO member = new MemberInfoDTO();
        member.setId(1000100010002L);
        member.setName("Pato");
        member.setAge(42);
        member.setEmail("Pato@oo.com");
        member.setIdentity("manager");
        member.setGroup("customer-service");
        return member;
    }

    private void assertMemberInfoEquals(MemberInfoDTO dto, MemberInfoVO vo) {
        assertEquals(dto.getId(), vo.getId());
        assertEquals(dto.getName(), vo.getName());
        assertEquals(dto.getAge(), vo.getAge());
        assertEquals(dto.getGroup(), vo.getGroup());
        assertEquals(dto.getEmail(), vo.getEmail());
        assertEquals(dto.getIdentity(), vo.getIdentity());
    }

    @Test
    void testMapDiffFieldName() {
        DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        // 使用注解显式获取变量名，需要指定所有的字段映射关系，剩余通过 byDefault() 指定
        mapperFactory.classMap(PersonSrcInfo.class, PersonDesInfo.class)
                .field(PersonSrcInfo.Fields.name, PersonDesInfo.Fields.personName)
                .field(PersonSrcInfo.Fields.birth, PersonDesInfo.Fields.dateOfBirth)
                .field(PersonSrcInfo.Fields.email, PersonDesInfo.Fields.emailAddress)
                .exclude(PersonSrcInfo.Fields.removeVal)
                .byDefault()
                .register();

        MapperFacade facade = mapperFactory.getMapperFacade();

        PersonSrcInfo src = initPersonInfo();
        PersonDesInfo dest = facade.map(src, PersonDesInfo.class);
        assertPersonInfoEquals(src, dest);
    }

    private PersonSrcInfo initPersonInfo() {
        PersonSrcInfo person = new PersonSrcInfo();
        person.setId(1000100010001L);
        person.setName("Gogo");
        person.setAge(14);
        person.setBirth(LocalDate.of(2004, 6, 19));
        person.setEmail("gogo@oo.com");
        person.setRemoveVal("to be removed!");
        return person;
    }

    private void assertPersonInfoEquals(PersonSrcInfo src, PersonDesInfo dest) {
        assertEquals(src.getId(), dest.getId());
        assertEquals(src.getName(), dest.getPersonName());
        assertEquals(src.getAge(), dest.getAge());
        assertEquals(src.getEmail(), dest.getEmailAddress());
        assertEquals(src.getBirth(), dest.getDateOfBirth());

        assertEquals(src.getRemoveVal(), "to be removed!");
        assertNull(dest.getRemoveVal());

    }
}
