package com.fh.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
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
	
	
	
}
