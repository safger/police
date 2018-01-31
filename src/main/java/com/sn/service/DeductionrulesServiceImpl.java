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


@Service("deductionrulesService")
public class DeductionrulesServiceImpl implements DeductionrulesService{
	
	@Autowired
	private DeductionrulesMapper deductionrulesMapper;

	public DeductionrulesMapper getDeductionrulesMapper() {
		return deductionrulesMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.deductionrulesMapper = deductionrulesMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return deductionrulesMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Deductionrules record) {
		// TODO Auto-generated method stub
		return deductionrulesMapper.insert(record);
	}

	@Override
	public int insertSelective(Deductionrules record) {
		// TODO Auto-generated method stub
		return deductionrulesMapper.insertSelective(record);
	}

	@Override
	public Deductionrules findById(String fuid) {
		// TODO Auto-generated method stub
		return deductionrulesMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Deductionrules record) {
		// TODO Auto-generated method stub
		return deductionrulesMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Deductionrules record) {
		// TODO Auto-generated method stub
		return deductionrulesMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Deductionrules record){
		// TODO Auto-generated method stub
		return deductionrulesMapper.deleteByColum(record);
	}
	
	@Override
	public List<Deductionrules> selectByColum(Deductionrules record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return deductionrulesMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return deductionrulesMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Deductionrules>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return deductionrulesMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Deductionrules> findByPage(Deductionrules record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(deductionrulesMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Deductionrules> findByPageCustom(Deductionrules record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(deductionrulesMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Deductionrules record) {
		// TODO Auto-generated method stub
		return deductionrulesMapper.countByColum(record);
	}
	@Override
	public List<Deductionrules> selectAll(String order){
		PageHelper.orderBy(order);
		return deductionrulesMapper.selectAll();
	}
}
