package com.sn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.entity.Policeofficer;
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

public interface  PoliceofficerService{ 
	
	public int deleteById(String id);

	public int insert(Policeofficer record);

	public int insertSelective(Policeofficer record);

	public Policeofficer findById(String fuid);

	public int updateSelective(Policeofficer record);

	public int update(Policeofficer record);
    
	public List<Policeofficer> selectByColum(Policeofficer record,String orderBy);
	
	public  int deleteByColum(Policeofficer record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Policeofficer>  selectLikeColum (Policeofficer record);
	
	public PagedResult<Policeofficer> findByPage(Policeofficer record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Policeofficer> findByPageCustom(Policeofficer record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Policeofficer record);
	
	public List<Policeofficer> selectAll(String order);
	
}
