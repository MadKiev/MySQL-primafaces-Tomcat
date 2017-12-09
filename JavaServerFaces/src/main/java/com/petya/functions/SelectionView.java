package com.petya.functions;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.petya.functions.model.FunParam;
import com.petya.functions.model.Function;
import com.petya.functions.model.GroupFunction;


@ManagedBean(name = "dtSelectionView")
@ViewScoped
public class SelectionView implements Serializable {
	
	
	private List<Function> functions;
	private List<FunParam> functionParams;
	private List<GroupFunction> funGroups;
	
	
	

    @ManagedProperty("#{functionsService}")
    private FunctionsService service;

    public void setService(FunctionsService service) {
        this.service = service;
    }
    

    


    
    public List<GroupFunction> getFunGroups() throws SQLException {
         return service.getFuncGroups();
    }

    public List<Function> getFunctions() throws SQLException {
		return service.getFunctions(1);
    }

    public List<FunParam> getFunctionParams() throws SQLException {
        return service.getFunctionParams(1);
    }

}