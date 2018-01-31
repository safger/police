package com.sn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.entity.Inspector;
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

public interface  InspectorService{ 
	
	public int deleteById(String id);

	public int insert(Inspector record);

	public int insertSelective(Inspector record);

	public Inspector findById(String fuid);

	public int updateSelective(Inspector record);

	public int update(Inspector record);
    
	public List<Inspector> selectByColum(Inspector record,String orderBy);
	
	public  int deleteByColum(Inspector record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Inspector>  selectLikeColum (String columName,String value);
	
	public PagedResult<Inspector> findByPage(Inspector record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Inspector> findByPageCustom(Inspector record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Inspector record);
	
	public List<Inspector> selectAll(String order);
	
	public int countByCustom(Inspector record);
	
	public List<Inspector>  selectByGroup (Inspector record); 
	
	public List<Inspector> selectByTypeGroup(Inspector record); 
	
}
