package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.Policeofficer;
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


@Service("policeofficerService")
public class PoliceofficerServiceImpl implements PoliceofficerService{
	
	@Autowired
	private PoliceofficerMapper policeofficerMapper;

	public PoliceofficerMapper getPoliceofficerMapper() {
		return policeofficerMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.policeofficerMapper = policeofficerMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return policeofficerMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Policeofficer record) {
		// TODO Auto-generated method stub
		return policeofficerMapper.insert(record);
	}

	@Override
	public int insertSelective(Policeofficer record) {
		// TODO Auto-generated method stub
		return policeofficerMapper.insertSelective(record);
	}

	@Override
	public Policeofficer findById(String fuid) {
		// TODO Auto-generated method stub
		return policeofficerMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Policeofficer record) {
		// TODO Auto-generated method stub
		return policeofficerMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Policeofficer record) {
		// TODO Auto-generated method stub
		return policeofficerMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Policeofficer record){
		// TODO Auto-generated method stub
		return policeofficerMapper.deleteByColum(record);
	}
	
	@Override
	public List<Policeofficer> selectByColum(Policeofficer record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return policeofficerMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return policeofficerMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Policeofficer>  selectLikeColum (Policeofficer record){
		// TODO Auto-generated method stub
		return policeofficerMapper.selectLikeColum(record);
	}
	
	@Override
	public PagedResult<Policeofficer> findByPage(Policeofficer record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(policeofficerMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Policeofficer> findByPageCustom(Policeofficer record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(policeofficerMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Policeofficer record) {
		// TODO Auto-generated method stub
		return policeofficerMapper.countByColum(record);
	}
	@Override
	public List<Policeofficer> selectAll(String order){
		PageHelper.orderBy(order);
		return policeofficerMapper.selectAll();
	}
}
