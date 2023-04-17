package KontHub.demo.Models;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Repositorio {

    private Integer id;
    private String name;
    private String private_;
    private String description;
    private String updated_at;
    private String svn_url;
    private String language;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public String getSvn_url() {
        return svn_url;
    }

    public void setSvn_url(String svn_url) {
        this.svn_url = svn_url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrivado() {
        return private_;
    }

    public void setPrivado(String private_) {
        this.private_ = private_;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) throws ParseException {
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = formatador.format(updated_at);
        this.updated_at = dataFormatada;
    }
}
