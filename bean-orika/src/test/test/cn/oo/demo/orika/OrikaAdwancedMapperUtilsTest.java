package cn.oo.demo.orika;

import com.alibaba.fastjson.JSONObject;
import cn.oo.demo.orika.model.MemberInfoDTO;
import cn.oo.demo.orika.model.MemberInfoVO;
import cn.oo.demo.orika.model.PersonDesInfo;
import cn.oo.demo.orika.model.PersonSrcInfo;
import cn.oo.demo.orika.utils.OrikaAdvancedMapperUtils;
import cn.oo.demo.orika.utils.OrikaMapperUtils;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

/**
 * 封装进阶通用工具类，允许指定字段间映射关系，调用orika方法实现实体映射
 */
public class OrikaAdwancedMapperUtilsTest {

    @BeforeTest
    void beforeTestPrintMapperFacadeCache() {
        System.out.println("\nBefore orika advanced test:");
        System.out.println("\n\t" + JSONObject.toJSONString(OrikaAdvancedMapperUtils.getCacheMapper()));
    }

    @AfterTest
    void AfterTestPrintMapperFacadeCache() {
        System.out.println("\nAfter orika advanced test:");
        System.out.println("\n\t" + JSONObject.toJSONString(OrikaAdvancedMapperUtils.getCacheMapper()));
    }

    @Test
    void testBasicObjectMap() {
        MemberInfoDTO dto = initMemberInfo();
        MemberInfoVO vo = new MemberInfoVO();
        OrikaAdvancedMapperUtils.map(dto, vo);
        assertMemberInfoEquals(dto, vo);
    }

    @Test
    void testBasicClazzMap() {
        MemberInfoDTO dto = initMemberInfo();
        MemberInfoVO vo = OrikaAdvancedMapperUtils.map(dto, MemberInfoVO.class);
        assertMemberInfoEquals(dto, vo);
    }

    @Test
    void testMapAsList() {

        MemberInfoDTO dto1 = initMemberInfo();
        MemberInfoDTO dto2 = initMemberInfo2();
        List<MemberInfoDTO> dtoList = Lists.newArrayList(dto1, dto2);
        List<MemberInfoVO> voList = OrikaAdvancedMapperUtils.mapAsList(dtoList, MemberInfoVO.class);
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
    void testBasicObjectMapDiffFieldName() {
        Map<String, String> fieldMap = new HashMap<>(16);
        fieldMap.put(PersonSrcInfo.Fields.name, PersonDesInfo.Fields.personName);
        fieldMap.put(PersonSrcInfo.Fields.birth, PersonDesInfo.Fields.dateOfBirth);
        fieldMap.put(PersonSrcInfo.Fields.email, PersonDesInfo.Fields.emailAddress);

        PersonSrcInfo dto = initPersonInfo();
        PersonDesInfo vo = new PersonDesInfo();
        OrikaAdvancedMapperUtils.map(dto, vo, fieldMap);
        assertPersonInfoEquals(dto, vo);
    }

    @Test
    void testBasicClazzMapDiffFieldName() {
        Map<String, String> fieldMap = new HashMap<>(16);
        fieldMap.put(PersonSrcInfo.Fields.name, PersonDesInfo.Fields.personName);
        fieldMap.put(PersonSrcInfo.Fields.birth, PersonDesInfo.Fields.dateOfBirth);
        fieldMap.put(PersonSrcInfo.Fields.email, PersonDesInfo.Fields.emailAddress);

        PersonSrcInfo dto = initPersonInfo();
        PersonDesInfo vo = OrikaAdvancedMapperUtils.map(dto, PersonDesInfo.class, fieldMap);
        assertPersonInfoEquals(dto, vo);
    }

    @Test
    void testMapAsListDiffFieldName() {
        Map<String, String> fieldMap = new HashMap<>(16);
        fieldMap.put(PersonSrcInfo.Fields.name, PersonDesInfo.Fields.personName);
        fieldMap.put(PersonSrcInfo.Fields.birth, PersonDesInfo.Fields.dateOfBirth);
        fieldMap.put(PersonSrcInfo.Fields.email, PersonDesInfo.Fields.emailAddress);

        PersonSrcInfo dto1 = initPersonInfo();
        PersonSrcInfo dto2 = initPersonInfo2();
        List<PersonSrcInfo> dtoList = Lists.newArrayList(dto1, dto2);
        List<PersonDesInfo> voList = OrikaAdvancedMapperUtils.mapAsList(dtoList, PersonDesInfo.class, fieldMap);
        for (int i = 0; i < dtoList.size(); ++i) {
            assertPersonInfoEquals(dtoList.get(i), voList.get(i));
        }
    }

    private PersonSrcInfo initPersonInfo() {
        PersonSrcInfo person = new PersonSrcInfo();
        person.setId(1000100010001L);
        person.setName("Gogo");
        person.setAge(14);
        person.setBirth(LocalDate.of(1996, 3, 23));
        person.setEmail("gogo@oo.com");
        return person;
    }

    private PersonSrcInfo initPersonInfo2() {
        PersonSrcInfo person = new PersonSrcInfo();
        person.setId(1000100020001L);
        person.setName("Tony");
        person.setAge(35);
        person.setBirth(LocalDate.of(2004, 6, 19));
        person.setEmail("Tony@oo.com");
        return person;
    }

    private void assertPersonInfoEquals(PersonSrcInfo src, PersonDesInfo dest) {
        assertEquals(src.getId(), dest.getId());
        assertEquals(src.getName(), dest.getPersonName());
        assertEquals(src.getAge(), dest.getAge());
        assertEquals(src.getEmail(), dest.getEmailAddress());
        assertEquals(src.getBirth(), dest.getDateOfBirth());
    }
}
