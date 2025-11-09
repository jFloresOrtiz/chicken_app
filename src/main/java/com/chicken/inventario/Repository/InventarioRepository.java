package com.chicken.inventario.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.chicken.inventario.Model.Inventario;

@Repository
public class InventarioRepository {
    private final DataSource dataSource;

    public InventarioRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Inventario> getAll() {
        List<Inventario> lista = new ArrayList<>();

        String query = "SELECT id, codigo, descripcion FROM mercaderia";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Inventario m = new Inventario();
                m.setId(rs.getInt("id"));
                m.setCodigo(rs.getString("codigo"));
                m.setDescripcion(rs.getString("descripcion"));
                lista.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
