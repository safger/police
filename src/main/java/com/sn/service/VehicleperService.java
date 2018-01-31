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

public interface  VehicleperService{ 
	
	public int deleteById(String id);

	public int insert(Vehicleper record);

	public int insertSelective(Vehicleper record);

	public Vehicleper findById(String fuid);

	public int updateSelective(Vehicleper record);

	public int update(Vehicleper record);
    
	public List<Vehicleper> selectByColum(Vehicleper record,String orderBy);
	
	public  int deleteByColum(Vehicleper record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Vehicleper>  selectLikeColum (String columName,String value);
	
	public PagedResult<Vehicleper> findByPage(Vehicleper record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Vehicleper> findByPageCustom(Vehicleper record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Vehicleper record);
	
	public List<Vehicleper> selectAll(String order);
	
}
