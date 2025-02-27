package com.curso.domains.enums;

public enum Status {

    INTERNADO(0,"INTERNADO"),
    ALTA(1,"ALTA");
    
    private Integer id;
    
    private String situacao;

    Status(int id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public static Status toEnum(Integer id) {
        if(id == null) return null;
        for(Status x : Status.values()) {
            if(id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status invalido");
    }


}
    



