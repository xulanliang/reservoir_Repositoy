package com.dse.reservoir.zlgl.web;

import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.comm.sys.service.DseSysCommonsqlService;
import com.dse.reservoir.api.zlgl.wdzl.WdglService;
import com.dse.service.api.baseplatform.inf.dubbo.DivisionServiceDubbo;
import com.dse.service.api.baseplatform.inf.dubbo.UserServiceDubbo;
import com.dse.service.api.baseplatform.vo.pojo.sys.DivisionVO;
import com.dse.service.api.baseplatform.vo.pojo.sys.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Xll on 2017/6/21.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Controller
@RequestMapping("/sysCommonCtrl")
public class SysCommonCtrl {

    @Resource(name = "wdglService")
    private WdglService wdglService;

    @Resource(name = "divisionServiceDubbo")
    private DivisionServiceDubbo divisionService;

    @Resource(name = "dseSysCommonsqlService")
    private DseSysCommonsqlService dseSysCommonsqlService;


    @Resource(name="userServiceDubbo")
    private UserServiceDubbo userService;

    /**
     * 获取测站信息
     * @author xiaoxf 2016年10月20日
     * @dataMap  传参： code 如为qxyj_xyxh
     * @return
     */
    @RequestMapping(value = "/getListBycode")
    @ResponseBody
    public Object getListBycode(@RequestParam String code , HttpServletRequest request) throws Exception {
        try {
            return InvokeResult.success(wdglService.getListBycode(code));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }



    /**
     * 获取用户
     * @param
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "initUserVo")
    @ResponseBody
    public InvokeResult<UserVO> initUserVo(String userName, HttpServletRequest request) {
        //单点登录请求获取用户方式
        //Object object = request.getSession().getAttribute(CONSTANT.USER_INFO);

        //request.getSession().setAttribute(CONSTANT.USER_INFO, user);
		/*if (object == null || !userName.equals(((UserVO)object).getUserName())) {
			user.setUserName(userName);
			try {
				return InvokeResult.success(user, new InvokeResultMessage("成功"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			user=(UserVO) object;
		}*/
        //非单点登录方式
        UserVO user = new UserVO();
        user.setUserName(userName);
        try {
            user = userService.getUserByUserName(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return InvokeResult.success(user, new InvokeResultMessage("失败"));
    }

    /**
     * 获取行政区划信息
     * @param  code ： 区划编码
     * @author ZHOUP
     * @date  2016年11月2日
     * @return
     */
    @RequestMapping("listAllDivisionByCode")
    @ResponseBody
    public Object listAllDivisionByCode(@RequestParam String code , HttpServletRequest request) throws Exception {
        try {
            DivisionVO vo = new DivisionVO();
            vo.setCode(code);
            return InvokeResult.success(divisionService.listAllDivisionByCode(vo));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取行政区划信息
     * @param  code : 区划编码
     * @author ZHOUP
     * @date  2016年11月2日
     * @return
     */
    @RequestMapping("divisionInfo")
    @ResponseBody
    public Object divisionInfo(@RequestParam String code ,HttpServletRequest request) throws Exception {
        try {
            return InvokeResult.success(dseSysCommonsqlService.divisionInfo(code));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  获取巡查对象分类、巡查类型
     * @param code
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getListBycode2")
    @ResponseBody
    public Object getListBycode2(String code , HttpServletRequest request) throws Exception {
        try {
            String state=request.getParameter("state");
            String ids=request.getParameter("ids");
            return InvokeResult.success(dseSysCommonsqlService.getListBycode(ids,state,code));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getWzInfoBycode2")
    @ResponseBody
    public Object getWzInfoBycode2(String code , HttpServletRequest request) throws Exception {
        try {
            String id=request.getParameter("ids");
            return InvokeResult.success(dseSysCommonsqlService.getWzInfoBycode2(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getListCheckObj")
    @ResponseBody
    public Object getListCheckObj(String code ,String ck_org , HttpServletRequest request) throws Exception {
        try {
            return InvokeResult.success(dseSysCommonsqlService.getListCheckObj(code,ck_org));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


}
