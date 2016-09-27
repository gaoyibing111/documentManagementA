package com.fh.service;

import com.fh.dao.DaoSupport;
import com.fh.entity.RemoteResp.PayVehicleResp;
import com.fh.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户维修计划
 */
@Service("userMaintainPlanVehicleService")
public class UserMaintainPlanVehicleService {
    @Resource(name = "daoSupport")
    private DaoSupport dao;


    /**
     * 查询该车辆的维修计划列表
     */


    public List<PageData> findMaintainPlan(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("UserMaintainPlanVehicleMapper.findMaintainPlan", pd);
    }
    /**
     * 新增该车辆计划
     */
    public void saveMaintainPlan(PageData pd)throws Exception{
        dao.save("UserMaintainPlanVehicleMapper.saveMaintainPlan", pd);
    }

    /**
     * 批量删除该车辆计划
     */

    public void deleteAllMaintainPlan(String[] ids)throws Exception{
        dao.delete("UserMaintainPlanVehicleMapper.deleteAllMaintainPlan", ids);
    }

    public void deleteMaintainPlan(PageData pd)throws Exception{
        dao.delete("UserMaintainPlanVehicleMapper.deleteMaintainPlan", pd);
    }


    /**
     * 日常维护记录查询
     */
    public List<PageData> queryRoutineMaintenanceRecords(PageData pd)throws Exception{
      return (List<PageData>)dao.findForList("UserMaintainPlanVehicleMapper.queryRoutineMaintenanceRecords", pd);
    }
    /**
     * 日常维护记录新增
     */
    public void saveRoutineMaintenanceRecord(PageData pd)throws Exception{
        dao.save("UserMaintainPlanVehicleMapper.saveRoutineMaintenanceRecord", pd);
    }


    /**
     * 日常维护记录修改
     */
    public void editRoutineMaintenanceRecord(PageData pd)throws Exception{
        dao.update("UserMaintainPlanVehicleMapper.editRoutineMaintenanceRecord", pd);
    }




}
