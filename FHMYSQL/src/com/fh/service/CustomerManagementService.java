package com.fh.service;

import java.util.List;

import javax.annotation.Resource;

import com.fh.controller.SerchVehicleController;
import com.fh.entity.RemoteResp.PayVehicleResp;
import com.fh.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("customermanagementService")
public class CustomerManagementService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@Autowired
	UserPayVehicleService userPayVehicleService;
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("CustomerManagementMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("CustomerManagementMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("CustomerManagementMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("CustomerManagementMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CustomerManagementMapper.listAll", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("CustomerManagementMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("CustomerManagementMapper.deleteAll", ArrayDATA_IDS);
	}


	/**
	 * 根据用户名，获取 tb_count_exp_time 表数据  并查询 最新的车辆所属单位
	 */
	public  List<PageData> getCountExpTimeByUserName(Page page) throws Exception {
		List<PayVehicleResp> respList=userPayVehicleService.userPayVehicleList(page.getPd().getString("USERNAME"));
		List<PageData> expTimeList=(List<PageData>)	dao.findForList("CustomerManagementMapper.getCountExpTimeByUserName",page);
		for(PageData pd:expTimeList){
			for(PayVehicleResp resp:respList){
				if(pd.get("PLATE_NUMBER").equals(resp.getPlateNumber())){
					pd.put("affiliatedFirm",resp.getAffiliatedFirm());//车辆所属单位
				}
			}

		}
		 return expTimeList;
	}
}

