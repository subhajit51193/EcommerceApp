package com.ecommerce.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.spring.demo.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{

}
