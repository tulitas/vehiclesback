package back.models;

import javax.persistence.*;

@Entity
@Table(name = "m_loan")
public class MLoan {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "account_no")
    private String account_no;

    @Column(name = "disbursedon_date")
    private String disbursedon_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getDisbursedon_date() {
        return disbursedon_date;
    }

    public void setDisbursedon_date(String disbursedon_date) {
        this.disbursedon_date = disbursedon_date;
    }

    @Override
    public String toString() {
        return "MLoan{" +
                "id=" + id +
                ", account_no='" + account_no + '\'' +
                ", disbursedon_date='" + disbursedon_date + '\'' +
                '}';
    }
}
