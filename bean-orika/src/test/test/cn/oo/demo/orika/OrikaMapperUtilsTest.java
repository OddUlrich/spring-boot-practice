package cn.oo.demo.orika;

import cn.oo.demo.orika.model.MemberInfoDTO;
import cn.oo.demo.orika.model.MemberInfoVO;
import cn.oo.demo.orika.model.PersonDesInfo;
import cn.oo.demo.orika.model.PersonSrcInfo;
import cn.oo.demo.orika.utils.OrikaMapperUtils;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.time.LocalDate;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

/**
 * 封装通用工具类，调用orika方法实现实体映射
 */
public class OrikaMapperUtilsTest {

    @Test
    void testBasicObjectMap() {
        MemberInfoDTO dto = initMemberInfo();
        MemberInfoVO vo = new MemberInfoVO();
        OrikaMapperUtils.map(dto, vo);
        assertMemberInfoEquals(dto, vo);
    }

    @Test
    void testBasicClazzMap() {
        MemberInfoDTO dto = initMemberInfo();
        MemberInfoVO vo = OrikaMapperUtils.map(dto, MemberInfoVO.class);
        assertMemberInfoEquals(dto, vo);
    }

    @Test
    void testMapAsList() {

        MemberInfoDTO dto1 = initMemberInfo();
        MemberInfoDTO dto2 = initMemberInfo2();
        List<MemberInfoDTO> dtoList = Lists.newArrayList(dto1, dto2);
        List<MemberInfoVO> voList = OrikaMapperUtils.mapAsList(dtoList, MemberInfoVO.class);
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
}
