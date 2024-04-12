package com.mycompany.aed;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexionMongoDB {
    private MongoClient mongoClient;
    private MongoDatabase database;

    public ConexionMongoDB() {
        // Establece la conexión con MongoDB
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/AED");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        mongoClient = MongoClients.create(settings);

        // Obtiene una instancia de la base de datos
        database = mongoClient.getDatabase("AED");
    }

    // Métodos para obtener el cliente o la base de datos, si es necesario

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    // Método para cerrar la conexión cuando ya no sea necesaria
    public void cerrarConexion() {
        mongoClient.close();
    }

    public static void main(String[] args) {
        ConexionMongoDB conexionMongoDB = new ConexionMongoDB();

        // Ejemplo de uso: obtener la base de datos
        MongoDatabase database = conexionMongoDB.getDatabase();
        System.out.println("Conexión establecida con la base de datos: " + database.getName());

        // Cierra la conexión cuando ya no sea necesaria
        conexionMongoDB.cerrarConexion();
    }
}

