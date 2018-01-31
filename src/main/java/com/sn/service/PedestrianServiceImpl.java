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


@Service("pedestrianService")
public class PedestrianServiceImpl implements PedestrianService{
	
	@Autowired
	private PedestrianMapper pedestrianMapper;

	public PedestrianMapper getPedestrianMapper() {
		return pedestrianMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.pedestrianMapper = pedestrianMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return pedestrianMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Pedestrian record) {
		// TODO Auto-generated method stub
		return pedestrianMapper.insert(record);
	}

	@Override
	public int insertSelective(Pedestrian record) {
		// TODO Auto-generated method stub
		return pedestrianMapper.insertSelective(record);
	}

	@Override
	public Pedestrian findById(String fuid) {
		// TODO Auto-generated method stub
		return pedestrianMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Pedestrian record) {
		// TODO Auto-generated method stub
		return pedestrianMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Pedestrian record) {
		// TODO Auto-generated method stub
		return pedestrianMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Pedestrian record){
		// TODO Auto-generated method stub
		return pedestrianMapper.deleteByColum(record);
	}
	
	@Override
	public List<Pedestrian> selectByColum(Pedestrian record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return pedestrianMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return pedestrianMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Pedestrian>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return pedestrianMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Pedestrian> findByPage(Pedestrian record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(pedestrianMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Pedestrian> findByPageCustom(Pedestrian record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(pedestrianMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Pedestrian record) {
		// TODO Auto-generated method stub
		return pedestrianMapper.countByColum(record);
	}
	@Override
	public List<Pedestrian> selectAll(String order){
		PageHelper.orderBy(order);
		return pedestrianMapper.selectAll();
	}
}
