package com.htg.adshow.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.htg.common.entity.adshow.Agency;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.htg.common.vo.adshow.AgencyPageVO;

import java.util.List;

/**
 * <p>
 * 机构表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
public interface AgencyMapper extends BaseMapper<Agency> {

    List<Agency> selectByParentId(Integer parentId);

    Agency selectByNum(String num);

    List<AgencyPageVO> selectByPage(Page<AgencyPageVO> page, String num, String contact, String contactNum);

    Agency selectByName(String name);

}
