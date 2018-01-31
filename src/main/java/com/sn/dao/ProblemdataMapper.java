package com.sn.dao;

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



import java.util.List; 



public interface ProblemdataMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Problemdata record);

	    int insertSelective(Problemdata record);

	    Problemdata selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Problemdata record);

	    int updateByPrimaryKey(Problemdata record);
	    
	    List<Problemdata> selectByColum(Problemdata record);
	    
	    int deleteByColum(Problemdata record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Problemdata>  selectLikeColum (String columName,String value);
	    
	    List<Problemdata>  selectByCustom (Problemdata record);
	    
	    int countByColum(Problemdata record);
	    
	    List<Problemdata> selectAll();
	    
	    List<Problemdata> selectByGroup(Problemdata record);
	    Integer  countByColumDay (Problemdata record);
	    
	    Integer countByScore(Problemdata record);
	    
	    Integer countByJf(Problemdata record);
}
