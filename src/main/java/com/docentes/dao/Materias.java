package com.docentes.dao;

public class Materias {

    private Long id;
    private String name;

    public Materias(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
    public Materias(String name, Integer population) {
        super();
        this.name = name;
    }

	public Materias() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    

}