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


@Service("riskService")
public class RiskServiceImpl implements RiskService{
	
	@Autowired
	private RiskMapper riskMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return riskMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Risk record) {
		// TODO Auto-generated method stub
		return riskMapper.insert(record);
	}

	@Override
	public int insertSelective(Risk record) {
		// TODO Auto-generated method stub
		return riskMapper.insertSelective(record);
	}

	@Override
	public Risk findById(String fuid) {
		// TODO Auto-generated method stub
		return riskMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Risk record) {
		// TODO Auto-generated method stub
		return riskMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Risk record) {
		// TODO Auto-generated method stub
		return riskMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Risk record){
		// TODO Auto-generated method stub
		return riskMapper.deleteByColum(record);
	}
	
	@Override
	public List<Risk> selectByColum(Risk record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return riskMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return riskMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Risk>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return riskMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Risk> findByPage(Risk record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(riskMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Risk> findByPageCustom(Risk record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(riskMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Risk record) {
		// TODO Auto-generated method stub
		return riskMapper.countByColum(record);
	}
	@Override
	public List<Risk> selectAll(String order){
		PageHelper.orderBy(order);
		return riskMapper.selectAll();
	}
}
