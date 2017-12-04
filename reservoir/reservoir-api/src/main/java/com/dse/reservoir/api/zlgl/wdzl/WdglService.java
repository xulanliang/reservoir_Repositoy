package com.dse.reservoir.api.zlgl.wdzl;

/**
 * Created by 许兰良 on 2017/6/21.
 *
 * @Company 深圳市东深电子股份有限公司
 */
public interface WdglService {

    /**
     * 获取字典里表
     * @param pcode
     * @return
     * @throws Exception
     */
    public Object getListBycode( String pcode) throws Exception;

}
