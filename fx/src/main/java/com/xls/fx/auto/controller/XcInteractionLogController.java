package com.xls.fx.auto.controller;

import javax.validation.Valid;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.xls.fx.config.PageInfo;
import com.xls.fx.auto.entity.XcInteractionLog;
import com.xls.fx.auto.service.XcInteractionLogService;
import com.xls.fx.config.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenshuaikai
 * @since 2020-04-29
 */
@Controller
@RequestMapping("/xcInteractionLog")
public class XcInteractionLogController extends BaseController {

    @Autowired private XcInteractionLogService xcInteractionLogService;

    @GetMapping("/manager")
    public String manager() {
        return "admin/xcInteractionLog/xcInteractionLogList";
    }

    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(XcInteractionLog xcInteractionLog, Integer page, Integer rows, String sort,String order) {
        PageInfo pageInfo = new PageInfo(page, rows, isAsc(sort), order);
        EntityWrapper<XcInteractionLog> ew = new EntityWrapper<XcInteractionLog>(xcInteractionLog);
        Page<XcInteractionLog> pages = getPage(page, rows, sort, order);
        pages = xcInteractionLogService.selectPage(pages, ew);
        pageInfo.setRecords(pages.getRecords());
        pageInfo.setTotal(pages.getTotal());
        return pageInfo;
    }

    /**
     * 添加页面
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "admin/xcInteractionLog/xcInteractionLogAdd";
    }

    /**
     * 添加
     * @param
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(@Valid XcInteractionLog xcInteractionLog) {
        //xcInteractionLog.setCreateTime(new Date());
        boolean b = xcInteractionLogService.insert(xcInteractionLog);
        return null;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Object delete(Long id) {
        XcInteractionLog xcInteractionLog = new XcInteractionLog();
         boolean b = xcInteractionLogService.updateById(xcInteractionLog);
      return null;
    }

    /**
     * 编辑
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/editPage")
    public String editPage(Model model, Long id) {
        XcInteractionLog xcInteractionLog = xcInteractionLogService.selectById(id);
        model.addAttribute("xcInteractionLog", xcInteractionLog);
        return "admin/xcInteractionLog/xcInteractionLogEdit";
    }

    /**
     * 编辑
     * @param
     * @return
     */
    @PostMapping("/edit")
    @ResponseBody
    public Object edit(@Valid XcInteractionLog xcInteractionLog) {
        boolean b = xcInteractionLogService.updateById(xcInteractionLog);
        return null;
    }
}