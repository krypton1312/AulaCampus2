/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.service;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author krypton
 */
@Entity
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v"),
    @NamedQuery(name = "Vehiculos.findByCodvehiculo", query = "SELECT v FROM Vehiculos v WHERE v.codvehiculo = :codvehiculo"),
    @NamedQuery(name = "Vehiculos.findByMarca", query = "SELECT v FROM Vehiculos v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculos.findByModelo", query = "SELECT v FROM Vehiculos v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculos.findByTipo", query = "SELECT v FROM Vehiculos v WHERE v.tipo = :tipo"),
    @NamedQuery(name = "Vehiculos.findByColor", query = "SELECT v FROM Vehiculos v WHERE v.color = :color"),
    @NamedQuery(name = "Vehiculos.findByMotor", query = "SELECT v FROM Vehiculos v WHERE v.motor = :motor"),
    @NamedQuery(name = "Vehiculos.findByCilindrada", query = "SELECT v FROM Vehiculos v WHERE v.cilindrada = :cilindrada"),
    @NamedQuery(name = "Vehiculos.findByFecha", query = "SELECT v FROM Vehiculos v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Vehiculos.findByMatricula", query = "SELECT v FROM Vehiculos v WHERE v.matricula = :matricula"),
    @NamedQuery(name = "Vehiculos.findByExtras", query = "SELECT v FROM Vehiculos v WHERE v.extras = :extras"),
    @NamedQuery(name = "Vehiculos.findByPrecio", query = "SELECT v FROM Vehiculos v WHERE v.precio = :precio")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "CODVEHICULO")
    private Integer codvehiculo;
    //@Size(max = 20)
    @Column(name = "MARCA")
    private String marca;
    //@Size(max = 40)
    @Column(name = "MODELO")
    private String modelo;
    //@Size(max = 5)
    @Column(name = "TIPO")
    private String tipo;
    //@Size(max = 15)
    @Column(name = "COLOR")
    private String color;
    //@Size(max = 5)
    @Column(name = "MOTOR")
    private String motor;
    @Column(name = "CILINDRADA")
    private Integer cilindrada;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    //@Size(max = 15)
    @Column(name = "MATRICULA")
    private String matricula;
    //@Size(max = 100)
    @Column(name = "EXTRAS")
    private String extras;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private BigDecimal precio;

    public Vehiculos() {
    }

    public Vehiculos(Integer codvehiculo) {
        this.codvehiculo = codvehiculo;
    }

    public Integer getCodvehiculo() {
        return codvehiculo;
    }

    public void setCodvehiculo(Integer codvehiculo) {
        this.codvehiculo = codvehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codvehiculo != null ? codvehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.codvehiculo == null && other.codvehiculo != null) || (this.codvehiculo != null && !this.codvehiculo.equals(other.codvehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.service.Vehiculos[ codvehiculo=" + codvehiculo + " ]";
    }
    
}
