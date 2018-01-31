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

public interface  ScoringService{ 
	
	public int deleteById(String id);

	public int insert(Scoring record);

	public int insertSelective(Scoring record);

	public Scoring findById(String fuid);

	public int updateSelective(Scoring record);

	public int update(Scoring record);
    
	public List<Scoring> selectByColum(Scoring record,String orderBy);
	
	public  int deleteByColum(Scoring record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Scoring>  selectLikeColum (String columName,String value);
	
	public PagedResult<Scoring> findByPage(Scoring record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Scoring> findByPageCustom(Scoring record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Scoring record);
	
	public List<Scoring> selectAll(String order);
	
	public int countByCustom(Scoring record);
	
}
