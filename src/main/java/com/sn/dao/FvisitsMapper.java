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



public interface FvisitsMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Fvisits record);

	    int insertSelective(Fvisits record);

	    Fvisits selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Fvisits record);

	    int updateByPrimaryKey(Fvisits record);
	    
	    List<Fvisits> selectByColum(Fvisits record);
	    
	    int deleteByColum(Fvisits record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Fvisits>  selectLikeColum (String columName,String value);
	    
	    List<Fvisits>  selectByCustom (Fvisits record);
	    
	    int countByColum(Fvisits record);
	    
	    List<Fvisits> selectAll();

}
