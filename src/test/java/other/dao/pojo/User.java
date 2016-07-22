package other.dao.pojo;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Created by yanan on 16/7/20.
 */
public class User implements Serializable {
    private long id;
    private String address;
    private long mobile;
    private String postCode;

    public User() {
    }

    public User(long id, String address) {
        this.id = id;
        this.address = address;
    }

    public User(long id, String address, long mobile, String postCode) {
        this.id = id;
        this.address = address;
        this.mobile = mobile;
        this.postCode = postCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("address", address)
                .toString();
    }
}
