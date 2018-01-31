package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.Problemdata;
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


@Service("problemdataService")
public class ProblemdataServiceImpl implements ProblemdataService{
	
	@Autowired
	private ProblemdataMapper problemdataMapper;

	public ProblemdataMapper getProblemdataMapper() {
		return problemdataMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.problemdataMapper = problemdataMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return problemdataMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Problemdata record) {
		// TODO Auto-generated method stub
		return problemdataMapper.insert(record);
	}

	@Override
	public int insertSelective(Problemdata record) {
		// TODO Auto-generated method stub
		return problemdataMapper.insertSelective(record);
	}

	@Override
	public Problemdata findById(String fuid) {
		// TODO Auto-generated method stub
		return problemdataMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Problemdata record) {
		// TODO Auto-generated method stub
		return problemdataMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Problemdata record) {
		// TODO Auto-generated method stub
		return problemdataMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Problemdata record){
		// TODO Auto-generated method stub
		return problemdataMapper.deleteByColum(record);
	}
	
	@Override
	public List<Problemdata> selectByColum(Problemdata record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return problemdataMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return problemdataMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Problemdata>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return problemdataMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Problemdata> findByPage(Problemdata record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(problemdataMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Problemdata> findByPageCustom(Problemdata record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(problemdataMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Problemdata record) {
		// TODO Auto-generated method stub
		return problemdataMapper.countByColum(record);
	}
	@Override
	public List<Problemdata> selectAll(String order){
		PageHelper.orderBy(order);
		return problemdataMapper.selectAll();
	}

	@Override
	public List<Problemdata> selectByGroup(Problemdata record) {
		// TODO Auto-generated method stub
		return problemdataMapper.selectByGroup(record);
	}

	@Override
	public Integer countByColumDay(Problemdata record) {
		// TODO Auto-generated method stub
		return problemdataMapper.countByColumDay(record);
	}

	@Override
	public Integer countByScore(Problemdata record) {
		// TODO Auto-generated method stub
		return problemdataMapper.countByScore(record);
	}
 
	@Override
	public Integer countByJf(Problemdata record) {
		// TODO Auto-generated method stub
		return problemdataMapper.countByJf(record);
	}
}
