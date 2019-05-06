package com.crm.springbootstarter.tenant;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tenant")
public class TenantController {

	@Autowired
	private TenantRepository tenantRepository;
	
	@PostMapping("/register")
	public Tenant addTenant(@RequestBody TenantDto tenantDto){
		Calendar c=Calendar.getInstance();
       	Tenant tenant=new Tenant(tenantDto.getName(),tenantDto.getContactNo(),tenantDto.getEmail(),tenantDto.getAddress(),tenantDto.getCity(),tenantDto.getState(),tenantDto.getCountry());
		Date now=new Date();
		tenant.setCreatedDate(now);
		tenant.setStatus("PENDING");
       	Tenant savedTenant=this.tenantRepository.save(tenant);
		return savedTenant;
	}
	
	@GetMapping("/all")
	public List<Tenant> getAllTenants(){
		List<Tenant> tenants=this.tenantRepository.findAll();
		return tenants;
	}
	
	
}
