/**
 * 
 */
package com.dse.reservoir.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.entity.TreeNode;
import com.dse.reservoir.api.pojo.entity.Example;
import com.dse.reservoir.api.pojo.vo.ExampleVO;
import com.dse.reservoir.api.service.ExampleService;
import com.dse.service.api.baseplatform.inf.DictionaryService;
import com.dse.service.api.baseplatform.vo.pojo.sys.DictionaryVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by zhoujc on 2016-3-3.
 */
@Controller
@RequestMapping("/exampleController")
public class ExampleController {

	@Resource(name = "exampleService")
	private ExampleService exampleService;


	public static class ExampleParams{

		ExampleVO exampleVO;
		EasyUiPage easyUiPage;

		public ExampleVO getExampleVO() {
			return exampleVO;
		}

		public void setExampleVO(ExampleVO exampleVO) {
			this.exampleVO = exampleVO;
		}

		public EasyUiPage getEasyUiPage() {
			return easyUiPage;
		}

		public void setEasyUiPage(EasyUiPage easyUiPage) {
			this.easyUiPage = easyUiPage;
		}
	}

	/**
	 * 查询字典项列表，带参数
	 * @param request
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value = "listDictionary",method = RequestMethod.POST)
	@ResponseBody
	public EasyUiPage findDictionary(@RequestBody ExampleParams dictionaryParams, HttpServletRequest request) throws Exception{
		return exampleService.findExample(dictionaryParams.getExampleVO(),dictionaryParams.getEasyUiPage());
	}

	/**
	 * 通过ID获取字典
	 * @param exampleVO
	 * @param request
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value = "getExampleById",method = RequestMethod.POST)
	@ResponseBody
	public ExampleVO getExampleById(@RequestBody ExampleVO exampleVO, HttpServletRequest request) throws Exception{
		return exampleService.getExampleById(exampleVO);
	}


	/**
	 * 保存角色
	 * @return
	 */
	@RequestMapping(value = "saveExample",method = RequestMethod.POST)
	@ResponseBody
	public String saveExample(@RequestBody ExampleVO exampleVO) throws Exception{
		return exampleService.saveExample(exampleVO);
	}


	/**
	 * 根据数据项id删除下级所有数据项
	 * @return
	 */
	@RequestMapping(value = "removeExampleById",method = RequestMethod.POST)
	@ResponseBody
	public Boolean removeExampleById(@RequestBody ExampleVO exampleVO) throws Exception{
		return exampleService.removeExampleById(exampleVO);
	}





}
