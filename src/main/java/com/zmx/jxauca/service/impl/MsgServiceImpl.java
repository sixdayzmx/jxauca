package com.zmx.jxauca.service.impl;

import com.zmx.jxauca.entity.Msg;
import com.zmx.jxauca.mapper.MsgMapper;
import com.zmx.jxauca.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private MsgMapper msgMapper;

    @Override
    public List<Msg> showAll() {
        return msgMapper.selectAll();
    }

    @Override
    public int addComment(Msg msg) {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(date.getTime());
        msg.setRtime(timestamp);
        int RTId = msgMapper.selectMaxRTId();
        msg.setRtid(++RTId);
        int integer = msgMapper.addComment(msg);
        //将RTid生成一下加入其中
        return integer;
    }

    @Override
    public List<Msg> showAllR() {
        return msgMapper.selectAllR();
    }
}
