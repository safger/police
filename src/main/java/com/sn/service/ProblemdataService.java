package com.sn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.entity.Problemdata;
import com.sn.entity.User;
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

public interface  ProblemdataService{ 
	
	public int deleteById(String id);

	public int insert(Problemdata record);

	public int insertSelective(Problemdata record);

	public Problemdata findById(String fuid);

	public int updateSelective(Problemdata record);

	public int update(Problemdata record);
    
	public List<Problemdata> selectByColum(Problemdata record,String orderBy);
	
	public  int deleteByColum(Problemdata record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Problemdata>  selectLikeColum (String columName,String value);
	
	public PagedResult<Problemdata> findByPage(Problemdata record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Problemdata> findByPageCustom(Problemdata record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Problemdata record);
	
	
	public Integer countByJf(Problemdata record);
	
	public List<Problemdata> selectAll(String order);
	
	public  List<Problemdata> selectByGroup(Problemdata record);
	
	public  Integer  countByColumDay (Problemdata record);
	
	public  Integer countByScore(Problemdata record);
}
