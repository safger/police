package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.Scoring;
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


@Service("scoringService")
public class ScoringServiceImpl implements ScoringService{
	
	@Autowired
	private ScoringMapper scoringMapper;

	public ScoringMapper getScoringMapper() {
		return scoringMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.scoringMapper = scoringMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return scoringMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Scoring record) {
		// TODO Auto-generated method stub
		return scoringMapper.insert(record);
	}

	@Override
	public int insertSelective(Scoring record) {
		// TODO Auto-generated method stub
		return scoringMapper.insertSelective(record);
	}

	@Override
	public Scoring findById(String fuid) {
		// TODO Auto-generated method stub
		return scoringMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Scoring record) {
		// TODO Auto-generated method stub
		return scoringMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Scoring record) {
		// TODO Auto-generated method stub
		return scoringMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Scoring record){
		// TODO Auto-generated method stub
		return scoringMapper.deleteByColum(record);
	}
	
	@Override
	public List<Scoring> selectByColum(Scoring record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return scoringMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return scoringMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Scoring>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return scoringMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Scoring> findByPage(Scoring record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(scoringMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Scoring> findByPageCustom(Scoring record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(scoringMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Scoring record) {
		// TODO Auto-generated method stub
		return scoringMapper.countByColum(record);
	}
	@Override
	public List<Scoring> selectAll(String order){
		PageHelper.orderBy(order);
		return scoringMapper.selectAll();
	}

	@Override
	public int countByCustom(Scoring record) {
		// TODO Auto-generated method stub
		return scoringMapper.countByCustom(record);
	}
}
