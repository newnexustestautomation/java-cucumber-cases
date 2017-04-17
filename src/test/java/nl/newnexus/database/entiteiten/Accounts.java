package nl.newnexus.database.entiteiten;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Tester on 3/28/2017.
 */
@Entity
public class Accounts {
    private String user;
    private String host;
    private long currentConnections;
    private long totalConnections;

    @Basic
    @Column(name = "USER", nullable = true, length = 32)
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "HOST", nullable = true, length = 60)
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Basic
    @Column(name = "CURRENT_CONNECTIONS", nullable = false)
    public long getCurrentConnections() {
        return currentConnections;
    }

    public void setCurrentConnections(long currentConnections) {
        this.currentConnections = currentConnections;
    }

    @Basic
    @Column(name = "TOTAL_CONNECTIONS", nullable = false)
    public long getTotalConnections() {
        return totalConnections;
    }

    public void setTotalConnections(long totalConnections) {
        this.totalConnections = totalConnections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accounts accounts = (Accounts) o;

        if (currentConnections != accounts.currentConnections) return false;
        if (totalConnections != accounts.totalConnections) return false;
        if (user != null ? !user.equals(accounts.user) : accounts.user != null) return false;
        if (host != null ? !host.equals(accounts.host) : accounts.host != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (int) (currentConnections ^ (currentConnections >>> 32));
        result = 31 * result + (int) (totalConnections ^ (totalConnections >>> 32));
        return result;
    }
}
