package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.Inspector;
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


@Service("inspectorService")
public class InspectorServiceImpl implements InspectorService{
	
	@Autowired
	private InspectorMapper inspectorMapper;

	public InspectorMapper getInspectorMapper() {
		return inspectorMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.inspectorMapper = inspectorMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return inspectorMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Inspector record) {
		// TODO Auto-generated method stub
		return inspectorMapper.insert(record);
	}

	@Override
	public int insertSelective(Inspector record) {
		// TODO Auto-generated method stub
		return inspectorMapper.insertSelective(record);
	}

	@Override
	public Inspector findById(String fuid) {
		// TODO Auto-generated method stub
		return inspectorMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Inspector record) {
		// TODO Auto-generated method stub
		return inspectorMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Inspector record) {
		// TODO Auto-generated method stub
		return inspectorMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Inspector record){
		// TODO Auto-generated method stub
		return inspectorMapper.deleteByColum(record);
	}
	
	@Override
	public List<Inspector> selectByColum(Inspector record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return inspectorMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return inspectorMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Inspector>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return inspectorMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Inspector> findByPage(Inspector record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(inspectorMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Inspector> findByPageCustom(Inspector record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(inspectorMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Inspector record) {
		// TODO Auto-generated method stub
		return inspectorMapper.countByColum(record);
	}
	@Override
	public List<Inspector> selectAll(String order){
		PageHelper.orderBy(order);
		return inspectorMapper.selectAll();
	}

	@Override
	public int countByCustom(Inspector record) {
		// TODO Auto-generated method stub
		return inspectorMapper.countByCustom(record);
	}

	@Override
	public List<Inspector> selectByGroup(Inspector record) {
		// TODO Auto-generated method stub
		return inspectorMapper.selectByGroup(record);
	}

	@Override
	public List<Inspector> selectByTypeGroup(Inspector record) {
		// TODO Auto-generated method stub
		return inspectorMapper.selectByTypeGroup(record);
	}
}
