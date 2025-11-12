package com.chicken.inventario.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chicken.inventario.Model.Inventario;
import com.chicken.inventario.Model.Response;
import com.chicken.inventario.Repository.InventarioRepository;

@Service
public class InventarioService {
    private InventarioRepository repository;
    public InventarioService(InventarioRepository repository){
        this.repository = repository;
    }

    public ResponseEntity<Response<Inventario>> GetProductByCode(String code){
        Response<Inventario> response = new Response<>();
        response.data = repository.getProductByCodigo(code);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    public ResponseEntity<Response<List<Inventario>>> allProducts(){
        Response<List<Inventario>> response = new Response<>();
        response.data = repository.getAllProducts();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
