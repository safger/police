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



public interface TrafficMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Traffic record);

	    int insertSelective(Traffic record);

	    Traffic selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Traffic record);

	    int updateByPrimaryKey(Traffic record);
	    
	    List<Traffic> selectByColum(Traffic record);
	    
	    int deleteByColum(Traffic record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Traffic>  selectLikeColum (String columName,String value);
	    
	    List<Traffic>  selectByCustom (Traffic record);
	    
	    int countByColum(Traffic record);
	    
	    List<Traffic> selectAll();
	    
	    List<Traffic>  selectByProblem(Traffic record);
	    
	    List<Traffic>  selectByLate(Traffic record);

}
