package com.fh.service;

import java.util.List;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import com.fh.controller.SerchVehicleController;
import com.fh.util.DateUtil;
import com.fh.util.UuidUtil;
import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("oplogService")
public class OplogService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("OplogMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("OplogMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("OplogMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("OplogMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("OplogMapper.listAll", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("OplogMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("OplogMapper.deleteAll", ArrayDATA_IDS);
	}

	/**
	 * 通过时间和关键字查询日志
	 */

	public List<PageData> queryByDate(Page page)throws Exception{
		return (List<PageData>)dao.findForList("OplogMapper.queryByDate", page);
	}

	/**
	 * 保存错误日志到表
	 * @param pd
	 */
	public void saveLog( PageData pd){
		pd.put("CREATE_DATE", DateUtil.getTime());
		pd.put("OPLOG_ID", UuidUtil.get32UUID());
		pd.put("OPERATOR", SerchVehicleController.getUserInfo().getNAME());
		pd.put("OPERATOR_ROLE", SerchVehicleController.getUserInfo().getRole());
		pd.put("USERNAME", SerchVehicleController.getUserInfo().getUSERNAME());
		saveLogThread(pd);
	}

	//异步保存日志
	public void saveLogThread(final PageData pd) {
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					dao.save("OplogMapper.save", pd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}

