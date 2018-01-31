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



public interface DeductionrulesMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Deductionrules record);

	    int insertSelective(Deductionrules record);

	    Deductionrules selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Deductionrules record);

	    int updateByPrimaryKey(Deductionrules record);
	    
	    List<Deductionrules> selectByColum(Deductionrules record);
	    
	    int deleteByColum(Deductionrules record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Deductionrules>  selectLikeColum (String columName,String value);
	    
	    List<Deductionrules>  selectByCustom (Deductionrules record);
	    
	    int countByColum(Deductionrules record);
	    
	    List<Deductionrules> selectAll();

}
