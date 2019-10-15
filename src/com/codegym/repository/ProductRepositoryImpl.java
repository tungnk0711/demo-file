package com.codegym.repository;

import com.codegym.model.Product;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{

    List<Product> productList = new ArrayList<>();


    @Override
    public List<Product> findAll() {
        // demo read Json Object
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("/Users/nguyenkhanhtung/Documents/products.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray productList1 = (JSONArray) obj;

            //Iterate over products array
            for (int i=0; i< productList1.size(); i++){
                Product p = parseProductObject((JSONObject)productList1.get(i));
                productList.add(p);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public void add(Product product) {

        //demo write json object

        JSONObject productDetail = new JSONObject();
        productDetail.put("id", String.valueOf(product.getId()));
        productDetail.put("name", product.getName());
        productDetail.put("price", String.valueOf(product.getPrice()));

        JSONObject productObject = new JSONObject();
        productObject.put("product", productDetail);

        //Add product to list
        JSONArray productList = new JSONArray();
        productList.add(productObject);

        //Write JSON file
        try (FileWriter file = new FileWriter("/Users/nguyenkhanhtung/Documents/products.json")) {

            file.write(productList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Product parseProductObject(JSONObject product)
    {

        Product product1 = new Product();
        //Get product object within list
        JSONObject productObject = (JSONObject) product.get("product");

        //Get id
        int id = Integer.parseInt(productObject.get("id").toString());
        product1.setId(id);

        //Get name
        String name = (String) productObject.get("name");
        product1.setName(name);

        //Get price
        Double price = Double.parseDouble(productObject.get("price").toString());
        product1.setPrice(price);

        return product1;


    }
}
