package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
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


@Service("fvisitsService")
public class FvisitsServiceImpl implements FvisitsService{
	
	@Autowired
	private FvisitsMapper fvisitsMapper;

	public FvisitsMapper getFvisitsMapper() {
		return fvisitsMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.fvisitsMapper = fvisitsMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return fvisitsMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Fvisits record) {
		// TODO Auto-generated method stub
		return fvisitsMapper.insert(record);
	}

	@Override
	public int insertSelective(Fvisits record) {
		// TODO Auto-generated method stub
		return fvisitsMapper.insertSelective(record);
	}

	@Override
	public Fvisits findById(String fuid) {
		// TODO Auto-generated method stub
		return fvisitsMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Fvisits record) {
		// TODO Auto-generated method stub
		return fvisitsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Fvisits record) {
		// TODO Auto-generated method stub
		return fvisitsMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Fvisits record){
		// TODO Auto-generated method stub
		return fvisitsMapper.deleteByColum(record);
	}
	
	@Override
	public List<Fvisits> selectByColum(Fvisits record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return fvisitsMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return fvisitsMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Fvisits>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return fvisitsMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Fvisits> findByPage(Fvisits record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(fvisitsMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Fvisits> findByPageCustom(Fvisits record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(fvisitsMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Fvisits record) {
		// TODO Auto-generated method stub
		return fvisitsMapper.countByColum(record);
	}
	@Override
	public List<Fvisits> selectAll(String order){
		PageHelper.orderBy(order);
		return fvisitsMapper.selectAll();
	}
}
