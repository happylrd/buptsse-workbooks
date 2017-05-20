package com.buptsse.spm.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import com.alibaba.fastjson.JSONObject;
import com.buptsse.spm.domain.BasicInfo;
import com.buptsse.spm.service.IBasicInfoService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @date 2015年11月7日 上午9:30:13
 * @description 实现基本信息的显示，包括：学术水平、案例分析、课程特色、联系我们、
 * 教学大纲、知识点索引、参考书目、教学团队、教学计划
 * @modifyDate 2015年11月7日 上午11:56
 * @description 实现基本信息的显示，包括：课程简介，考评方式，考试大纲，校企合作，
 * 模拟试卷
 */

public class BasicInfoAction extends ActionSupport {

    @Resource
    private IBasicInfoService iBasicInfoService;

    public String name;
    public String content;
    protected BasicInfo basicInfo;
    public String picturePath = "";
    public List<File> upload;

    public String enterBasicInfo() {

        System.out.println("**********进入跳转页面**********：" + name);
        if ("exerciseMain".equals(name)) {
            basicInfo = iBasicInfoService.getBasicInfoByName("exercise0");
        } else {
            basicInfo = iBasicInfoService.getBasicInfoByName(name);
        }

        basicInfo.setContent(changeFormat(basicInfo.getContent()));


        System.out.println("basicInfo.getContent():" + basicInfo.getContent());

        return name;
    }

    public String editBasicInfo() {

        System.out.println("**********进入基本信息修改页面**********：" + name);
        if ("exerciseMain".equals(name)) {
            basicInfo = iBasicInfoService.getBasicInfoByName("exercise0");
        } else {
            basicInfo = iBasicInfoService.getBasicInfoByName(name);
        }
        System.out.println("basicInfo.getContent():" + basicInfo.getContent());

        return "success";
    }

    public String updateBasicInfo() {

        System.out.println("**********进入基本信息修改确认页面**********：" + basicInfo.getName());
        System.out.println("**********进入基本信息修改确认页面**********：" + basicInfo.getIdCourseInfo());
        boolean flag = false;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            flag = iBasicInfoService.saveOrUpdate(basicInfo);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        if (flag) {
            map.put("code", "1");
            map.put("message", "修改成功！");
        } else {
            map.put("code", "2");
            map.put("message", "修改失败，请联系管理员！");
        }
        String str = JSONObject.toJSONString(map);
        try {
            ServletActionContext.getResponse().getWriter().write(str);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("basicInfo.getContent():" + basicInfo.getContent());

        return null;
    }

    public String changeFormat(String content) {
        for (int i = 1; i < content.length(); ) {
            String left = content.substring(0, i);
            String right = content.substring(i + 1);

            if (content.charAt(i) == ' ') {
                content = left + "&nbsp;" + right;
                i += 7;
            } else if (content.charAt(i) == '\t') {
                content = left + "&nbsp;&nbsp;&nbsp;&nbsp;" + right;
                i += 25;
            } else if (content.charAt(i) == '\n' || content.charAt(i) == '\r') {
                content = left + "<br/>" + right;
                i += 6;
            } else {
                i++;
            }
        }
        return content;
    }

    public void setBasicinfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public List<File> getUpload() {
        return upload;
    }

    public void setUpload(List<File> upload) {
        this.upload = upload;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BasicInfo getBasicinfo() {
        return this.basicInfo;
    }

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public IBasicInfoService getiBasicInfoService() {
        return iBasicInfoService;
    }

    public void setiBasicInfoService(IBasicInfoService iBasicInfoService) {
        this.iBasicInfoService = iBasicInfoService;
    }
}