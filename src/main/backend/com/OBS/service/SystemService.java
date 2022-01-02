package com.OBS.service;

import com.OBS.auth.entity.AppUser;
import com.OBS.entity.Client;
import com.OBS.entity.CreditCard;
import com.OBS.entity.Employee;
import com.OBS.entity.Loan;
import com.OBS.requestBodies.LoanBody;
import com.OBS.requestBodies.UserCredentials;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SystemService {
    private final AppUserService appUserService;
    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final CreditCardService creditCardService;
    private final LoanService loanService;

    public void createNewUser(UserCredentials userCredentials){
        appUserService.createAppUser(userCredentials);
    }

    public void updateAppUser(AppUser appUser){
        appUserService.updateAppUser(appUser);
    }

    public void updateClient(Client client){
        clientService.updateClient(client);
    }

    public void updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
    }

    public void blockCreditCard(CreditCard creditCard) {
        creditCardService.switchActiveStateOfCreditCard(creditCard.getCardId());
    }

    public void discardCreditCard(CreditCard creditCard) {
        creditCardService.deleteCreditCard(creditCard.getCardId());
    }

    public void createCreditCard(CreditCard creditCard) {
        creditCardService.addCreditCard(creditCard.getClient().getClientId(),creditCard);
    }

    public void unblockCreditCard(CreditCard creditCard) {
        creditCardService.switchActiveStateOfCreditCard(creditCard.getCardId());
    }

    public void createLoan(Loan loan) {
        loanService.addLoan(loan);
    }
}