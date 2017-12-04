package com.dse.reservoir.zlgl.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.zlgl.wdzl.WordglService;
import com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo.QuestionModel;
import com.dse.reservoir.zlgl.wdzl.util.DseJsonUtil;
import com.dse.service.api.baseplatform.inf.dubbo.UserServiceDubbo;
import com.dse.service.api.baseplatform.vo.pojo.sys.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Xll on 2017/6/22.
 *  文档管理
 * @Company 深圳市东深电子股份有限公司
 */
@Controller
@RequestMapping("/wdglCtrl")
public class WdglCtrl {
    @Resource(name="userServiceDubbo")
    private UserServiceDubbo userService;
    @Autowired
    private WordglService service;
    @RequestMapping(value = "/getListInfoByParams")
    @ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) {
        try {
            String adcd = request.getParameter("adcd");//行政区划
            String ttype = request.getParameter("ttype");//文档类型
            String keyword = request.getParameter("keyword");//标题
            String strDate = request.getParameter("strDate");
            String endDate = request.getParameter("endDate");
            return service.getListInfoByParams(adcd, ttype, keyword, strDate, endDate, easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/deleteInfoByIds")
    @ResponseBody
    public Object deleteInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(service.deleteInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/saveOrUpdateInfo")
    @ResponseBody
    public Object saveOrUpdateInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String creator = request.getRemoteUser();//上传人
            UserVO user = new UserVO();
            user.setUserName(creator);
            user = userService.getUserByUserName(user);
            creator=user.getName();
            String dataStr=request.getParameter("dataStr");

            return InvokeResult.success(service.saveOrUpdateInfo(dataStr,creator));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  保存问题清单
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateQuestion")
    @ResponseBody
    public Object saveOrUpdateQuestion(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
//            String creator = request.getRemoteUser();//上传人

            String dataStr=request.getParameter("dataStr");
            if(dataStr.equals("[]")){
                return InvokeResult.success(true);
            }else {
                List<QuestionModel> quesList = JsonUtil.json2List(dataStr, QuestionModel.class);
                return InvokeResult.success(service.saveOrUpdateQuestion(quesList));
            }
        } catch (Exception e) {
           e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

}
