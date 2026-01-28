/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author MarioGarcíaAtienza
 */
@Entity
@Table(name = "peliculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peliculas.findAll", query = "SELECT p FROM Peliculas p"),
    @NamedQuery(name = "Peliculas.findByCodpelicula", query = "SELECT p FROM Peliculas p WHERE p.codpelicula = :codpelicula"),
    @NamedQuery(name = "Peliculas.findByTitulo", query = "SELECT p FROM Peliculas p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Peliculas.findByTema", query = "SELECT p FROM Peliculas p WHERE p.tema = :tema"),
    @NamedQuery(name = "Peliculas.findByDuracion", query = "SELECT p FROM Peliculas p WHERE p.duracion = :duracion"),
    @NamedQuery(name = "Peliculas.findByPrecio", query = "SELECT p FROM Peliculas p WHERE p.precio = :precio")})
public class Peliculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "codpelicula")
    private Integer codpelicula;
    //@Size(max = 50)
    @Column(name = "titulo")
    private String titulo;
    //@Size(max = 20)
    @Column(name = "tema")
    private String tema;
    @Column(name = "duracion")
    private Integer duracion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;

    public Peliculas() {
    }

    public Peliculas(Integer codpelicula) {
        this.codpelicula = codpelicula;
    }

    public Integer getCodpelicula() {
        return codpelicula;
    }

    public void setCodpelicula(Integer codpelicula) {
        this.codpelicula = codpelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
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
        hash += (codpelicula != null ? codpelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peliculas)) {
            return false;
        }
        Peliculas other = (Peliculas) object;
        if ((this.codpelicula == null && other.codpelicula != null) || (this.codpelicula != null && !this.codpelicula.equals(other.codpelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Peliculas[ codpelicula=" + codpelicula + " ]";
    }
    
}
