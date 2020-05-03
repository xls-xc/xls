package com.xls.fx.auto.controller;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xls.fx.auto.entity.XcInteractionLog;
import com.xls.fx.auto.service.XcInteractionLogService;

/**
 * XcInteractionLog 前端控制器
 * @author chenshuaikai
 * @since 2020-05-03
 */
@Controller
@RequestMapping("/xcInteractionLog")
public class XcInteractionLogController {


    @Autowired
    private XcInteractionLogService service;

    /**
    * 返回展示XcInteractionLog表数据的页面
    */
    @RequestMapping("/manager")
    public String xcInteractionLogList() {
        return "xcInteractionLogList";
    }



    /**
     *  返回XcInteractionLog表的所有数据  测试接口
     *  postman测试的时候直接发送参数即可，如果有@RequestBody，则需要发送json的参数不方便测试
     */
    @RequestMapping("/test")
    @ResponseBody
    public Map<String,Object> test(Map query) {
        return service.findAllXcInteractionLog(query);
    }

    /**
    *  返回XcInteractionLog表的所有数据
    */
    @RequestMapping("/dataGrid")
    @ResponseBody
    public Map<String,Object> dataGrid(@RequestBody Map query) {
        return service.findAllXcInteractionLog(query);
    }

    /**
    * 添加XcInteractionLog表数据
    */
    @RequestMapping("/addXcInteractionLog")
    @ResponseBody
    public Map<String,Object> addXcInteractionLog(XcInteractionLog xcInteractionLog) {
        return service.addXcInteractionLog(xcInteractionLog);
    }


    /**
    * 删除XcInteractionLog表指定的数据
    */
    @RequestMapping("/delXcInteractionLog")
    @ResponseBody
    public Map<String,Object>delXcInteractionLogById(Integer primaryKeyId) {
            return service.delXcInteractionLogById(primaryKeyId);
    }

    /**
     * 根据XcInteractionLog表的主键id修改表的信息
     */
    @RequestMapping("/updateXcInteractionLog")
    @ResponseBody
    public Map<String,Object> updateXcInteractionLogById(@RequestBody XcInteractionLog xcInteractionLog) {
        return service.updateXcInteractionLogById(xcInteractionLog);
    }
}
