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

public interface  DeductionrulesService{ 
	
	public int deleteById(String id);

	public int insert(Deductionrules record);

	public int insertSelective(Deductionrules record);

	public Deductionrules findById(String fuid);

	public int updateSelective(Deductionrules record);

	public int update(Deductionrules record);
    
	public List<Deductionrules> selectByColum(Deductionrules record,String orderBy);
	
	public  int deleteByColum(Deductionrules record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Deductionrules>  selectLikeColum (String columName,String value);
	
	public PagedResult<Deductionrules> findByPage(Deductionrules record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Deductionrules> findByPageCustom(Deductionrules record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Deductionrules record);
	
	public List<Deductionrules> selectAll(String order);
	
}
