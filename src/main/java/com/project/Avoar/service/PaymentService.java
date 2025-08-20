package com.project.Avoar.service;

import com.project.Avoar.entity.Payment;
import com.project.Avoar.entity.enumns.PaymentStatus;
import com.project.Avoar.exception.InvalidValueException;
import com.project.Avoar.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;

    @Autowired
    private UserService service;

    public Payment save(Payment payment){
        return repository.save(payment);
    }

    public Payment makePayment(Payment payment, Long id){
        Double valuePending = service.pendingValueByUser(id);

        if (payment.getValuePayment() == null || valuePending == null) {
            throw new InvalidValueException("Pagamento não autorizado. Valor não encontrado!");
        }

        if (Double.compare(payment.getValuePayment(), valuePending) == 0) {
            payment.setDate(LocalDate.now());
            payment.setStatus(PaymentStatus.CONFIRMED);
            return repository.save(payment);
        }

        throw new InvalidValueException("Pagamento não autorizado. Valor incorreto!");
    }
}
