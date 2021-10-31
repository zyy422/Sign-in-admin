package com.ruoyi.aspect;

import com.ruoyi.qichengtiyu.domain.QichengtiyuCheckin;
import com.ruoyi.qichengtiyu.service.impl.QichengtiyuWxNoticeServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WxNoticeAspect {

    @Autowired
    QichengtiyuWxNoticeServiceImpl qichengtiyuWxNoticeService;
    /**
     * 定义一个切面，拦截com.itcodai.course09.controller包和子包下的所有方法
     */
    @Pointcut("execution(* com.ruoyi.qichengtiyu.controller.QichengtiyuCheckinController.editSave(..))")
    public void pointCut() {}

    /**
     * 进行核销后发送客户通知
     * @param joinPoint
     */
    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        QichengtiyuCheckin qichengtiyuCheckin = (QichengtiyuCheckin) joinPoint.getArgs()[0];
        if (qichengtiyuCheckin.getIschecked() == 1) {
            qichengtiyuWxNoticeService.noticeWxMsgToUser(qichengtiyuCheckin);
        }
    }
}
