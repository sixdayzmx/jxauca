package com.zmx.jxauca.mapper;

import com.zmx.jxauca.entity.Msg;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MsgMapper {
    public List<Msg> selectAll();
    public Integer addComment(Msg msg);
    public Integer selectMaxRTId();
    public List<Msg> selectAllR();
}
