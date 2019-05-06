package com.crm.springbootstarter.tenant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Integer>{
    @Override
	List<Tenant> findAll();
}
