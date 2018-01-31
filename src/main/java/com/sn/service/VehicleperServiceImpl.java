package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;

 

import java.util.*;
import java.io.IOException;  
 

import com.sn.entity.*;
import com.sn.dao.*;
import com.sn.service.*;  
import com.sn.util.PagedResult;
import com.sn.common.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sn.controller.system.CompetenceManager;
import javax.servlet.http.HttpServletRequest;
import com.sn.controller.system.ComData;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("vehicleperService")
public class VehicleperServiceImpl implements VehicleperService{
	
	@Autowired
	private VehicleperMapper vehicleperMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return vehicleperMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Vehicleper record) {
		// TODO Auto-generated method stub
		return vehicleperMapper.insert(record);
	}

	@Override
	public int insertSelective(Vehicleper record) {
		// TODO Auto-generated method stub
		return vehicleperMapper.insertSelective(record);
	}

	@Override
	public Vehicleper findById(String fuid) {
		// TODO Auto-generated method stub
		return vehicleperMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Vehicleper record) {
		// TODO Auto-generated method stub
		return vehicleperMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Vehicleper record) {
		// TODO Auto-generated method stub
		return vehicleperMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Vehicleper record){
		// TODO Auto-generated method stub
		return vehicleperMapper.deleteByColum(record);
	}
	
	@Override
	public List<Vehicleper> selectByColum(Vehicleper record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return vehicleperMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return vehicleperMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Vehicleper>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return vehicleperMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Vehicleper> findByPage(Vehicleper record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vehicleperMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Vehicleper> findByPageCustom(Vehicleper record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vehicleperMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Vehicleper record) {
		// TODO Auto-generated method stub
		return vehicleperMapper.countByColum(record);
	}
	@Override
	public List<Vehicleper> selectAll(String order){
		PageHelper.orderBy(order);
		return vehicleperMapper.selectAll();
	}
}
