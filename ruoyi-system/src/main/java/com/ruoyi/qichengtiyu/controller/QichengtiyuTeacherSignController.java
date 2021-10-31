package com.ruoyi.qichengtiyu.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.qichengtiyu.domain.QichengtiyuCheckin;
import com.ruoyi.qichengtiyu.domain.QichengtiyuCourse;
import com.ruoyi.qichengtiyu.domain.QichengtiyuOrder;
import com.ruoyi.qichengtiyu.service.IQichengtiyuCheckinService;
import com.ruoyi.qichengtiyu.service.IQichengtiyuCourseService;
import com.ruoyi.qichengtiyu.service.IQichengtiyuOrderService;
import com.ruoyi.qichengtiyu.service.impl.QichengtiyuTeacherSignServiceImpl;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/qichengtiyu/teacherSign")
public class QichengtiyuTeacherSignController {

    private String prefix = "qichengtiyu/teacherSign";

    @Autowired
    private QichengtiyuTeacherSignServiceImpl qichengtiyuTeacherSignService;

    @Autowired
    private IQichengtiyuCourseService qichengtiyuCourseService;

    @Autowired
    private IQichengtiyuCheckinService iQichengtiyuCheckinService;

    @Autowired
    private IQichengtiyuOrderService iQichengtiyuOrderService;

    @Autowired
    private ISysUserService iSysUserService;

    @GetMapping()
    public String teacherSign(Model model){
        List<QichengtiyuCourse> courseNames = qichengtiyuTeacherSignService.queryAllCourse();
        model.addAttribute("courseNames",courseNames);
        return prefix+"/teacherSign";
    }

    @RequestMapping("/getStudents")
    @ResponseBody
    public List getStudents(@RequestBody Map map, Model model){
        long courseId = Long.parseLong((String) map.get("courseId"));
        List students = qichengtiyuTeacherSignService.queryAllUserWithOutSign(courseId);
        return students;
    }

    @RequestMapping("/signByTeacher")
    @ResponseBody
    public AjaxResult signByTeacher(@RequestBody Map map, Model model) throws ParseException {
        String courseId = (String) map.get("courseId");
        String studentId = (String) map.get("studentId");
        String signDate = (String) map.get("signDate");
        String orderId = (String) map.get("orderId");

        // 获取当前的用户信息
        SysUser currentUser = ShiroUtils.getSysUser();
        // 获取当前的用户名称
        String userName = currentUser.getUserName();

        QichengtiyuOrder selectedOrder = iQichengtiyuOrderService.selectQichengtiyuOrderByOrderId(Long.parseLong(orderId));
        if (selectedOrder.getRemainCourse()-1 >=0) {
            selectedOrder.setRemainCourse(selectedOrder.getRemainCourse()-1);
        } else {
            return AjaxResult.error("余课不足");
        }

        QichengtiyuCheckin qichengtiyuCheckin = new QichengtiyuCheckin();
        qichengtiyuCheckin.setOrderId(selectedOrder.getOrderId());
        qichengtiyuCheckin.setCourseId(courseId);
        qichengtiyuCheckin.setCourseName(selectedOrder.getCourseName());
        qichengtiyuCheckin.setCourseDate(signDate);
        qichengtiyuCheckin.setStudentId(studentId);
        qichengtiyuCheckin.setStudentNickname(selectedOrder.getStudentNickname());
        qichengtiyuCheckin.setUsername(selectedOrder.getUsername());
        qichengtiyuCheckin.setIsSigned(1); //已签到
        qichengtiyuCheckin.setIschecked(1);//已核销
        qichengtiyuCheckin.setSignDatetime(new Date());
        qichengtiyuCheckin.setCheckedDatetime(new Date());
        qichengtiyuCheckin.setCheckinUser(userName);

        QichengtiyuCheckin duplicateCheckin = new QichengtiyuCheckin();
        duplicateCheckin.setCourseDate(qichengtiyuCheckin.getCourseDate());
        duplicateCheckin.setCourseId(qichengtiyuCheckin.getCourseId());
        duplicateCheckin.setOrderId(qichengtiyuCheckin.getOrderId());
        List duplicateCheckins = iQichengtiyuCheckinService.selectQichengtiyuCheckinList(duplicateCheckin);
        if (duplicateCheckins.isEmpty()) {
            iQichengtiyuCheckinService.insertQichengtiyuCheckin(qichengtiyuCheckin);
            iQichengtiyuOrderService.updateQichengtiyuOrder(selectedOrder);
            return AjaxResult.success();
        } else {
            return AjaxResult.error("请勿重复签到");
        }

    }
}
