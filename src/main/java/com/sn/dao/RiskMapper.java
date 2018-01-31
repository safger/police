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



public interface RiskMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Risk record);

	    int insertSelective(Risk record);

	    Risk selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Risk record);

	    int updateByPrimaryKey(Risk record);
	    
	    List<Risk> selectByColum(Risk record);
	    
	    int deleteByColum(Risk record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Risk>  selectLikeColum (String columName,String value);
	    
	    List<Risk>  selectByCustom (Risk record);
	    
	    int countByColum(Risk record);
	    
	    List<Risk> selectAll();

}
