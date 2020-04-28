package com.xls.fx.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xls.fx.vo.XcInteractionLog;
import com.xls.fx.service.XcInteractionLogService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenshuaikai
 * @since 2020-04-28
 */
@Controller
@RequestMapping("/xcInteractionLog")
public class XcInteractionLogController {

    @Autowired private XcInteractionLogService xcInteractionLogService;

    @GetMapping("/manager")
    public String manager() {
        return "admin/xcInteractionLog/xcInteractionLogList";
    }

    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(XcInteractionLog xcInteractionLog, Integer page, Integer rows, String sort,String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        EntityWrapper<XcInteractionLog> ew = new EntityWrapper<XcInteractionLog>(xcInteractionLog);
        Page<XcInteractionLog> pages = getPage(page, rows, sort, order);
        pages = xcInteractionLogService.selectPage(pages, ew);
        pageInfo.setRows(pages.getRecords());
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
        xcInteractionLog.setCreateTime(new Date());
        xcInteractionLog.setUpdateTime(new Date());
        xcInteractionLog.setDeleteFlag(0);
        boolean b = xcInteractionLogService.insert(xcInteractionLog);
        if (b) {
            return renderSuccess("添加成功！");
        } else {
            return renderError("添加失败！");
        }
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
        xcInteractionLog.setId(id);
        xcInteractionLog.setUpdateTime(new Date());
        xcInteractionLog.setDeleteFlag(1);
        boolean b = xcInteractionLogService.updateById(xcInteractionLog);
        if (b) {
            return renderSuccess("删除成功！");
        } else {
            return renderError("删除失败！");
        }
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
        xcInteractionLog.setUpdateTime(new Date());
        boolean b = xcInteractionLogService.updateById(xcInteractionLog);
        if (b) {
            return renderSuccess("编辑成功！");
        } else {
            return renderError("编辑失败！");
        }
    }
}