package com.github.yumyum.map.repository;


import com.github.yumyum.map.repository.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity, Integer>
{
}
