package back.models;

import javax.persistence.*;

@Entity
@Table(name = "m_loan_transaction")
public class MLoanTransaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "loan_id")
    private long loan_id;

    @Column(name = "is_reversed")
    private int is_reversed;

    @Column(name = "transaction_date")
    private String transaction_date;

    @Column(name = "amount")
    private double amount;

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

    public int getIs_reversed() {
        return is_reversed;
    }

    public void setIs_reversed(int is_reversed) {
        this.is_reversed = is_reversed;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MLoanTransaction{" +
                "id=" + id +
                ", loan_id=" + loan_id +
                ", is_reversed=" + is_reversed +
                ", transaction_date='" + transaction_date + '\'' +
                ", amount=" + amount +
                '}';
    }
}
