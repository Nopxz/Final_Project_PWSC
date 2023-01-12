/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.uaspwsfinalproject;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "b2020ws")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "B2020ws.findAll", query = "SELECT b FROM B2020ws b"),
    @NamedQuery(name = "B2020ws.findById", query = "SELECT b FROM B2020ws b WHERE b.id = :id"),
    @NamedQuery(name = "B2020ws.findByName", query = "SELECT b FROM B2020ws b WHERE b.name = :name"),
    @NamedQuery(name = "B2020ws.findByNik", query = "SELECT b FROM B2020ws b WHERE b.nik = :nik"),
    @NamedQuery(name = "B2020ws.findByAddress", query = "SELECT b FROM B2020ws b WHERE b.address = :address")})
public class B2020ws implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "nik")
    private String nik;
    @Column(name = "address")
    private String address;
    @Lob
    @Column(name = "photo")
    private byte[] photo;

    public B2020ws() {
    }

    public B2020ws(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof B2020ws)) {
            return false;
        }
        B2020ws other = (B2020ws) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finalproject.uaspwsfinalproject.B2020ws[ id=" + id + " ]";
    }
    
}
