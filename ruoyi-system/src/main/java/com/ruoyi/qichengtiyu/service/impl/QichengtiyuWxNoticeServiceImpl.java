package com.ruoyi.qichengtiyu.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaSubscribeService;
import cn.binarywang.wx.miniapp.api.impl.WxMaSubscribeServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import com.ruoyi.qichengtiyu.domain.QichengtiyuCheckin;
import com.ruoyi.qichengtiyu.domain.QichengtiyuCourse;
import com.ruoyi.qichengtiyu.domain.QichengtiyuOrder;
import com.ruoyi.qichengtiyu.domain.QichengtiyuUser;
import com.ruoyi.qichengtiyu.mapper.QichengtiyuCourseMapper;
import com.ruoyi.qichengtiyu.mapper.QichengtiyuOrderMapper;
import com.ruoyi.qichengtiyu.mapper.QichengtiyuUserMapper;
import me.chanjar.weixin.common.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class QichengtiyuWxNoticeServiceImpl {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    QichengtiyuOrderMapper qichengtiyuOrderMapper;

    @Resource
    QichengtiyuCourseMapper qichengtiyuCourseMapper;

    @Resource
    QichengtiyuUserMapper qichengtiyuUserMapper;

    @Autowired
    WxMaSubscribeService wxMaSubscribeService;

    public void noticeWxMsgToUser(QichengtiyuCheckin qichengtiyuCheckin){

        long orderId = qichengtiyuCheckin.getOrderId();
        long courseId = Long.parseLong(qichengtiyuCheckin.getCourseId());
        long userId = Long.parseLong(qichengtiyuCheckin.getStudentId());

        QichengtiyuOrder order = qichengtiyuOrderMapper.selectQichengtiyuOrderByOrderId(orderId);
        QichengtiyuCourse course = qichengtiyuCourseMapper.selectQichengtiyuCourseByCourseId(courseId);
        QichengtiyuUser user = qichengtiyuUserMapper.selectQichengtiyuUserByUserId(userId);
        String now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        // 课程签到确认，由管理员进行
        WxMaSubscribeMessage wxMaSubscribeMessage = new WxMaSubscribeMessage();
        List<WxMaSubscribeMessage.MsgData> data = new LinkedList() { {
            add(new WxMaSubscribeMessage.MsgData("phrase1", "签到已核销"));
            add(new WxMaSubscribeMessage.MsgData("thing2", "剩余课程： " + order.getRemainCourse()+"节"));
            add(new WxMaSubscribeMessage.MsgData("time3", now));
            add(new WxMaSubscribeMessage.MsgData("thing4", course.getCourseTeacher()));
        }};

        wxMaSubscribeMessage.setData(data);
        wxMaSubscribeMessage.setToUser(user.getWeixinOpenid());
        wxMaSubscribeMessage.setTemplateId("Llv1CgwbIBgyWfBLjS8zNUJI_JQ5EK936lKq9aZTh9Q");
        try {
            wxMaSubscribeService.sendSubscribeMsg(wxMaSubscribeMessage);
        } catch (WxErrorException e) {
            logger.error("发送消息通知异常！");
            e.printStackTrace();
        }
    }
}
