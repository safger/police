package com.sn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.entity.Traffic;
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

public interface  TrafficService{ 
	
	public int deleteById(String id);

	public int insert(Traffic record);

	public int insertSelective(Traffic record);

	public Traffic findById(String fuid);

	public int updateSelective(Traffic record);

	public int update(Traffic record);
    
	public List<Traffic> selectByColum(Traffic record,String orderBy);
	
	public  int deleteByColum(Traffic record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Traffic>  selectLikeColum (String columName,String value);
	
	public PagedResult<Traffic> findByPage(Traffic record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Traffic> findByPageCustom(Traffic record, Integer indexPage,Integer pageSize,String orderBy);
	
	public PagedResult<Traffic> findByPageLate(Traffic record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Traffic record);
	
	public List<Traffic> selectAll(String order);
	
	public PagedResult<Traffic>  selectByProblem(Traffic record,Integer indexPage,Integer pageSize,String orderBy );
}
