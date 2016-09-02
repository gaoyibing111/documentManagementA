package com.fh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.system.Menu;
import com.fh.entity.system.Usysparam;
import com.fh.util.PageData;

@Service("usysparamService")
public class UsysparamService {
	
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	public void deleteUsysparamById(Usysparam usysparam) throws Exception {
		dao.save("UsysparamMapper.delete", usysparam);
	}

	public Usysparam queryUsysparamByCode(Usysparam usysparam) throws Exception {
		return (Usysparam) dao.findForObject("UsysparamMapper.queryUsysparamByCode", usysparam);
	}
	
	public List<Usysparam> queryAll(Usysparam recode) throws Exception {
		return  (List<Usysparam>) dao.findForList("UsysparamMapper.selectAll", null);
	}
	
	public List<Usysparam> query(String gcode, String scode) throws Exception {
		Usysparam param = new Usysparam();
		param.setGcode(gcode);
		param.setScode(scode);
		return (List<Usysparam>) dao.findForList("UsysparamMapper.selectDefault", null);
	}
	
	public Usysparam queryUsysparamByCode(String gcode, String scode) throws Exception {
		return  (Usysparam) dao.findForList("UsysparamMapper.queryUsysparamByCode", null);
	}
	
	public void saveUsysparam(Usysparam obj, String operation) throws Exception {
		if("insert".equals(operation)){
			dao.save("UsysparamMapper.insert", obj);
		}else{
			dao.save("UsysparamMapper.updateByPrimaryKey", obj);
		}
	}
	
	public void deleteByGcodeAndMcode(Usysparam usysparam) throws Exception {
		dao.save("UsysparamMapper.delete", usysparam);
	}
}
