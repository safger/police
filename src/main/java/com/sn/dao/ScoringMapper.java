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



public interface ScoringMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Scoring record);

	    int insertSelective(Scoring record);

	    Scoring selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Scoring record);

	    int updateByPrimaryKey(Scoring record);
	    
	    List<Scoring> selectByColum(Scoring record);
	    
	    int deleteByColum(Scoring record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Scoring>  selectLikeColum (String columName,String value);
	    
	    List<Scoring>  selectByCustom (Scoring record);
	    
	    int countByColum(Scoring record);
	    
	    List<Scoring> selectAll();
	    
	    int countByCustom(Scoring record);

}
