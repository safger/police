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



public interface InspectorMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Inspector record);

	    int insertSelective(Inspector record);

	    Inspector selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Inspector record);

	    int updateByPrimaryKey(Inspector record);
	    
	    List<Inspector> selectByColum(Inspector record);
	    
	    int deleteByColum(Inspector record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Inspector>  selectLikeColum (String columName,String value);
	    
	    List<Inspector>  selectByCustom (Inspector record);
	    
	    int countByColum(Inspector record);
	    
	    List<Inspector> selectAll();
	    
	    int countByCustom(Inspector record);
	    
	    List<Inspector>  selectByGroup (Inspector record); 
	    List<Inspector>  selectByTypeGroup(Inspector record); 

}
