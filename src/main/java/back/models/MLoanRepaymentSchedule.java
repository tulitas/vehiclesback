package back.models;

import javax.persistence.*;

@Entity
@Table(name = "m_loan_repayment_schedule")
public class MLoanRepaymentSchedule {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "loan_id")
    private long loan_id;

    @Column(name = "duedate")
    private String duedate;

    @Column(name = "principal_amount")
    private double principal_amount;

    @Column(name = "interest_amount")
    private double interest_amount;

    @Column(name = "fee_charges_amount")
    private double fee_charges_amount;

    @Column(name = "penalty_charges_amount")
    private double penalty_charges_amount;

    @Column(name = "completed_derived")
    private int completed_derived;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(long loan_id) {
        this.loan_id = loan_id;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public double getPrincipal_amount() {
        return principal_amount;
    }

    public void setPrincipal_amount(double principal_amount) {
        this.principal_amount = principal_amount;
    }

    public double getInterest_amount() {
        return interest_amount;
    }

    public void setInterest_amount(double interest_amount) {
        this.interest_amount = interest_amount;
    }

    public double getFee_charges_amount() {
        return fee_charges_amount;
    }

    public void setFee_charges_amount(double fee_charges_amount) {
        this.fee_charges_amount = fee_charges_amount;
    }

    public double getPanalty_charges_amount() {
        return penalty_charges_amount;
    }

    public void setPanalty_charges_amount(double panalty_charges_amount) {
        this.penalty_charges_amount = panalty_charges_amount;
    }

    public int getCompleted_derived() {
        return completed_derived;
    }

    public void setCompleted_derived(int completed_derived) {
        this.completed_derived = completed_derived;
    }

    @Override
    public String toString() {
        return "MLoanRepaymentSchedule{" +
                "id=" + id +
                ", loan_id=" + loan_id +
                ", duedate='" + duedate + '\'' +
                ", principal_amount=" + principal_amount +
                ", interest_amount=" + interest_amount +
                ", fee_charges_amount=" + fee_charges_amount +
                ", panalty_charges_amount=" + penalty_charges_amount +
                ", completed_derived=" + completed_derived +
                '}';
    }
}
