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

    public Inventario getProductByCodigo(String codigo) {
      Inventario m = null; 

      String query = "SELECT id, codigo, descripcion, unidad FROM mercaderia WHERE codigo = ?";

      try (Connection conn = dataSource.getConnection();
          PreparedStatement stmt = conn.prepareStatement(query)) {

          stmt.setString(1, codigo); // asignamos el parámetro del WHERE
          try (ResultSet rs = stmt.executeQuery()) {
              if (rs.next()) { // solo esperamos un resultado
                  m = new Inventario();
                  m.setId(rs.getInt("id"));
                  m.setCodigo(rs.getString("codigo"));
                  m.setDescripcion(rs.getString("descripcion"));
                  m.setUnidad(rs.getString("unidad"));
              }
          }

      } catch (SQLException e) {
          e.printStackTrace();
      }

      return m; // devuelve el objeto encontrado o null si no hay coincidencia
    }

    public List<Inventario> getAllProducts() {
    List<Inventario> productos = new ArrayList<>();

    String query = "SELECT id, codigo, descripcion, unidad FROM mercaderia";

    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Inventario m = new Inventario();
            m.setId(rs.getInt("id"));
            m.setCodigo(rs.getString("codigo"));
            m.setDescripcion(rs.getString("descripcion"));
            m.setUnidad(rs.getString("unidad"));
            productos.add(m);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return productos;
}


}
