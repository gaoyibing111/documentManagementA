package com.fh.entity.task;

import com.fh.controller.RegisterVehicleController;
import com.fh.service.UserFollowVehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
public class SpringClearRegisterQTZ {
@Autowired
UserFollowVehicleService userFollowVehicleService;
	private Logger log = Logger.getLogger(SpringClearRegisterQTZ.class);

	@Scheduled(cron = "0 0/5 * * * ?")
	protected void execute() {
		ConcurrentHashMap<String, ShortMessageInfo> registerMap = RegisterVehicleController.getRegisterCodeMap();
		for (Map.Entry<String, ShortMessageInfo> e : registerMap.entrySet()) {
			Date createDate = e.getValue().getCreateDate();
			Date curDate = new Date();
			long between = (curDate.getTime() - createDate.getTime()) / 1000;
			if (between > 300) {
				log.info("用户: " + e.getValue().getMobilePhone()
						+ "验证码已经失效，目前已经删除该验证码！");
				registerMap.remove(e.getKey());
			}
		}
	}


	/**
	 * 定时处理付费到期的用户
	 * 每分钟查询到期表，修改关注表
	 */
	@Scheduled(cron = "0 0/1 * * * ?")
	protected void countExpTime() {
		userFollowVehicleService.updateExpTime();
	}


}
