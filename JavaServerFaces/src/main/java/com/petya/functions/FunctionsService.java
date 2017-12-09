package com.petya.functions;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.petya.functions.model.FunParam;
import com.petya.functions.model.Function;
import com.petya.functions.model.GroupFunction;

@ManagedBean(name = "functionsService")
@SessionScoped
public class FunctionsService implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3356388138747263086L;
	private static final String MYSQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/aval";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String SQL_SELECT_FROM_FUNCTIONS = "SELECT * FROM functions WHERE id = ?";
    private static final String SQL_SELECT_FROM_GROUPS = "SELECT * FROM group_function";
    private static final String SQL_SELECT_FROM_FUNC_PARAMS = "SELECT * FROM fun_param WHERE id = ?";
    private Connection conn;

    public FunctionsService() {
        try {
            Class.forName(MYSQL_DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<GroupFunction> getFuncGroups() throws SQLException {
        PreparedStatement ps = conn.prepareStatement(SQL_SELECT_FROM_GROUPS);

        ResultSet result = ps.executeQuery();
        List<GroupFunction> list = new ArrayList<>();
        while (result.next()) {
            GroupFunction gFunc = new GroupFunction();

            gFunc.setId(result.getLong("id"));
            gFunc.setName(result.getString("name"));
            gFunc.setDescr(result.getString("descr"));
            gFunc.setcTime(result.getDate("ctime"));

            list.add(gFunc);
        }
        return list;
    }

    public List<Function> getFunctions(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(SQL_SELECT_FROM_FUNCTIONS);
        ps.setLong(1, id);

        ResultSet result = ps.executeQuery();
        List<Function> list = new ArrayList<>();
        while (result.next()) {
            Function func = new Function();

            func.setId(result.getLong("id"));
            func.setIdGroup(result.getLong("id_group"));
            func.setName(result.getString("name"));
            func.setDescr(result.getString("descr"));
            func.setcTime(result.getDate("ctime"));

            list.add(func);
        }
        return list;
    }

    public List<FunParam> getFunctionParams(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(SQL_SELECT_FROM_FUNC_PARAMS);
        ps.setLong(1, id);

        ResultSet result = ps.executeQuery();
        List<FunParam> list = new ArrayList<>();
        while (result.next()) {
            FunParam fParam = new FunParam();

            fParam.setId(result.getLong("id"));
            fParam.setIdFun(result.getLong("id_fun"));
            fParam.setName(result.getString("name"));
            fParam.setDescr(result.getString("descr"));
            fParam.setcTime(result.getDate("ctime"));

            list.add(fParam);
        }
        return list;
    }
    
    
    
    
    
    
    }



