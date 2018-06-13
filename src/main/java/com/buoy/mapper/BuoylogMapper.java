package com.buoy.mapper;

import com.buoy.entity.Buoylog;
import com.buoy.entity.BuoylogExample;
import com.buoy.util.Page;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuoylogMapper {
    int countByExample(BuoylogExample example);

    int deleteByExample(BuoylogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Buoylog record);

    int insertSelective(Buoylog record);

    List<Buoylog> selectByExample(BuoylogExample example);

    Buoylog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Buoylog record, @Param("example") BuoylogExample example);

    int updateByExample(@Param("record") Buoylog record, @Param("example") BuoylogExample example);

    int updateByPrimaryKeySelective(Buoylog record);

    int updateByPrimaryKey(Buoylog record);
    
//    List<Buoylog> selectAll(@Param("page") Page page);
    
    int selectCount(@Param("fromDay") String fromDay,@Param("toDay")String toDay);
    
    List<Buoylog> selectByPage(@Param("page") Page page,@Param("fromDay") String fromDay,@Param("toDay")String toDay);
    
    //List<Buoylog> selectLike(@Param("day") String day);

}
