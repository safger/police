package com.sn.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

public interface  RiskService{ 
	
	public int deleteById(String id);

	public int insert(Risk record);

	public int insertSelective(Risk record);

	public Risk findById(String fuid);

	public int updateSelective(Risk record);

	public int update(Risk record);
    
	public List<Risk> selectByColum(Risk record,String orderBy);
	
	public  int deleteByColum(Risk record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Risk>  selectLikeColum (String columName,String value);
	
	public PagedResult<Risk> findByPage(Risk record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Risk> findByPageCustom(Risk record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Risk record);
	
	public List<Risk> selectAll(String order);
	
}
