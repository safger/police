package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.Traffic;
import com.sn.entity.User;
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


@Service("trafficService")
public class TrafficServiceImpl implements TrafficService{
	
	@Autowired
	private TrafficMapper trafficMapper;

	public TrafficMapper getTrafficMapper() {
		return trafficMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.trafficMapper = trafficMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return trafficMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Traffic record) {
		// TODO Auto-generated method stub
		return trafficMapper.insert(record);
	}

	@Override
	public int insertSelective(Traffic record) {
		// TODO Auto-generated method stub
		return trafficMapper.insertSelective(record);
	}

	@Override
	public Traffic findById(String fuid) {
		// TODO Auto-generated method stub
		return trafficMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Traffic record) {
		// TODO Auto-generated method stub
		return trafficMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Traffic record) {
		// TODO Auto-generated method stub
		return trafficMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Traffic record){
		// TODO Auto-generated method stub
		return trafficMapper.deleteByColum(record);
	}
	
	@Override
	public List<Traffic> selectByColum(Traffic record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return trafficMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return trafficMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Traffic>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return trafficMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Traffic> findByPage(Traffic record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(trafficMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Traffic> findByPageCustom(Traffic record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(trafficMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Traffic record) {
		// TODO Auto-generated method stub
		return trafficMapper.countByColum(record);
	}
	@Override
	public List<Traffic> selectAll(String order){
		PageHelper.orderBy(order);
		return trafficMapper.selectAll();
	}

	@Override
	public PagedResult<Traffic> selectByProblem(Traffic record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(trafficMapper.selectByProblem(record));
	}

	@Override
	public PagedResult<Traffic> findByPageLate(Traffic record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(trafficMapper.selectByLate(record));
	}
}
