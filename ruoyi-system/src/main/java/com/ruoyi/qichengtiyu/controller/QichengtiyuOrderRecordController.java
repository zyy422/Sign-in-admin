package com.ruoyi.qichengtiyu.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.qichengtiyu.domain.QichengtiyuCourse;
import com.ruoyi.qichengtiyu.domain.QichengtiyuOrder;
import com.ruoyi.qichengtiyu.domain.QichengtiyuUser;
import com.ruoyi.qichengtiyu.service.IQichengtiyuOrderService;
import com.ruoyi.qichengtiyu.service.IQichengtiyuUserService;
import com.ruoyi.qichengtiyu.service.impl.QichengtiyuTeacherSignServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/qichengtiyu/orderRecord")
public class QichengtiyuOrderRecordController implements InitializingBean {
    private Map<String, String> weekMap = new HashMap<>();

    private String prefix = "qichengtiyu/orderRecord";
    @Autowired
    private QichengtiyuTeacherSignServiceImpl qichengtiyuTeacherSignService;

    @Autowired
    private IQichengtiyuUserService iQichengtiyuUserService;

    @Autowired
    private IQichengtiyuOrderService iQichengtiyuOrderService;


    @GetMapping()
    public String course(Model model)
    {
        List<QichengtiyuCourse> courseNames = qichengtiyuTeacherSignService.queryAllCourse();
        model.addAttribute("courseNames",courseNames);
        return prefix + "/orderRecord";
    }

    @RequestMapping("/recordSubmit")
    @ResponseBody
    public AjaxResult recordSubmit(@RequestBody Map map, Model model) throws ParseException {
        long courseId = Long.parseLong((String) map.get("courseId"));
        String courseName = (String) map.get("courseName");
        String studentId = (String) map.get("studentId");
        String payAmt = (String) map.get("payAmt");
        List<String> selectedWeekday = (List<String>) map.get("weekday");
        long courseCount = Long.parseLong((String) map.get("courseCount"));

        QichengtiyuUser user = iQichengtiyuUserService.selectQichengtiyuUserByUserId(Long.valueOf(studentId));


        QichengtiyuOrder order = new QichengtiyuOrder();
        order.setCourseId(courseId);
        order.setCourseName(courseName);
        order.setStudentId(studentId);
        order.setPayAmt(new BigDecimal(payAmt));
        order.setTotalCourse(courseCount);
        order.setRemainCourse(courseCount);
        order.setPayTime(new Date());
        order.setUsername(user.getUsername());
        order.setStudentNickname(user.getNickname());
        StringBuilder weekday = new StringBuilder();
        for (String eachSelected : selectedWeekday) {
            weekday.append(this.weekMap.get(eachSelected)).append("|");
        }
        order.setCourseWeek(weekday.toString());
        int indertedNo = iQichengtiyuOrderService.insertQichengtiyuOrder(order);

        return indertedNo == 1 ? AjaxResult.success(): AjaxResult.error();
    }

    @RequestMapping("/queryStudentName")
    @ResponseBody
    public Object queryStudentName(@RequestBody Map map, Model model) throws ParseException {
        long studentId = Long.parseLong((String) map.get("studentId"));
        QichengtiyuUser students = iQichengtiyuUserService.selectQichengtiyuUserByUserId(studentId);
        Map res = new HashMap();
        res.put("studentName", students==null ? "用户不存在！" : students.getUsername());
        return res;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        weekMap.put("1","星期一");
        weekMap.put("2","星期二");
        weekMap.put("3","星期三");
        weekMap.put("4","星期四");
        weekMap.put("5","星期五");
        weekMap.put("6","星期六");
        weekMap.put("7","星期日");
    }
}
