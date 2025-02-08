package org.dev.posapi.infrastructure.adapter.repository.interfaces;

import org.dev.posapi.domain.model.SaleItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ISaleItemRepository extends JpaRepository<SaleItemEntity, Long> {
    @Query(value = "SELECT p.name, SUM(dv.quantity) AS total_vendidos FROM sale_item dv JOIN products p ON dv.id_product = p.id JOIN sales v ON dv.id_sale = v.id WHERE v.created_at BETWEEN :startDate AND :endDate GROUP BY p.name", nativeQuery = true)
    List<Object[]> findSalesByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT p.name, SUM(dv.quantity) AS total_vendidos FROM sale_item dv JOIN products p ON dv.id_product = p.id GROUP BY p.name ORDER BY total_vendidos DESC", nativeQuery = true)
    List<Object[]> findBestSellingProducts();
}
