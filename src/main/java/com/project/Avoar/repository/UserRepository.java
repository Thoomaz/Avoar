package com.project.Avoar.repository;

import com.project.Avoar.entity.User;
import com.project.Avoar.entity.enumns.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT SUM(t.ticketValue) " +
            "FROM Ticket t " +
            "WHERE t.user.id = :userId " +
            "AND t.payment.status = :status")
    Double findTotalPendingTicketsByUserId(@Param("userId") Long userId, @Param("status") PaymentStatus status);
}
