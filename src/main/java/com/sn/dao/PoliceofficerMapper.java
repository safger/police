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



public interface PoliceofficerMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Policeofficer record);

	    int insertSelective(Policeofficer record);

	    Policeofficer selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Policeofficer record);

	    int updateByPrimaryKey(Policeofficer record);
	    
	    List<Policeofficer> selectByColum(Policeofficer record);
	    
	    int deleteByColum(Policeofficer record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Policeofficer>  selectLikeColum (Policeofficer record);
	    
	    List<Policeofficer>  selectByCustom (Policeofficer record);
	    
	    int countByColum(Policeofficer record);
	    
	    List<Policeofficer> selectAll();

}
